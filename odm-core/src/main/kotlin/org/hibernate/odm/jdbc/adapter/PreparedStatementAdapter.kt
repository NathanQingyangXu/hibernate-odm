package org.hibernate.odm.jdbc.adapter

import java.io.InputStream
import java.io.Reader
import java.math.BigDecimal
import java.net.URL
import java.sql.Array
import java.sql.Blob
import java.sql.Clob
import java.sql.Connection
import java.sql.Date
import java.sql.NClob
import java.sql.ParameterMetaData
import java.sql.PreparedStatement
import java.sql.Ref
import java.sql.ResultSet
import java.sql.ResultSetMetaData
import java.sql.RowId
import java.sql.SQLFeatureNotSupportedException
import java.sql.SQLWarning
import java.sql.SQLXML
import java.sql.Time
import java.sql.Timestamp
import java.util.Calendar

interface PreparedStatementAdapter : PreparedStatement, StatementAdapter {
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

    override fun setArray(parameterIndex: Int, x: Array) {
        throw SQLFeatureNotSupportedException()
    }

    override fun getMetaData(): ResultSetMetaData {
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

    override fun executeQuery(sql: String): ResultSet {
        throw SQLFeatureNotSupportedException()
    }

    override fun executeUpdate(sql: String): Int {
        throw SQLFeatureNotSupportedException()
    }

    override fun close() {
        throw SQLFeatureNotSupportedException()
    }

    override fun getMaxFieldSize(): Int {
        throw SQLFeatureNotSupportedException()
    }

    override fun setMaxFieldSize(max: Int) {
        throw SQLFeatureNotSupportedException()
    }

    override fun getMaxRows(): Int {
        throw SQLFeatureNotSupportedException()
    }

    override fun setMaxRows(max: Int) {
        throw SQLFeatureNotSupportedException()
    }

    override fun setEscapeProcessing(enable: Boolean) {
        throw SQLFeatureNotSupportedException()
    }

    override fun getQueryTimeout(): Int {
        throw SQLFeatureNotSupportedException()
    }

    override fun setQueryTimeout(seconds: Int) {
        throw SQLFeatureNotSupportedException()
    }

    override fun cancel() {
        throw SQLFeatureNotSupportedException()
    }

    override fun getWarnings(): SQLWarning {
        throw SQLFeatureNotSupportedException()
    }

    override fun clearWarnings() {
        throw SQLFeatureNotSupportedException()
    }

    override fun setCursorName(name: String) {
        throw SQLFeatureNotSupportedException()
    }

    override fun execute(sql: String): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun getResultSet(): ResultSet {
        throw SQLFeatureNotSupportedException()
    }

    override fun getUpdateCount(): Int {
        throw SQLFeatureNotSupportedException()
    }

    override fun getMoreResults(): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun setFetchDirection(direction: Int) {
        throw SQLFeatureNotSupportedException()
    }

    override fun getFetchDirection(): Int {
        throw SQLFeatureNotSupportedException()
    }

    override fun setFetchSize(rows: Int) {
        throw SQLFeatureNotSupportedException()
    }

    override fun getFetchSize(): Int {
        throw SQLFeatureNotSupportedException()
    }

    override fun getResultSetConcurrency(): Int {
        throw SQLFeatureNotSupportedException()
    }

    override fun getResultSetType(): Int {
        throw SQLFeatureNotSupportedException()
    }

    override fun addBatch(sql: String) {
        throw SQLFeatureNotSupportedException()
    }

    override fun clearBatch() {
        throw SQLFeatureNotSupportedException()
    }

    override fun executeBatch(): IntArray {
        throw SQLFeatureNotSupportedException()
    }

    override fun getConnection(): Connection {
        throw SQLFeatureNotSupportedException()
    }

    override fun getMoreResults(current: Int): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun getGeneratedKeys(): ResultSet {
        throw SQLFeatureNotSupportedException()
    }

    override fun executeUpdate(sql: String, autoGeneratedKeys: Int): Int {
        throw SQLFeatureNotSupportedException()
    }

    override fun executeUpdate(sql: String, columnIndexes: IntArray): Int {
        throw SQLFeatureNotSupportedException()
    }

    override fun executeUpdate(sql: String, columnNames: kotlin.Array<out String>): Int {
        throw SQLFeatureNotSupportedException()
    }

    override fun execute(sql: String, autoGeneratedKeys: Int): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun execute(sql: String, columnIndexes: IntArray): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun execute(sql: String, columnNames: kotlin.Array<out String>): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun getResultSetHoldability(): Int {
        throw SQLFeatureNotSupportedException()
    }

    override fun isClosed(): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun setPoolable(poolable: Boolean) {
        throw SQLFeatureNotSupportedException()
    }

    override fun isPoolable(): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun closeOnCompletion() {
        throw SQLFeatureNotSupportedException()
    }

    override fun isCloseOnCompletion(): Boolean {
        throw SQLFeatureNotSupportedException()
    }
}