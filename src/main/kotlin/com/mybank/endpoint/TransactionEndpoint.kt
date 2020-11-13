package com.mybank.endpoint


import com.mybank.service.TransactionService
import javax.inject.Singleton

@Singleton
@Suppress("unused")
class TransactionEndpoint(val transactionService: TransactionService) : AccountGrpcKt.AccountCoroutineImplBase(){


    override suspend fun sendDebit(request: DebitRequest): DebitReply {
        transactionService.postDebitTransaction("teste")
        return DebitReply.newBuilder().setMessage("teste").build()
    }
}