package org.hibernate.odm.jdbc

import kotlin.test.Test
import kotlin.test.assertEquals

class AbstractCloseableTest {

  internal class TestCloseable : AbstractCloseable() {
    var realClosingCount: Int = 0

    override fun closeActually() {
      realClosingCount++
    }
  }

  @Test
  fun `closing an AbstractCloseable object which has been closed is a no-op`() {
    // given
    val testCloseable = TestCloseable()
    testCloseable.close()
    assertEquals(1, testCloseable.realClosingCount)

    // when
    testCloseable.close()

    // then
    assertEquals(1, testCloseable.realClosingCount)
  }
}
