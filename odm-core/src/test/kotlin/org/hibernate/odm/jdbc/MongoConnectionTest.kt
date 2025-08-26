package org.hibernate.odm.jdbc

import com.mongodb.client.ClientSession
import com.mongodb.client.MongoClient
import io.mockk.MockKAnnotations
import io.mockk.Runs
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.just
import java.sql.SQLException
import kotlin.test.Test
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertAll

class MongoConnectionTest {

  @MockK private var client: MongoClient? = null
  @MockK private var clientSession: ClientSession? = null

  private var mongoConnection: MongoConnection? = null

  @BeforeEach
  fun setUp() {
    MockKAnnotations.init(this)
    val nonNullClient = checkNotNull(client)
    val nonNullClientSession = checkNotNull(clientSession)
    every { nonNullClientSession.close() } just Runs
    every { nonNullClient.startSession() } returns nonNullClientSession
    mongoConnection = MongoConnection(nonNullClient).also { it.close() }
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
    assertThatThrownBy(executable)
        .isExactlyInstanceOf(SQLException::class.java)
        .hasMessage("this MongoConnection instance has been closed already")
  }
}
