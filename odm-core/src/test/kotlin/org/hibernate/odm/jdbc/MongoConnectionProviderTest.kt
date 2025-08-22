package org.hibernate.odm.jdbc

import com.mongodb.client.internal.MongoClientImpl
import org.hibernate.HibernateException
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.cfg.AvailableSettings
import org.hibernate.cfg.Configuration
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider
import org.hibernate.internal.SessionFactoryImpl
import org.hibernate.odm.cfg.MongoSettings
import org.hibernate.odm.dialect.MongoDialect
import org.hibernate.odm.service.MongoClientConfigurator
import org.hibernate.service.spi.ServiceException
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertInstanceOf
import org.junit.jupiter.api.assertThrows
import java.util.UUID
import kotlin.test.Test
import kotlin.test.assertEquals

class MongoConnectionProviderTest {

    @Test
    fun `test SessionFactory can be built successfully`() {
        val configuration = configurationWithDefaultsProperties().apply {
            // enabling JDBC metadata access requires JDBC connection
            setProperty(AvailableSettings.ALLOW_METADATA_ON_BOOT, false)
            setProperty(MongoSettings.MONGODB_URI, "mongodb://localhost:27017/hibernate-odm-test")
        }
        assertDoesNotThrow { configuration.buildSessionFactory() }
    }

    @Test
    fun `test MongoUri settings must be present`() {
        val serviceException = assertThrows<ServiceException> {
            configurationWithDefaultsProperties().buildSessionFactory()
        }
        assertServiceException(serviceException, "'${MongoSettings.MONGODB_URI}' setting is mandatory")
    }

    @Test
    fun `test MongoUri settings must contain database`() {
        val connectionStringWithoutDatabase = "mongodb://localhost:27017"
        val configuration = configurationWithDefaultsProperties().apply {
            setProperty(MongoSettings.MONGODB_URI, connectionStringWithoutDatabase)
        }
        val serviceException = assertThrows<ServiceException> { configuration.buildSessionFactory() }
        assertServiceException(
            serviceException,
            "database must be present in MongoDB connection string: $connectionStringWithoutDatabase"
        )
    }

    @Test
    fun `test MongoClientConfigurator is applied successfully`() {
        val configuration = configurationWithDefaultsProperties().apply {
            // enabling JDBC metadata access requires JDBC connection
            setProperty(AvailableSettings.ALLOW_METADATA_ON_BOOT, false)
            setProperty(MongoSettings.MONGODB_URI, "mongodb://localhost:27017/hibernate-odm-test")
        }

        val applicationName = UUID.randomUUID().toString()
        val applicationNameConfigurator = MongoClientConfigurator {
            it.applicationName(applicationName)
        }

        val serviceRegistry = StandardServiceRegistryBuilder()
            .applySettings(configuration.properties)
            .addService(MongoClientConfigurator::class.java, applicationNameConfigurator).build()

        val sessionFactoryImpl =
            assertDoesNotThrow { configuration.buildSessionFactory(serviceRegistry) as SessionFactoryImpl }
        val mongoConnectionProvider =
            sessionFactoryImpl.serviceRegistry.getService(ConnectionProvider::class.java) as MongoConnectionProvider
        val clientSettings = (mongoConnectionProvider.mongoClient as MongoClientImpl).settings
        assertEquals(applicationName, clientSettings.applicationName)
    }

    fun configurationWithDefaultsProperties(): Configuration =
        Configuration()
            .setProperty(AvailableSettings.DIALECT, MongoDialect::class.qualifiedName)
            .setProperty(AvailableSettings.CONNECTION_PROVIDER, MongoConnectionProvider::class.qualifiedName)

    fun assertServiceException(serviceException: ServiceException, expectedRootMessage: String) {
        val cause = assertInstanceOf<HibernateException>(serviceException.cause)
        assertEquals(expectedRootMessage, cause.message)
    }
}
