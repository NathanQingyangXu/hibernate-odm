package org.hibernate.odm

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.testing.orm.junit.DomainModel
import org.hibernate.testing.orm.junit.SessionFactory
import kotlin.test.Test

@DomainModel(annotatedClasses = [Book::class])
@SessionFactory
class SmokeTest {

    @Test
    fun `test Hibernate odm could be launched successfully`() {}
}

@Entity
@Table(name = "books")
class Book {
    @Id
    var id: Int? = null
    var title: String? = null

    constructor() {}
    constructor(id: Int, title: String) {
        this.id = id
        this.title = title
    }
}