package org.hibernate.odm.jdbc

import java.io.InputStream
import java.io.Reader
import java.math.BigDecimal
import java.net.URL
import java.sql.Blob
import java.sql.Clob
import java.sql.Date
import java.sql.NClob
import java.sql.ParameterMetaData
import java.sql.PreparedStatement
import java.sql.Ref
import java.sql.ResultSet
import java.sql.ResultSetMetaData
import java.sql.RowId
import java.sql.SQLFeatureNotSupportedException
import java.sql.SQLXML
import java.sql.Time
import java.sql.Timestamp
import java.util.Calendar

sealed interface PreparedStatementAdapter : PreparedStatement, StatementAdapter {
    override fun executeQuery(): ResultSet {
        throw SQLFeatureNotSupportedException()
    }

    override fun executeUpdate(): Int {
        throw SQLFeatureNotSupportedException()
    }

    override fun setNull(parameterIndex: Int, sqlType: Int) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setBoolean(parameterIndex: Int, x: Boolean) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setByte(parameterIndex: Int, x: Byte) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setShort(parameterIndex: Int, x: Short) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setInt(parameterIndex: Int, x: Int) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setLong(parameterIndex: Int, x: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setFloat(parameterIndex: Int, x: Float) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setDouble(parameterIndex: Int, x: Double) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setBigDecimal(parameterIndex: Int, x: BigDecimal) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setString(parameterIndex: Int, x: String) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setBytes(parameterIndex: Int, x: ByteArray) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setDate(parameterIndex: Int, x: Date) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setTime(parameterIndex: Int, x: Time) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setTimestamp(parameterIndex: Int, x: Timestamp) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setAsciiStream(parameterIndex: Int, x: InputStream, length: Int) {
        throw SQLFeatureNotSupportedException()
    }

    @Deprecated("Deprecated in Java")
    override fun setUnicodeStream(parameterIndex: Int, x: InputStream, length: Int) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setBinaryStream(parameterIndex: Int, x: InputStream, length: Int) {
        throw SQLFeatureNotSupportedException()
    }

    override fun clearParameters() {
        throw SQLFeatureNotSupportedException()
    }

    override fun setObject(parameterIndex: Int, x: Any, targetSqlType: Int) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setObject(parameterIndex: Int, x: Any) {
        throw SQLFeatureNotSupportedException()
    }

    override fun execute(): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun addBatch() {
        throw SQLFeatureNotSupportedException()
    }

    override fun setCharacterStream(parameterIndex: Int, reader: Reader, length: Int) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setRef(parameterIndex: Int, x: Ref) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setBlob(parameterIndex: Int, x: Blob) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setClob(parameterIndex: Int, x: Clob) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setArray(parameterIndex: Int, x: java.sql.Array) {
        throw SQLFeatureNotSupportedException()
    }

    override fun getMetaData(): ResultSetMetaData? {
        throw SQLFeatureNotSupportedException()
    }

    override fun setDate(parameterIndex: Int, x: Date, cal: Calendar) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setTime(parameterIndex: Int, x: Time, cal: Calendar) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setTimestamp(parameterIndex: Int, x: Timestamp, cal: Calendar) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setNull(parameterIndex: Int, sqlType: Int, typeName: String) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setURL(parameterIndex: Int, x: URL) {
        throw SQLFeatureNotSupportedException()
    }

    override fun getParameterMetaData(): ParameterMetaData {
        throw SQLFeatureNotSupportedException()
    }

    override fun setRowId(parameterIndex: Int, x: RowId) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setNString(parameterIndex: Int, value: String) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setNCharacterStream(parameterIndex: Int, value: Reader, length: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setNClob(parameterIndex: Int, value: NClob) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setClob(parameterIndex: Int, reader: Reader, length: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setBlob(parameterIndex: Int, inputStream: InputStream, length: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setNClob(parameterIndex: Int, reader: Reader, length: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setSQLXML(parameterIndex: Int, xmlObject: SQLXML) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setObject(
        parameterIndex: Int,
        x: Any,
        targetSqlType: Int,
        scaleOrLength: Int
    ) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setAsciiStream(parameterIndex: Int, x: InputStream, length: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setBinaryStream(parameterIndex: Int, x: InputStream, length: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setCharacterStream(parameterIndex: Int, reader: Reader, length: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setAsciiStream(parameterIndex: Int, x: InputStream) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setBinaryStream(parameterIndex: Int, x: InputStream) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setCharacterStream(parameterIndex: Int, reader: Reader) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setNCharacterStream(parameterIndex: Int, value: Reader) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setClob(parameterIndex: Int, reader: Reader) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setBlob(parameterIndex: Int, inputStream: InputStream) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setNClob(parameterIndex: Int, reader: Reader) {
        throw SQLFeatureNotSupportedException()
    }
}
