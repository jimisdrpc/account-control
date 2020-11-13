package com.mybank.producer

import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaClient
public interface DebitProducer {
    @Topic("debit")
    fun sendGreetMessage(@KafkaKey day: String?, message: String?) {
    }

    @Topic("debit")
    fun sendGreetMessage( message: String?) {
    }

    fun sendGreetMessage(@Topic topic: String?, @KafkaKey day: String?, message: String?) {}
}