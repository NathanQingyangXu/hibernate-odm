package org.hibernate.odm.jdbc

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoDatabase

@Suppress("UnusedPrivateProperty")
internal class MongoConnection(client: MongoClient, database: MongoDatabase) : AbstractCloseable(), ConnectionAdapter {
    private val clientSession = client.startSession()

    override fun closeActually() {
        clientSession.close()
    }
}
