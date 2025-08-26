package org.hibernate.odm.jdbc

import kotlin.test.Test
import org.assertj.core.api.Assertions.assertThat

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
    assertThat(testCloseable.realClosingCount).isEqualTo(1)

    // when
    testCloseable.close()

    // then
    assertThat(testCloseable.realClosingCount).isEqualTo(1)
  }
}
