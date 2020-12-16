package com.mybank.endpoint

import com.mybank.endpoint.TransactionsProto
import com.mybank.dto.Transaction
import com.mybank.dto.Transactions


import com.mybank.service.TransactionService
import javax.inject.Singleton

@Singleton
class TransactionsEndpoint(val transactionService: TransactionService) : TransactionsServiceGrpcKt.TransactionsServiceCoroutineImplBase(){

    override suspend fun postTransactions(request: TransactionsRequest): TransactionsReply {

        var dtoTransactions : Transactions = Transactions()
        var dtoTransaction : Transaction = Transaction()

        print(request.getTransactionDesc())
        print(request.getTransactionsList())
        print(request.getTransactions(0))


        dtoTransaction.id = request.getTransactions(0).id
        dtoTransaction.name = request.getTransactions(0).name
        dtoTransaction.description = request.getTransactions(0).description
        dtoTransactions.transactions  = listOf(dtoTransaction, dtoTransaction)
        dtoTransactions.transactionDesc = request.getTransactionDesc()

        transactionService.postDebitTransaction(dtoTransaction)

        transactionService.postDebitTransactions(dtoTransactions)
        return TransactionsReply.newBuilder().setMessage("testReply").build()
    }

}

