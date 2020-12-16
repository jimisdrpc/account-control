package com.mybank.producer


import com.mybank.dto.Debiter
import com.mybank.dto.Transaction
import com.mybank.dto.Transactions
import com.mybank.endpoint.DebitRequest
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.context.annotation.Property
import org.apache.kafka.clients.producer.ProducerConfig

@KafkaClient(
        id="debit-client",
        acks = KafkaClient.Acknowledge.ALL,
        properties = [Property(name = ProducerConfig.RETRIES_CONFIG, value = "5")]
        //How add these two properties in order to use Protobuf Serializer
        //kafka.producers.*.key-serializer
        //kafka.producers.*.value-serializer
)
public interface DebitProducer {

    @Topic("debit")
    fun sendRequestMessage(@KafkaKey key: String?, message: DebitRequest?) {
    }

    @Topic("debit")
    fun sendRequestMessage(@KafkaKey key: String?, message: Debiter?) {
    }

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