package com.sense.pass.model

import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Transaction(

        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id: String?,
        val transactionType: TransactionType? = TransactionType.INITIAL // Define an initial "Transaction" type
        val amount: BigDecimal?, // "Double" is not enough for Transactions
        val transactionDate: LocalDateTime?,

        // To reach "Account" information from "Transaction"
        @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
        @JoinColumn(name = "account_id", nullable = false) // Create a column with the name "account_id" at the Transaction Table
        val account: Account


) {
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Transaction

                if (id != other.id) return false
                if (transactionType != other.transactionType) return false
                if (amount != other.amount) return false
                if (transactionDate != other.transactionDate) return false
                if (account != other.account) return false

                return true
        }

        override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + (transactionType?.hashCode() ?: 0)
                result = 31 * result + (amount?.hashCode() ?: 0)
                result = 31 * result + (transactionDate?.hashCode() ?: 0)
                result = 31 * result + account.hashCode()
                return result
        }
}

enum class TransactionType {
        INITIAL, TRANSFER
}