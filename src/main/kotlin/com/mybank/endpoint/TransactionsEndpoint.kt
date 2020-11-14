package com.mybank.endpoint

import io.grpc.stub.StreamObserver
import javax.inject.Singleton

@Singleton
class TransactionsEndpoint : TransactionsServiceGrpc.TransactionsServiceImplBase(){

    //First tentative
    //This complains "'postTransactions' overrides nothing" and IntelliJ suggest second next approach
    //override fun postTransactions(request: TransactionsRequest?) : TransactionsReply {

    //Second Tentative
//    override fun postTransactions(request: TransactionsRequest?, responseObserver: StreamObserver<TransactionsReply>?) {
//        //it complains Type mismatch... Found: TransactionsReply
//        return TransactionsReply.newBuilder().setMessage("teste").build()
//    }

    //Third Tentative
    //This causes:
    //Return type is 'TransactionsReply', which is not a subtype of overridden public open
    // fun postTransactions(request: TransactionsRequest!, responseObserver: StreamObserver<TransactionsReply!>!):
    // Unit defined in com.mybank.endpoint.TransactionsServiceGrpc.TransactionsServiceImplBase
    //override fun postTransactions(request: TransactionsRequest?, responseObserver: StreamObserver<TransactionsReply>?) : TransactionsReply {
//        return TransactionsReply.newBuilder().setMessage("teste").build()
//    }
}