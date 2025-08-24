package org.hibernate.odm.jdbc

import java.sql.SQLFeatureNotSupportedException
import java.sql.Wrapper

internal sealed interface WrapperAdapter : Wrapper {
    override fun <T : Any> unwrap(iface: Class<T>): T {
        throw SQLFeatureNotSupportedException()
    }

    override fun isWrapperFor(iface: Class<*>): Boolean {
        throw SQLFeatureNotSupportedException()
    }
}
