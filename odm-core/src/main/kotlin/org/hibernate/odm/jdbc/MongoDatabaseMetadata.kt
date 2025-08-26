package org.hibernate.odm.jdbc

import java.sql.Connection
import java.sql.DatabaseMetaData
import java.sql.ResultSet
import org.hibernate.odm.util.MongoConstants
import org.hibernate.odm.util.Version

internal class MongoDatabaseMetadata(
    private val connection: MongoConnection,
    private val mongoVersion: Version,
    private val odmVersion: Version
) : DatabaseMetadataAdapter {
  override fun getDatabaseProductName(): String = MongoConstants.MONGO_DBMS_NAME

  override fun getDatabaseProductVersion(): String = mongoVersion.text

  override fun getDriverName(): String = MongoConstants.MONGO_JDBC_DRIVER_NAME

  override fun getDriverVersion(): String = odmVersion.text

  override fun getDriverMajorVersion(): Int = odmVersion.major

  override fun getDriverMinorVersion(): Int = odmVersion.minor

  override fun getSQLKeywords(): String = ""

  override fun isCatalogAtStart(): Boolean = true

  override fun getCatalogSeparator(): String = "."

  override fun supportsSchemasInTableDefinitions(): Boolean = false

  override fun supportsCatalogsInTableDefinitions(): Boolean = false

  override fun dataDefinitionCausesTransactionCommit(): Boolean = false

  override fun dataDefinitionIgnoredInTransactions(): Boolean = false

  override fun supportsResultSetType(type: Int): Boolean = (type == ResultSet.TYPE_FORWARD_ONLY)

  override fun supportsBatchUpdates(): Boolean = true

  override fun getConnection(): Connection = connection

  override fun supportsNamedParameters(): Boolean = false

  override fun supportsGetGeneratedKeys(): Boolean = false

  override fun getDatabaseMajorVersion(): Int = mongoVersion.major

  override fun getDatabaseMinorVersion(): Int = mongoVersion.minor

  override fun getJDBCMajorVersion(): Int = MongoConstants.JDBC_API_MAJOR_VERSION

  override fun getJDBCMinorVersion(): Int = MongoConstants.JDBC_API_MINOR_VERTSION

  override fun getSQLStateType(): Int = DatabaseMetaData.sqlStateSQL
}
