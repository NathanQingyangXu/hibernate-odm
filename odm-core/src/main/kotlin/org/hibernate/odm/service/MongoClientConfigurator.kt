package org.hibernate.odm.service

import com.mongodb.MongoClientSettings
import org.hibernate.service.Service

fun interface MongoClientConfigurator : Service {
    fun config(builder: MongoClientSettings.Builder)
}