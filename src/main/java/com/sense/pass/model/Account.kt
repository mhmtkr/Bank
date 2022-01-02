package com.sense.pass.model

import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity // Defines that a class can be mapped to a table
data class Account(

        // Customer:1 ---> n:Account:1 ---> n:Transaction

        @Id // Specifies the primary key of the entity
        @GeneratedValue(generator = "UUID") //Specifies the primary key generation strategy, which is "UUID" here
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id: String?, // "val" is immutable
        val balance: BigDecimal? = BigDecimal.ZERO,
        val creationDate: LocalDateTime,

        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name = "customer_id", nullable = false)
        val customer: Customer?,

        @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
        val transaction: Set<Transection>?



)
