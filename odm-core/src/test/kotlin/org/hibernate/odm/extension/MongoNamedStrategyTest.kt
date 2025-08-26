package org.hibernate.odm.extension

import kotlin.test.Test
import org.hibernate.cfg.Configuration
import org.hibernate.cfg.JdbcSettings.ALLOW_METADATA_ON_BOOT
import org.hibernate.cfg.JdbcSettings.CONNECTION_PROVIDER
import org.hibernate.cfg.JdbcSettings.DIALECT
import org.hibernate.odm.cfg.MongoSettings.MONGODB_URI
import org.hibernate.odm.util.MongoConstants.MONGO_CONNECTION_PROVIDER_SHORT_NAME
import org.hibernate.odm.util.MongoConstants.MONGO_DIALOG_SHORT_NAME
import org.junit.jupiter.api.assertDoesNotThrow

class MongoNamedStrategyTest {

  @Test
  fun `test mongo short name strategy extension works`() {
    val configuration =
        Configuration()
            .setProperty(DIALECT, MONGO_DIALOG_SHORT_NAME)
            .setProperty(CONNECTION_PROVIDER, MONGO_CONNECTION_PROVIDER_SHORT_NAME)
            .setProperty(ALLOW_METADATA_ON_BOOT, false)
            .setProperty(MONGODB_URI, "mongodb://localhost:27017/hibernate-odm-test")

    assertDoesNotThrow { configuration.buildSessionFactory() }
  }
}
