package endpoint

import javax.inject.Singleton

@Singleton
@Suppress("unused")
class TransactionEndpoint : AccountGrpcKt.AccountCoroutineImplBase(){
    override suspend fun sendDebit(request: DebitRequest): DebitReply {
        return DebitReply.newBuilder().setMessage("teste").build()
    }
}