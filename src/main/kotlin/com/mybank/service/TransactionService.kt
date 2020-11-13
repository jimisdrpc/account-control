package com.mybank.service

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


    fun postDebitTransaction(debit: String) : String{

        debitProducer.sendGreetMessage ("1", "First Message")

        return "posted"
    }
}