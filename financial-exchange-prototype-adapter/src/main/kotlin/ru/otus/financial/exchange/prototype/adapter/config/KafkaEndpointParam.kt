package ru.otus.financial.exchange.prototype.adapter.config

object KafkaEndpointParam {
    private val quoteTopic: String by lazy {
        System.getenv("KAFKA_TOPIC_QUOTE") ?: "otus-topic-quote"
    }

    private val kafkaServers: String by lazy {
        System.getenv("KAFKA_BOOTSTRAP_SERVERS") ?: "localhost:9092"
    }

    private val options by lazy { "brokers=$kafkaServers&shutdownTimeout=1" }

    val quoteEndpointTopic
        get() = "kafka:$quoteTopic?$options"
}