package ru.otus.financial.exchange.prototype.adapter.config

object HttpTimerParam {
    private val httpPeriodRequest: Long by lazy {
        System.getenv("HTTP_PERIOD_REQUEST")?.toLong() ?: 300000L
    }

    val httpTimerEndpoint
        get() = "timer:http?period=${httpPeriodRequest}ms"
}