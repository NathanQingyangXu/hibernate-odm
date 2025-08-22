package org.hibernate.odm.jdbc

import java.io.InputStream
import java.io.Reader
import java.math.BigDecimal
import java.net.URL
import java.sql.Array
import java.sql.Blob
import java.sql.Clob
import java.sql.Date
import java.sql.NClob
import java.sql.Ref
import java.sql.ResultSet
import java.sql.ResultSetMetaData
import java.sql.RowId
import java.sql.SQLFeatureNotSupportedException
import java.sql.SQLWarning
import java.sql.SQLXML
import java.sql.Statement
import java.sql.Time
import java.sql.Timestamp
import java.util.Calendar

sealed interface ResultSetAdapter : ResultSet, WrapperAdapter {
    override fun next(): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun wasNull(): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun getString(columnIndex: Int): String? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getBoolean(columnIndex: Int): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun getByte(columnIndex: Int): Byte {
        throw SQLFeatureNotSupportedException()
    }

    override fun getShort(columnIndex: Int): Short {
        throw SQLFeatureNotSupportedException()
    }

    override fun getInt(columnIndex: Int): Int {
        throw SQLFeatureNotSupportedException()
    }

    override fun getLong(columnIndex: Int): Long {
        throw SQLFeatureNotSupportedException()
    }

    override fun getFloat(columnIndex: Int): Float {
        throw SQLFeatureNotSupportedException()
    }

    override fun getDouble(columnIndex: Int): Double {
        throw SQLFeatureNotSupportedException()
    }

    @Deprecated("Deprecated in Java")
    override fun getBigDecimal(columnIndex: Int, scale: Int): BigDecimal? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getBytes(columnIndex: Int): ByteArray? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getDate(columnIndex: Int): Date? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getTime(columnIndex: Int): Time? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getTimestamp(columnIndex: Int): Timestamp? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getAsciiStream(columnIndex: Int): InputStream? {
        throw SQLFeatureNotSupportedException()
    }

    @Deprecated("Deprecated in Java")
    override fun getUnicodeStream(columnIndex: Int): InputStream? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getBinaryStream(columnIndex: Int): InputStream? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getString(columnLabel: String): String? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getBoolean(columnLabel: String): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun getByte(columnLabel: String): Byte {
        throw SQLFeatureNotSupportedException()
    }

    override fun getShort(columnLabel: String): Short {
        throw SQLFeatureNotSupportedException()
    }

    override fun getInt(columnLabel: String): Int {
        throw SQLFeatureNotSupportedException()
    }

    override fun getLong(columnLabel: String): Long {
        throw SQLFeatureNotSupportedException()
    }

    override fun getFloat(columnLabel: String): Float {
        throw SQLFeatureNotSupportedException()
    }

    override fun getDouble(columnLabel: String): Double {
        throw SQLFeatureNotSupportedException()
    }

    @Deprecated("Deprecated in Java")
    override fun getBigDecimal(columnLabel: String, scale: Int): BigDecimal? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getBytes(columnLabel: String): ByteArray? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getDate(columnLabel: String): Date? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getTime(columnLabel: String): Time? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getTimestamp(columnLabel: String): Timestamp? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getAsciiStream(columnLabel: String): InputStream? {
        throw SQLFeatureNotSupportedException()
    }

    @Deprecated("Deprecated in Java")
    override fun getUnicodeStream(columnLabel: String): InputStream? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getBinaryStream(columnLabel: String): InputStream? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getWarnings(): SQLWarning? {
        throw SQLFeatureNotSupportedException()
    }

    override fun clearWarnings() {
        throw SQLFeatureNotSupportedException()
    }

    override fun getCursorName(): String {
        throw SQLFeatureNotSupportedException()
    }

    override fun getMetaData(): ResultSetMetaData {
        throw SQLFeatureNotSupportedException()
    }

    override fun getObject(columnIndex: Int): Any {
        throw SQLFeatureNotSupportedException()
    }

    override fun getObject(columnLabel: String): Any {
        throw SQLFeatureNotSupportedException()
    }

    override fun findColumn(columnLabel: String): Int {
        throw SQLFeatureNotSupportedException()
    }

    override fun getCharacterStream(columnIndex: Int): Reader? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getCharacterStream(columnLabel: String): Reader? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getBigDecimal(columnIndex: Int): BigDecimal? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getBigDecimal(columnLabel: String): BigDecimal? {
        throw SQLFeatureNotSupportedException()
    }

    override fun isBeforeFirst(): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun isAfterLast(): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun isFirst(): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun isLast(): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun beforeFirst() {
        throw SQLFeatureNotSupportedException()
    }

