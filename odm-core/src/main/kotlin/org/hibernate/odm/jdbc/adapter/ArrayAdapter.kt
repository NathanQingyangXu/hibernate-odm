package org.hibernate.odm.jdbc

import java.sql.Array
import java.sql.ResultSet
import java.sql.SQLFeatureNotSupportedException

internal sealed interface ArrayAdapter : Array {
    override fun getBaseTypeName(): String {
        throw SQLFeatureNotSupportedException()
    }

    override fun getBaseType(): Int {
        throw SQLFeatureNotSupportedException()
    }

    override fun getArray(): Any {
        throw SQLFeatureNotSupportedException()
    }

    override fun getArray(map: Map<String, Class<*>>): Any {
        throw SQLFeatureNotSupportedException()
    }

    override fun getArray(index: Long, count: Int): Any {
        throw SQLFeatureNotSupportedException()
    }

    override fun getArray(
        index: Long,
        count: Int,
        map: Map<String, Class<*>>
    ): Any {
        throw SQLFeatureNotSupportedException()
    }

    override fun getResultSet(): ResultSet {
        throw SQLFeatureNotSupportedException()
    }

    override fun getResultSet(map: Map<String, Class<*>>): ResultSet {
        throw SQLFeatureNotSupportedException()
    }

    override fun getResultSet(index: Long, count: Int): ResultSet {
        throw SQLFeatureNotSupportedException()
    }

    override fun getResultSet(
        index: Long,
        count: Int,
        map: Map<String, Class<*>>
    ): ResultSet {
        throw SQLFeatureNotSupportedException()
    }

    override fun free() {
        throw SQLFeatureNotSupportedException()
    }
}
