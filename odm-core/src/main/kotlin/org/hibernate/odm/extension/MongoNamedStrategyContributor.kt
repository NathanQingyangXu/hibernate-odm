package org.hibernate.odm.extension

import org.hibernate.boot.registry.selector.spi.NamedStrategyContributions
import org.hibernate.boot.registry.selector.spi.NamedStrategyContributor
import org.hibernate.dialect.Dialect
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider
import org.hibernate.odm.dialect.MongoDialect
import org.hibernate.odm.jdbc.MongoConnectionProvider
import org.hibernate.odm.util.MongoConstants.MONGO_CONNECTION_PROVIDER_SHORT_NAME
import org.hibernate.odm.util.MongoConstants.MONGO_DIALOG_SHORT_NAME

internal class MongoNamedStrategyContributor : NamedStrategyContributor {
  override fun contributeStrategyImplementations(contributions: NamedStrategyContributions) {
    contributions.contributeStrategyImplementor(
        Dialect::class.java, MongoDialect::class.java, MONGO_DIALOG_SHORT_NAME)
    contributions.contributeStrategyImplementor(
        ConnectionProvider::class.java,
        MongoConnectionProvider::class.java,
        MONGO_CONNECTION_PROVIDER_SHORT_NAME)
  }

  override fun clearStrategyImplementations(contributions: NamedStrategyContributions) {
    contributions.removeStrategyImplementor(Dialect::class.java, MongoDialect::class.java)
    contributions.removeStrategyImplementor(
        ConnectionProvider::class.java, MongoConnectionProvider::class.java)
  }
}
