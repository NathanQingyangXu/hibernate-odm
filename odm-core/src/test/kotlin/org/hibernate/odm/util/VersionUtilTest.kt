package org.hibernate.odm.util

import kotlin.test.Test
import org.assertj.core.api.Assertions.assertThat

class VersionUtilTest {

  @Test
  fun `when version text delimiter is comma, it could be parsed successfully`() {
    val text = "1.0.0-SNAPSHOT"
    val version: Version = VersionUtil.parseVersions(text)
    assertThat(version).isEqualTo(Version(1, 0, text))
  }

  @Test
  fun `when version text delimiter is hyphen, it could be parsed successfully`() {
    val text = "1-0-0.SNAPSHOT"
    val version: Version = VersionUtil.parseVersions(text)
    assertThat(version).isEqualTo(Version(1, 0, text))
  }

  @Test
  fun `getOdmVersion() should work successfully`() {
    val odmVersion = VersionUtil.getOdmVersion()
    assertThat(odmVersion.major).isNotNull
    assertThat(odmVersion.minor).isNotNull
  }
}
