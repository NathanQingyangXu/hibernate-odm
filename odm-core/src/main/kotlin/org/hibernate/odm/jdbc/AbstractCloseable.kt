package org.hibernate.odm.jdbc

import io.github.oshai.kotlinlogging.KotlinLogging

internal abstract class AbstractCloseable {
    companion object {
        @JvmStatic
        private val logger = KotlinLogging.logger {}
    }

    private var closed: Boolean = false

    fun isClosed() = closed

    @Suppress("TooGenericExceptionCaught")
    fun close() {
        if (!closed) {
            try {
                closeActually()
                closed = true
            } catch (e: Exception) {
                logger.error { "failed to close $this: ${e.message}" }
                throw e
            }
        }
    }

    abstract fun closeActually()
}
