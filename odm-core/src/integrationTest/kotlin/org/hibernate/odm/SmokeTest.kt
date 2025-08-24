package org.hibernate.odm

import org.hibernate.testing.orm.domain.helpdesk.Ticket
import org.hibernate.testing.orm.junit.DomainModel
import org.hibernate.testing.orm.junit.SessionFactory
import kotlin.test.Test

@DomainModel(annotatedClasses = [Ticket::class])
@SessionFactory
class SmokeTest {

    @Test
    fun `test Hibernate odm could be launched successfully`() {}
}
