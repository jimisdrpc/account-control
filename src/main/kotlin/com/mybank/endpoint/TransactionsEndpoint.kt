package com.mybank.endpoint

import io.grpc.stub.StreamObserver
import javax.inject.Singleton

@Singleton
class TransactionsEndpoint : TransactionsServiceGrpcKt.TransactionsServiceCoroutineImplBase(){

    override suspend fun postTransactions(request: TransactionsRequest): TransactionsReply {
        return TransactionsReply.newBuilder().setMessage("testReply").build()
    }

}

