package com.sense.pass.dto

import java.math.BigDecimal
import java.time.LocalDateTime

// To give more information to the API user
// When Customer data is requested, Account data is reachable, vice versa
data class CustomerAccountDto(

        val id: String?,
        val balance: BigDecimal? = BigDecimal.ZERO,
        val creationDate: LocalDateTime?,
        val transactions:Set<TransactionDto>?,

        )
