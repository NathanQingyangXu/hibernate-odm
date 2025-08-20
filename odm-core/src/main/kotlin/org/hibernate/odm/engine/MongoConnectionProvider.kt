package org.hibernate.odm.engine

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoDatabase
import io.github.oshai.kotlinlogging.KotlinLogging
import org.hibernate.HibernateException
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider
import org.hibernate.odm.cfg.MongoSettings.Companion.MONGODB_URI
import org.hibernate.odm.service.MongoClientConfigurator
import org.hibernate.service.UnknownServiceException
import org.hibernate.service.spi.Configurable
import org.hibernate.service.spi.ServiceRegistryAwareService
import org.hibernate.service.spi.ServiceRegistryImplementor
import org.hibernate.service.spi.Startable
import org.hibernate.service.spi.Stoppable
import java.sql.Connection

class MongoConnectionProvider : ConnectionProvider, Configurable, Startable, Stoppable, ServiceRegistryAwareService {
    companion object {
        @JvmStatic
        private val logger = KotlinLogging.logger {}
    }

    private val clientSettingsBuilder = MongoClientSettings.builder()

    private var mongoClient: MongoClient? = null
    private var mongoDatabase: MongoDatabase? = null
    private var mongoDatabaseName: String? = null

    override fun getConnection(): Connection {
        TODO("Not yet implemented")
    }

    override fun closeConnection(conn: Connection) {
        conn.close()
    }

    override fun supportsAggressiveRelease() = false
    override fun isUnwrappableAs(clazz: Class<*>) = false
    override fun <T : Any> unwrap(clazz: Class<T>): Nothing = throw UnsupportedOperationException()

    override fun configure(configurationValues: Map<String, Any>) {
        val mongoUri = configurationValues[MONGODB_URI] ?: throw HibernateException("'$MONGODB_URI' setting is mandatory")
        val connectionString = ConnectionString(mongoUri as String)
        clientSettingsBuilder.applyConnectionString(connectionString)
        mongoDatabaseName = connectionString.database ?: throw HibernateException("database must be present in MongoDB connection string: $mongoUri")
    }

    override fun injectServices(serviceRegistry: ServiceRegistryImplementor) {
        try {
            serviceRegistry.getService(MongoClientConfigurator::class.java)?.apply {
                logger.info { "${MongoClientConfigurator::class.simpleName} service found" }
                config(clientSettingsBuilder)
                logger.info { "${MongoClientConfigurator::class.simpleName} service applied" }
            }
        } catch (_: UnknownServiceException) {
            logger.debug { "No ${MongoClientConfigurator::class.simpleName} service found" }
        }
    }

    override fun start() {
        mongoClient = MongoClients.create(clientSettingsBuilder.build())
            .also {
                mongoDatabase = it.getDatabase(checkNotNull(mongoDatabaseName))
            }
    }

    override fun stop() {
        checkNotNull(mongoClient).close()
    }

}