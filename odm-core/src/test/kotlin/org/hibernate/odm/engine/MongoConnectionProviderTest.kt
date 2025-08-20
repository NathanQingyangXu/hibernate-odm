package org.hibernate.odm.engine

import org.hibernate.cfg.Configuration
import org.hibernate.odm.cfg.MongoSettings.Companion.MONGODB_URI
import org.hibernate.odm.dialect.MongoDialect
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.test.Test

class MongoConnectionProviderTest {

    companion object {
        const val HIBERNATE_DIALECT = "hibernate.dialect"
        const val HIBERNATE_CONNECTION_PROVIDER_CLASS = "hibernate.connection.provider_class"
        const val HIBERNATE_BOOT_ALLOW_JDBC_METADATA_ACCESS = "hibernate.boot.allow_jdbc_metadata_access"
    }

    @Test
    fun testSessionFactoryCanBeLaunchedSuccessfully() {
        val configuration = Configuration().apply {

            // enabling JDBC metadata access requires JDBC connection
            setProperty(HIBERNATE_BOOT_ALLOW_JDBC_METADATA_ACCESS, false)

            setProperty(HIBERNATE_DIALECT, MongoDialect::class.qualifiedName)
            setProperty(HIBERNATE_CONNECTION_PROVIDER_CLASS, MongoConnectionProvider::class.qualifiedName)
            setProperty(MONGODB_URI, "mongodb://localhost:27017/hibernate-odm-test")
        }
        assertDoesNotThrow { configuration.buildSessionFactory() }
    }
}