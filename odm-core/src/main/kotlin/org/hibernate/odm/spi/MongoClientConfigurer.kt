package org.hibernate.odm.spi

import com.mongodb.MongoClientSettings
import org.hibernate.service.Service

fun interface MongoClientConfigurer : Service {
  fun config(clientSettingsBuilder: MongoClientSettings.Builder)
}
