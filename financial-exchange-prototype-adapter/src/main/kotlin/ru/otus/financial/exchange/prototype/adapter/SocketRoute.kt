package ru.otus.financial.exchange.prototype.adapter

import org.apache.camel.builder.RouteBuilder
import ru.otus.financial.exchange.prototype.adapter.config.CaseConfigs

class SocketRoute(
    val currencyCases: List<CaseConfigs> = listOf()
): RouteBuilder() {
    override fun configure() {

        onException(Throwable::class.java)
            .process {
                println("Error")
            }
            .handled(true)
        currencyCases.map {
            from(it.timerEndpoint)
                .to(it.httpEndpoint)
                .unmarshal()
                .json()
                .process {
                    println("response = ${it.message.body}")
                }
                .marshal()
                .json()
                .to(it.kafkaEndpoint)
        }
    }
}