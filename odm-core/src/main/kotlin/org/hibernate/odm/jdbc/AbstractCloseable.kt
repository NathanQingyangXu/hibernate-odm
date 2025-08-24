package org.hibernate.odm.jdbc

import io.github.oshai.kotlinlogging.KotlinLogging
import java.sql.SQLException

internal abstract class AbstractCloseable {
  companion object {
    @JvmStatic private val logger = KotlinLogging.logger {}
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

  /**
   * The first statement to be invoked in all overridden JDBC API methods in child class of
   * [AbstractCloseable]
   */
  internal fun ensureNotClosed() {
    if (closed) {
      throw SQLException("this ${javaClass.simpleName} has been closed already")
    }
  }

  /**
   * The method to be invoked internally by [close] when rest assured it has not been closed already
   */
  abstract fun closeActually()
}
