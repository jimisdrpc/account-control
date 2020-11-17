package com.mybank.service

import com.mybank.dto.Transaction
import com.mybank.dto.Transactions
import com.mybank.endpoint.TransactionsRequest
import com.mybank.producer.DebitProducer
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
//class TransactionService(private val debitProducer: DebitProducer){
class TransactionService(){

    @Inject
    @Named("debitProducer")
    lateinit var debitProducer : DebitProducer

    fun postDebitTransaction(transaction: Transaction) : String{

        debitProducer.sendRequestMessage ( transaction)

        return "posted"
    }

    fun postDebitTransactions(transactions: Transactions) : String{

        debitProducer.sendRequestMessage ( transactions)

        return "posted"
    }



    fun postDebitTransaction(debit: String) : String{

        debitProducer.sendRequestMessage ("1", "First Message")

        return "posted"
    }
}