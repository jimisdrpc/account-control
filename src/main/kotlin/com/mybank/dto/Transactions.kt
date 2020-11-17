package com.mybank.dto

import java.time.LocalDate

class Transactions {
    lateinit var transactionDesc: String
    var transactions: List<Transaction>? = null
}
