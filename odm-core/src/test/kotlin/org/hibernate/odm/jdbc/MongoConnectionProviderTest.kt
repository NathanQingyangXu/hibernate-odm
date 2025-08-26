package org.hibernate.odm.jdbc

import com.mongodb.client.internal.MongoClientImpl
import java.util.UUID
import kotlin.test.Test
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.cfg.AvailableSettings
import org.hibernate.cfg.Configuration
import org.hibernate.cfg.JdbcSettings.CONNECTION_PROVIDER
import org.hibernate.cfg.JdbcSettings.DIALECT
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider
import org.hibernate.internal.SessionFactoryImpl
import org.hibernate.odm.cfg.MongoSettings
import org.hibernate.odm.dialect.MongoDialect
import org.hibernate.odm.service.MongoClientConfigurator
import org.hibernate.service.spi.ServiceException
import org.junit.jupiter.api.assertDoesNotThrow

class MongoConnectionProviderTest {

  @Test
  fun `test SessionFactory can be built successfully`() {
    val configuration =
        configurationWithDefaultsProperties().apply {
          // enabling JDBC metadata access requires JDBC connection
          setProperty(AvailableSettings.ALLOW_METADATA_ON_BOOT, false)
          setProperty(MongoSettings.MONGODB_URI, "mongodb://localhost:27017/hibernate-odm-test")
        }
    assertDoesNotThrow { configuration.buildSessionFactory() }
  }

  @Test
  fun `test MongoUri settings must be present`() {
    assertThatThrownBy({ configurationWithDefaultsProperties().buildSessionFactory() })
        .isExactlyInstanceOf(ServiceException::class.java)
        .hasRootCauseMessage("'${MongoSettings.MONGODB_URI}' setting is mandatory")
  }

  @Test
  fun `test MongoUri settings must contain database`() {
    val connectionStringWithoutDatabase = "mongodb://localhost:27017"
    val configuration =
        configurationWithDefaultsProperties().apply {
          setProperty(MongoSettings.MONGODB_URI, connectionStringWithoutDatabase)
        }
    assertThatThrownBy({ configuration.buildSessionFactory() })
        .isExactlyInstanceOf(ServiceException::class.java)
        .hasRootCauseMessage(
            "database must be present in MongoDB connection string: $connectionStringWithoutDatabase")
  }

  @Test
  fun `test MongoClientConfigurator is applied successfully`() {
    val configuration =
        configurationWithDefaultsProperties().apply {
          // enabling JDBC metadata access requires JDBC connection
          setProperty(AvailableSettings.ALLOW_METADATA_ON_BOOT, false)
          setProperty(MongoSettings.MONGODB_URI, "mongodb://localhost:27017/hibernate-odm-test")
        }

    val applicationName = UUID.randomUUID().toString()
    val applicationNameConfigurator = MongoClientConfigurator {
      it.applicationName(applicationName)
    }

    val serviceRegistry =
        StandardServiceRegistryBuilder()
            .applySettings(configuration.properties)
            .addService(MongoClientConfigurator::class.java, applicationNameConfigurator)
            .build()

    val sessionFactoryImpl = assertDoesNotThrow {
      configuration.buildSessionFactory(serviceRegistry) as SessionFactoryImpl
    }
    val mongoConnectionProvider =
        sessionFactoryImpl.serviceRegistry.getService(ConnectionProvider::class.java)
            as MongoConnectionProvider

    val clientSettings = (mongoConnectionProvider.mongoClient as MongoClientImpl).settings
    assertThat(clientSettings.applicationName).isEqualTo(applicationName)
  }

  @Test
  fun `test MongoDB driver information is passed to the created MongoClient`() {
    val driverInformation = MongoConnectionProvider.fetchMongoDriverInformation()
    assertThat(driverInformation.driverNames).isNotEmpty()
    assertThat(driverInformation.driverVersions).isNotEmpty()

    val configuration =
        configurationWithDefaultsProperties().apply {
          // enabling JDBC metadata access requires JDBC connection
          setProperty(AvailableSettings.ALLOW_METADATA_ON_BOOT, false)
          setProperty(MongoSettings.MONGODB_URI, "mongodb://localhost:27017/hibernate-odm-test")
        }
    val sessionFactoryImpl = assertDoesNotThrow {
      configuration.buildSessionFactory() as SessionFactoryImpl
    }
    val mongoConnectionProvider =
        sessionFactoryImpl.serviceRegistry.getService(ConnectionProvider::class.java)
            as MongoConnectionProvider

    val mongoClient = (mongoConnectionProvider.mongoClient as MongoClientImpl)

    // additional info could be added implicitly by driver (e.g. `sync` driver name)
    assertThat(mongoClient.mongoDriverInformation.driverNames)
        .containsAll(driverInformation.driverNames)
    assertThat(mongoClient.mongoDriverInformation.driverVersions)
        .containsAll(driverInformation.driverVersions)
  }

  fun configurationWithDefaultsProperties(): Configuration =
      Configuration()
          .setProperty(DIALECT, MongoDialect::class.qualifiedName)
          .setProperty(CONNECTION_PROVIDER, MongoConnectionProvider::class.qualifiedName)
}
