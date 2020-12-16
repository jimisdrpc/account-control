package com.mybank.endpoint


import com.mybank.dto.Debiter
import com.mybank.service.TransactionService
import javax.inject.Singleton

@Singleton
@Suppress("unused")
class TransactionEndpoint(val transactionService: TransactionService) : AccountGrpcKt.AccountCoroutineImplBase(){

    override suspend fun sendDebit(request: DebitRequest): DebitReply {

        var postStatus: String = transactionService.postDebitTransaction(request)
        return DebitReply.newBuilder().setMessage(postStatus).build()
    }

//    override suspend fun sendDebit(request: DebitRequest): DebitReply {
//        var postStatus: String
//        var dtoDebiter: Debiter = Debiter()
//        dtoDebiter.id = request.id.toString()
//        dtoDebiter.name = request.name
//
//        postStatus = transactionService.postDebitTransaction(dtoDebiter)
//        return DebitReply.newBuilder().setMessage(postStatus).build()
//    }
}