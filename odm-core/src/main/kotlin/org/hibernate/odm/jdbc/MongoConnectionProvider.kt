package org.hibernate.odm.jdbc

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.MongoDriverInformation
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoDatabase
import io.github.oshai.kotlinlogging.KotlinLogging
import org.hibernate.HibernateException
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider
import org.hibernate.odm.cfg.MongoSettings
import org.hibernate.odm.service.MongoClientConfigurator
import org.hibernate.service.UnknownServiceException
import org.hibernate.service.spi.Configurable
import org.hibernate.service.spi.ServiceRegistryAwareService
import org.hibernate.service.spi.ServiceRegistryImplementor
import org.hibernate.service.spi.Startable
import org.hibernate.service.spi.Stoppable
import java.sql.Connection
import java.util.Properties

class MongoConnectionProvider : ConnectionProvider, Configurable, Startable, Stoppable, ServiceRegistryAwareService {
    companion object {
        @JvmStatic
        private val logger = KotlinLogging.logger {}
    }

    private val clientSettingsBuilder = MongoClientSettings.builder()

    internal var mongoClient: MongoClient? = null

    private var mongoDatabaseName: String? = null

    private var mongoDatabase: MongoDatabase? = null

    override fun getConnection(): Connection = MongoConnection(
        client = checkNotNull(mongoClient), database = checkNotNull(mongoDatabase)
    )

    override fun closeConnection(conn: Connection) {
        conn.close()
    }

    override fun supportsAggressiveRelease() = false
    override fun isUnwrappableAs(clazz: Class<*>) = false
    override fun <T : Any> unwrap(clazz: Class<T>): Nothing = throw UnsupportedOperationException()

    override fun configure(configurationValues: Map<String, Any>) {
        val mongoUri = configurationValues[MongoSettings.MONGODB_URI]
            ?: throw HibernateException("'${MongoSettings.MONGODB_URI}' setting is mandatory")
        val connectionString = ConnectionString(mongoUri as String)
        clientSettingsBuilder.applyConnectionString(connectionString)
        mongoDatabaseName = connectionString.database
            ?: throw HibernateException("database must be present in MongoDB connection string: $mongoUri")
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
        val mongoDriverInformation = fetchMongoDriverInformation()
        mongoClient = MongoClients.create(clientSettingsBuilder.build(), mongoDriverInformation)
            .also { mongoDatabase = it.getDatabase(checkNotNull(mongoDatabaseName)) }
    }

    override fun stop() {
        checkNotNull(mongoClient).close()
    }

    fun fetchMongoDriverInformation(): MongoDriverInformation {
        val properties  = javaClass.classLoader.getResourceAsStream("driver.properties").use {
            Properties().apply { load(it) }
        }
        val driverInfoBuilder = MongoDriverInformation.builder()
            .driverName(properties.getProperty("driver.name"))
            .driverVersion(properties.getProperty("driver.version"))
        return driverInfoBuilder.build()
    }
}
