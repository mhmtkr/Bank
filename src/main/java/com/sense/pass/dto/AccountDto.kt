package com.sense.pass.dto

import java.math.BigDecimal
import java.time.LocalDateTime

// Dto's provide more control that enables to be more elastic with the API responses
data class AccountDto(

        val id: String?,
        val balance: BigDecimal?,
        val creationDate: LocalDateTime?,
        val customer:AccountCustomerDto?,
        val transactions:Set<TransactionDto>?,
)
