package com.mybank.producer


import com.mybank.dto.Transaction
import com.mybank.dto.Transactions
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaClient
public interface DebitProducer {
    @Topic("debit")
    fun sendRequestMessage(@KafkaKey key: String?, message: String?) {
    }

    @Topic("debit")
    fun sendRequestMessage( transaction: Transaction) {
    }

    @Topic("debit")
    fun sendRequestMessage( transactions: Transactions) {
    }

    fun sendRequestMessage(@Topic topic: String?, @KafkaKey day: String?, message: String?) {}
}