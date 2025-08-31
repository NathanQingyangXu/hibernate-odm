package org.hibernate.odm.dialect

import org.hibernate.dialect.DatabaseVersion
import org.hibernate.dialect.Dialect
import org.hibernate.dialect.SimpleDatabaseVersion
import org.hibernate.odm.util.MongoConstants

internal class MongoDialect(databaseVersion: DatabaseVersion?) : Dialect(databaseVersion) {
  constructor() : this(null)

  override fun getMinimumSupportedVersion(): DatabaseVersion =
      SimpleDatabaseVersion(MongoConstants.MINIMUM_SUPPORTED_MONGO_VERSION, 0, 0)
}
