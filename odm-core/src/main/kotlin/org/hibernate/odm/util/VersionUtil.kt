package org.hibernate.odm.util

import java.util.Properties

internal object VersionUtil {

  const val ODM_PROPERTIES_RESOURCE_PATH = "odm.properties"
  const val ODM_VERSION_PROPERTY = "version"
  const val ODM_VERSION_MAJOR_PROPERTY = "version.major"
  const val ODM_VERSION_MINOR_PROPERTY = "version.minor"

  fun getOdmVersion(): Version {
    val classLoader = VersionUtil::class.java.classLoader
    val properties =
        classLoader.getResourceAsStream(ODM_PROPERTIES_RESOURCE_PATH).use {
          Properties().apply { load(it) }
        }
    val versionText = properties.getProperty(ODM_VERSION_PROPERTY) as String
    val versionMajor = properties.getProperty(ODM_VERSION_MAJOR_PROPERTY)?.toInt()
    val versionMinor = properties.getProperty(ODM_VERSION_MINOR_PROPERTY)?.toInt()
    return Version(versionMajor ?: 0, versionMinor ?: 0, versionText)
  }

  fun parseVersions(versionText: String): Version {
    val versionTextParts = versionText.split(".", "-")
    assert(
        versionTextParts.size >= 2,
        { "'$versionText' should contain both major and minor versions" })
    val versions = versionTextParts.subList(0, 2).map { Integer.parseInt(it) }
    return Version(major = versions.first(), minor = versions.last(), text = versionText)
  }
}