    override fun afterLast() {
        throw SQLFeatureNotSupportedException()
    }

    override fun first(): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun last(): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun getRow(): Int {
        throw SQLFeatureNotSupportedException()
    }

    override fun absolute(row: Int): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun relative(rows: Int): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun previous(): Boolean {
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

    override fun getType(): Int {
        throw SQLFeatureNotSupportedException()
    }

    override fun getConcurrency(): Int {
        throw SQLFeatureNotSupportedException()
    }

    override fun rowUpdated(): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun rowInserted(): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun rowDeleted(): Boolean {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateNull(columnIndex: Int) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateBoolean(columnIndex: Int, x: Boolean) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateByte(columnIndex: Int, x: Byte) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateShort(columnIndex: Int, x: Short) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateInt(columnIndex: Int, x: Int) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateLong(columnIndex: Int, x: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateFloat(columnIndex: Int, x: Float) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateDouble(columnIndex: Int, x: Double) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateBigDecimal(columnIndex: Int, x: BigDecimal) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateString(columnIndex: Int, x: String) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateBytes(columnIndex: Int, x: ByteArray) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateDate(columnIndex: Int, x: Date) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateTime(columnIndex: Int, x: Time) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateTimestamp(columnIndex: Int, x: Timestamp) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateAsciiStream(columnIndex: Int, x: InputStream, length: Int) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateBinaryStream(columnIndex: Int, x: InputStream, length: Int) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateCharacterStream(columnIndex: Int, x: Reader, length: Int) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateObject(columnIndex: Int, x: Any, scaleOrLength: Int) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateObject(columnIndex: Int, x: Any) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateNull(columnLabel: String) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateBoolean(columnLabel: String, x: Boolean) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateByte(columnLabel: String, x: Byte) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateShort(columnLabel: String, x: Short) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateInt(columnLabel: String, x: Int) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateLong(columnLabel: String, x: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateFloat(columnLabel: String, x: Float) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateDouble(columnLabel: String, x: Double) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateBigDecimal(columnLabel: String, x: BigDecimal) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateString(columnLabel: String, x: String) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateBytes(columnLabel: String, x: ByteArray) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateDate(columnLabel: String, x: Date) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateTime(columnLabel: String, x: Time) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateTimestamp(columnLabel: String, x: Timestamp) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateAsciiStream(columnLabel: String, x: InputStream, length: Int) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateBinaryStream(columnLabel: String, x: InputStream, length: Int) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateCharacterStream(columnLabel: String, reader: Reader, length: Int) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateObject(columnLabel: String, x: Any, scaleOrLength: Int) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateObject(columnLabel: String, x: Any) {
        throw SQLFeatureNotSupportedException()
    }

    override fun insertRow() {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateRow() {
        throw SQLFeatureNotSupportedException()
    }

    override fun deleteRow() {
        throw SQLFeatureNotSupportedException()
    }

    override fun refreshRow() {
        throw SQLFeatureNotSupportedException()
    }

    override fun cancelRowUpdates() {
        throw SQLFeatureNotSupportedException()
    }

    override fun moveToInsertRow() {
        throw SQLFeatureNotSupportedException()
    }

    override fun moveToCurrentRow() {
        throw SQLFeatureNotSupportedException()
    }

    override fun getStatement(): Statement? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getObject(
        columnIndex: Int,
        map: Map<String, Class<*>>
    ): Any {
        throw SQLFeatureNotSupportedException()
    }

    override fun getRef(columnIndex: Int): Ref {
        throw SQLFeatureNotSupportedException()
    }

    override fun getBlob(columnIndex: Int): Blob {
        throw SQLFeatureNotSupportedException()
    }

    override fun getClob(columnIndex: Int): Clob {
        throw SQLFeatureNotSupportedException()
    }

    override fun getArray(columnIndex: Int): Array {
        throw SQLFeatureNotSupportedException()
    }

    override fun getObject(
        columnLabel: String,
        map: Map<String, Class<*>>
    ): Any {
        throw SQLFeatureNotSupportedException()
    }

    override fun getRef(columnLabel: String): Ref {
        throw SQLFeatureNotSupportedException()
    }

    override fun getBlob(columnLabel: String): Blob {
        throw SQLFeatureNotSupportedException()
    }

    override fun getClob(columnLabel: String): Clob {
        throw SQLFeatureNotSupportedException()
    }

    override fun getArray(columnLabel: String): Array {
        throw SQLFeatureNotSupportedException()
    }

    override fun getDate(columnIndex: Int, cal: Calendar): Date? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getDate(columnLabel: String, cal: Calendar): Date? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getTime(columnIndex: Int, cal: Calendar): Time? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getTime(columnLabel: String, cal: Calendar): Time? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getTimestamp(columnIndex: Int, cal: Calendar): Timestamp? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getTimestamp(columnLabel: String, cal: Calendar): Timestamp? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getURL(columnIndex: Int): URL? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getURL(columnLabel: String): URL? {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateRef(columnIndex: Int, x: Ref) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateRef(columnLabel: String, x: Ref) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateBlob(columnIndex: Int, x: Blob) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateBlob(columnLabel: String, x: Blob) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateClob(columnIndex: Int, x: Clob) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateClob(columnLabel: String, x: Clob) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateArray(columnIndex: Int, x: Array) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateArray(columnLabel: String, x: Array) {
        throw SQLFeatureNotSupportedException()
    }

    override fun getRowId(columnIndex: Int): RowId? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getRowId(columnLabel: String): RowId? {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateRowId(columnIndex: Int, x: RowId) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateRowId(columnLabel: String, x: RowId) {
        throw SQLFeatureNotSupportedException()
    }

    override fun getHoldability(): Int {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateNString(columnIndex: Int, nString: String) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateNString(columnLabel: String, nString: String) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateNClob(columnIndex: Int, nClob: NClob) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateNClob(columnLabel: String, nClob: NClob) {
        throw SQLFeatureNotSupportedException()
    }

    override fun getNClob(columnIndex: Int): NClob {
        throw SQLFeatureNotSupportedException()
    }

    override fun getNClob(columnLabel: String): NClob {
        throw SQLFeatureNotSupportedException()
    }

    override fun getSQLXML(columnIndex: Int): SQLXML {
        throw SQLFeatureNotSupportedException()
    }

    override fun getSQLXML(columnLabel: String): SQLXML {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateSQLXML(columnIndex: Int, xmlObject: SQLXML) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateSQLXML(columnLabel: String, xmlObject: SQLXML) {
        throw SQLFeatureNotSupportedException()
    }

    override fun getNString(columnIndex: Int): String? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getNString(columnLabel: String): String? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getNCharacterStream(columnIndex: Int): Reader? {
        throw SQLFeatureNotSupportedException()
    }

    override fun getNCharacterStream(columnLabel: String): Reader? {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateNCharacterStream(columnIndex: Int, x: Reader, length: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateNCharacterStream(columnLabel: String, reader: Reader, length: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateAsciiStream(columnIndex: Int, x: InputStream, length: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateBinaryStream(columnIndex: Int, x: InputStream, length: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateCharacterStream(columnIndex: Int, x: Reader, length: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateAsciiStream(columnLabel: String, x: InputStream, length: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateBinaryStream(columnLabel: String, x: InputStream, length: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateCharacterStream(columnLabel: String, reader: Reader, length: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateBlob(columnIndex: Int, inputStream: InputStream, length: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateBlob(columnLabel: String, inputStream: InputStream, length: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateClob(columnIndex: Int, reader: Reader, length: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateClob(columnLabel: String, reader: Reader, length: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateNClob(columnIndex: Int, reader: Reader, length: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateNClob(columnLabel: String, reader: Reader, length: Long) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateNCharacterStream(columnIndex: Int, x: Reader) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateNCharacterStream(columnLabel: String, reader: Reader) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateAsciiStream(columnIndex: Int, x: InputStream) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateBinaryStream(columnIndex: Int, x: InputStream) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateCharacterStream(columnIndex: Int, x: Reader) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateAsciiStream(columnLabel: String, x: InputStream) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateBinaryStream(columnLabel: String, x: InputStream) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateCharacterStream(columnLabel: String, reader: Reader) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateBlob(columnIndex: Int, inputStream: InputStream) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateBlob(columnLabel: String, inputStream: InputStream) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateClob(columnIndex: Int, reader: Reader) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateClob(columnLabel: String, reader: Reader) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateNClob(columnIndex: Int, reader: Reader) {
        throw SQLFeatureNotSupportedException()
    }

    override fun updateNClob(columnLabel: String, reader: Reader) {
        throw SQLFeatureNotSupportedException()
    }

    override fun <T : Any> getObject(columnIndex: Int, type: Class<T>): T {
        throw SQLFeatureNotSupportedException()
    }

    override fun <T : Any> getObject(columnLabel: String, type: Class<T>): T {
        throw SQLFeatureNotSupportedException()
    }
}
