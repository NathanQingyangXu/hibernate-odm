package org.hibernate.odm.jdbc

internal abstract class AbstractCloseable {
    private var closed: Boolean = false

    fun isClosed() = closed

    fun close() {
        if (!closed) {
            try {
                closeActually()
                closed = true
            } catch (e: Exception) {
                //todo logging in error level
            }
        }
    }

    abstract fun closeActually()
}