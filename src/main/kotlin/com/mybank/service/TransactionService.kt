package com.mybank.service

import com.mybank.dto.Debiter
import com.mybank.dto.Transaction
import com.mybank.dto.Transactions
import com.mybank.endpoint.DebitRequest
import com.mybank.producer.DebitProducer
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class TransactionService(){

    @Inject
    @Named("debitProducer")
    lateinit var debitProducer : DebitProducer

//    @Inject
//    lateinit var test: test

    fun postDebitTransaction(transaction: Transaction) : String{

        //test.publisher(transaction)

        debitProducer.sendRequestMessage ( transaction)

        return "posted"
    }

    fun postDebitTransactions(transactions: Transactions) : String{

        debitProducer.sendRequestMessage ( transactions)

        return "posted"
    }

    fun postDebitTransaction(debit: Debiter) : String{

        debitProducer.sendRequestMessage ("9", debit)

        return "posted"
    }

    fun postDebitTransaction(debit: DebitRequest) : String{

        debitProducer.sendRequestMessage ("9", debit)

        return "posted"
    }
}