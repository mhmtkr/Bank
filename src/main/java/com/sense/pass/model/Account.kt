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
        val id: String?, // "val" is immutable, "?": Means can be empty
        val balance: BigDecimal? = BigDecimal.ZERO,
        val creationDate: LocalDateTime,

        // FetchType.LAZY: Doesn't pull "Customer" when pulling "Account"
        // CascadeType.ALL: If "Customer" entity at "Account" is updated, update the data at "Customer Table" as well
        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name = "customer_id", nullable = false)
        val customer: Customer?,

        // mappedBy = "account": the map to the entity at "Transaction"
        @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
        val transaction: Set<Transaction>?

) {
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Account

                if (id != other.id) return false
                if (balance != other.balance) return false
                if (creationDate != other.creationDate) return false
                if (customer != other.customer) return false
                if (transaction != other.transaction) return false

                return true
        }

        override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + (balance?.hashCode() ?: 0)
                result = 31 * result + creationDate.hashCode()
                result = 31 * result + (customer?.hashCode() ?: 0)
                result = 31 * result + (transaction?.hashCode() ?: 0)
                return result
        }
}

// Equals
// if (a == b) ----> "False" because this checks memory address
// if a.equals(b) ----> "True"

// Hashcode
// Faster Data Operations