package org.hibernate.odm.jdbc

import com.mongodb.client.ClientSession
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import java.sql.SQLException
import kotlin.test.Test
import kotlin.test.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class MongoConnectionTest {

  private var mongoConnection: MongoConnection? = null

  @BeforeEach
  fun beforeEach() {
    val clientSession = mockk<ClientSession>()
    every { clientSession.close() } just Runs
    mongoConnection = MongoConnection(clientSession).also { it.close() }
  }

  @Test
  fun `JDBC API methods of MongoConnection throw exception when invoked on a closed connection`() {
    (mongoConnection ?: throw AssertionError("mongoConnection should have been set")).let {
      assertAll(
          { assertSqlException { it.createStatement() } },
          { assertSqlException { it.prepareStatement("") } },
          { assertSqlException { it.prepareCall("") } },
          { assertSqlException { it.setAutoCommit(false) } },
          { assertSqlException { it.getAutoCommit() } },
          { assertSqlException { it.commit() } },
          { assertSqlException { it.rollback() } },
          { assertSqlException { it.getMetaData() } },
          { assertSqlException { it.setTransactionIsolation(0) } },
          { assertSqlException { it.getTransactionIsolation() } },
          { assertSqlException { it.getWarnings() } },
          { assertSqlException { it.clearWarnings() } },
          { assertSqlException { it.prepareStatement("", 0, 0) } },
          { assertSqlException { it.prepareCall("", 0, 0) } },
          { assertSqlException { it.prepareStatement("", 0) } },
          { assertSqlException { it.prepareStatement("", arrayOf()) } },
          { assertSqlException { it.createClob() } },
          { assertSqlException { it.createBlob() } },
          { assertSqlException { it.createNClob() } },
          { assertSqlException { it.createSQLXML() } },
          { assertSqlException { it.createArrayOf("", arrayOf()) } },
          { assertSqlException { it.createStruct("", arrayOf()) } },
      )
    }
  }

  private fun assertSqlException(executable: () -> Unit) {
    val sqlException = assertThrows<SQLException>(executable)
    assertEquals(
        "this ${MongoConnection::class.java.simpleName} has been closed already",
        sqlException.message)
  }
}
