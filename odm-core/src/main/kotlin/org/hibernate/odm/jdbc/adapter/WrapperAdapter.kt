package org.hibernate.odm.jdbc.adapter

import java.sql.SQLFeatureNotSupportedException
import java.sql.Wrapper

interface WrapperAdapter : Wrapper {
    override fun <T : Any> unwrap(iface: Class<T>): T {
        throw SQLFeatureNotSupportedException()
    }

    override fun isWrapperFor(iface: Class<*>): Boolean {
        throw SQLFeatureNotSupportedException()
    }
}