package org.hibernate.odm.extension

import org.hibernate.cfg.AvailableSettings
import org.hibernate.cfg.Configuration
import org.hibernate.odm.cfg.MongoSettings
import org.hibernate.odm.util.MongoConstants.MONGO_CONNECTION_PROVIDER_SHORT_NAME
import org.hibernate.odm.util.MongoConstants.MONGO_DIALOG_SHORT_NAME
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.test.Test

class MongoNamedStrategyTest {

    @Test
    fun `test mongo short name strategy extension works`() {
        val configuration = Configuration().apply {
            setProperty(AvailableSettings.DIALECT, MONGO_DIALOG_SHORT_NAME)
            setProperty(AvailableSettings.CONNECTION_PROVIDER, MONGO_CONNECTION_PROVIDER_SHORT_NAME)
            setProperty(AvailableSettings.ALLOW_METADATA_ON_BOOT, false)
            setProperty(MongoSettings.MONGODB_URI, "mongodb://localhost:27017/hibernate-odm-test")
        }
        assertDoesNotThrow { configuration.buildSessionFactory() }
    }
}
