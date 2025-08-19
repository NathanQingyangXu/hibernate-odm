package org.hibernate.odm.engine

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider
import org.hibernate.odm.cfg.MongoSettings
import org.hibernate.odm.service.MongoClientConfigurator
import org.hibernate.service.spi.Configurable
import org.hibernate.service.spi.InjectService
import org.hibernate.service.spi.Startable
import org.hibernate.service.spi.Stoppable
import java.sql.Connection

class MongoConnectionProvider : ConnectionProvider, Configurable, Startable, Stoppable {
    val clientSettingsBuilder: MongoClientSettings.Builder = MongoClientSettings.builder()
    var database: String? = null
    var mongoClient: MongoClient? = null

    override fun getConnection(): Connection {
        TODO("Not yet implemented")
    }

    override fun closeConnection(conn: Connection) {
        TODO("Not yet implemented")
    }

    override fun supportsAggressiveRelease(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isUnwrappableAs(clazz: Class<*>): Boolean {
        TODO("Not yet implemented")
    }

    override fun <T : Any> unwrap(clazz: Class<T>): T {
        TODO("Not yet implemented")
    }

    override fun configure(configurationValues: Map<String, Any>) {
        (configurationValues.get(MongoSettings.MONGODB_URI.name) as String).let {
            val connectionString = ConnectionString(it)
            clientSettingsBuilder.applyConnectionString(connectionString)
            database = connectionString.database
        }
    }

    @InjectService(required = false)
    fun injectMongoClientConfigurator(mongoClientConfigurator: MongoClientConfigurator?) {
        mongoClientConfigurator?.config(clientSettingsBuilder)
    }

    override fun start() {
        mongoClient = MongoClients.create(clientSettingsBuilder.build())
    }

    override fun stop() {
        mongoClient!!.close()
    }
}