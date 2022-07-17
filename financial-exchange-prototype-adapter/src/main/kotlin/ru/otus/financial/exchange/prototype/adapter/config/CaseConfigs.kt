package ru.otus.financial.exchange.prototype.adapter.config

import ru.otus.financial.exchange.prototype.adapter.common.getEnvLongOrDefault
import ru.otus.financial.exchange.prototype.adapter.common.getEnvStringOrDefault

sealed class CaseConfigs {
    abstract val case: CurrencyCases
    abstract val fromCurrency: Currencies
    abstract val toCurrency: Currencies

    protected abstract val topicName: String
    protected abstract val timerName: String
    protected abstract val timerPeriodRequest: Long
    protected abstract val timerDelayRequest: Long

    val timerEndpoint: String
        get() = "timer:${timerName}?period=${timerPeriodRequest}ms&delay=${timerDelayRequest}ms"
    val httpEndpoint: String
        get() = "https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=${fromCurrency.name}&to_currency=${toCurrency.name}&apikey=${httpApiKey}"
    val kafkaEndpoint: String
        get() = "kafka:${topicName}?brokers=${kafkaServers}&shutdownTimeout=1"

    private val kafkaServers: String
        get() = kafkaServersEnvVar.getEnvStringOrDefault("localhost:9092")
    private val httpApiKey: String
        get() = httpApiKeyEnvVar.getEnvStringOrDefault("")


    companion object {
        const val kafkaServersEnvVar = "KAFKA_BOOTSTRAP_SERVERS"
        const val httpApiKeyEnvVar = "HTTP_API_KEY"

    }
}

class UsdRubCaseConfigs : CaseConfigs() {
    override val case: CurrencyCases
        get() = CurrencyCases.USD_RUB
    override val fromCurrency: Currencies
        get() = Currencies.USD
    override val toCurrency: Currencies
        get() = Currencies.RUB
    override val topicName: String
        get() = topicNameEnvVar.getEnvStringOrDefault("topic_${case.name.lowercase()}")
    override val timerName: String
        get() = timerNameEnvVar.getEnvStringOrDefault("timer_${case.name.lowercase()}")
    override val timerPeriodRequest: Long
        get() = httpPeriodRequestEnvVar.getEnvLongOrDefault(900000L)
    override val timerDelayRequest: Long
        get() = httpDelayRequestEnvVar.getEnvLongOrDefault(0L)

    companion object {
        val topicNameEnvVar = "KAFKA_TOPIC_${CurrencyCases.USD_RUB}"
        val timerNameEnvVar = "KAFKA_TIMER_${CurrencyCases.USD_RUB}"
        val httpPeriodRequestEnvVar = "HTTP_PERIOD_REQUEST_${CurrencyCases.USD_RUB}"
        val httpDelayRequestEnvVar = "HTTP_DELAY_REQUEST_${CurrencyCases.USD_RUB}"
    }
}

class EurRubCaseConfigs: CaseConfigs() {
    override val case: CurrencyCases
        get() = CurrencyCases.EUR_RUB
    override val fromCurrency: Currencies
        get() = Currencies.EUR
    override val toCurrency: Currencies
        get() = Currencies.RUB
    override val topicName: String
        get() = topicNameEnvVar.getEnvStringOrDefault("topic_${case.name.lowercase()}")
    override val timerName: String
        get() = timerNameEnvVar.getEnvStringOrDefault("timer_${case.name.lowercase()}")
    override val timerPeriodRequest: Long
        get() = httpPeriodRequestEnvVar.getEnvLongOrDefault(900000L)
    override val timerDelayRequest: Long
        get() = httpDelayRequestEnvVar.getEnvLongOrDefault(0L)

    companion object {
        val topicNameEnvVar = "KAFKA_TOPIC_${CurrencyCases.EUR_RUB}"
        val timerNameEnvVar = "KAFKA_TIMER_${CurrencyCases.EUR_RUB}"
        val httpPeriodRequestEnvVar = "HTTP_PERIOD_REQUEST_${CurrencyCases.EUR_RUB}"
        val httpDelayRequestEnvVar = "HTTP_DELAY_REQUEST_${CurrencyCases.EUR_RUB}"
    }
}

class GbpRubCaseConfigs: CaseConfigs() {
    override val case: CurrencyCases
        get() = CurrencyCases.GBP_RUB
    override val fromCurrency: Currencies
        get() = Currencies.GBP
    override val toCurrency: Currencies
        get() = Currencies.RUB
    override val topicName: String
        get() = topicNameEnvVar.getEnvStringOrDefault("topic_${case.name.lowercase()}")
    override val timerName: String
        get() = timerNameEnvVar.getEnvStringOrDefault("timer_${case.name.lowercase()}")
    override val timerPeriodRequest: Long
        get() = httpPeriodRequestEnvVar.getEnvLongOrDefault(900000L)
    override val timerDelayRequest: Long
        get() = httpDelayRequestEnvVar.getEnvLongOrDefault(0L)

    companion object {
        val topicNameEnvVar = "KAFKA_TOPIC_${CurrencyCases.GBP_RUB}"
        val timerNameEnvVar = "KAFKA_TIMER_${CurrencyCases.GBP_RUB}"
        val httpPeriodRequestEnvVar = "HTTP_PERIOD_REQUEST_${CurrencyCases.GBP_RUB}"
        val httpDelayRequestEnvVar = "HTTP_DELAY_REQUEST_${CurrencyCases.GBP_RUB}"
    }
}

class ChfRubCaseConfigs: CaseConfigs() {
    override val case: CurrencyCases
        get() = CurrencyCases.CHF_RUB
    override val fromCurrency: Currencies
        get() = Currencies.CHF
    override val toCurrency: Currencies
        get() = Currencies.RUB
    override val topicName: String
        get() = topicNameEnvVar.getEnvStringOrDefault("topic_${case.name.lowercase()}")
    override val timerName: String
        get() = timerNameEnvVar.getEnvStringOrDefault("timer_${case.name.lowercase()}")
    override val timerPeriodRequest: Long
        get() = httpPeriodRequestEnvVar.getEnvLongOrDefault(900000L)
    override val timerDelayRequest: Long
        get() = httpDelayRequestEnvVar.getEnvLongOrDefault(0L)

    companion object {
        val topicNameEnvVar = "KAFKA_TOPIC_${CurrencyCases.CHF_RUB}"
        val timerNameEnvVar = "KAFKA_TIMER_${CurrencyCases.CHF_RUB}"
        val httpPeriodRequestEnvVar = "HTTP_PERIOD_REQUEST_${CurrencyCases.CHF_RUB}"
        val httpDelayRequestEnvVar = "HTTP_DELAY_REQUEST_${CurrencyCases.CHF_RUB}"
    }
}

class CadRubCaseConfigs: CaseConfigs() {
    override val case: CurrencyCases
        get() = CurrencyCases.CAD_RUB
    override val fromCurrency: Currencies
        get() = Currencies.CAD
    override val toCurrency: Currencies
        get() = Currencies.RUB
    override val topicName: String
        get() = topicNameEnvVar.getEnvStringOrDefault("topic_${case.name.lowercase()}")
    override val timerName: String
        get() = timerNameEnvVar.getEnvStringOrDefault("timer_${case.name.lowercase()}")
    override val timerPeriodRequest: Long
        get() = httpPeriodRequestEnvVar.getEnvLongOrDefault(900000L)
    override val timerDelayRequest: Long
        get() = httpDelayRequestEnvVar.getEnvLongOrDefault(0L)

    companion object {
        val topicNameEnvVar = "KAFKA_TOPIC_${CurrencyCases.CAD_RUB}"
        val timerNameEnvVar = "KAFKA_TIMER_${CurrencyCases.CAD_RUB}"
        val httpPeriodRequestEnvVar = "HTTP_PERIOD_REQUEST_${CurrencyCases.CAD_RUB}"
        val httpDelayRequestEnvVar = "HTTP_DELAY_REQUEST_${CurrencyCases.CAD_RUB}"
    }
}

class PlnRubCaseConfigs: CaseConfigs() {
    override val case: CurrencyCases
        get() = CurrencyCases.PLN_RUB
    override val fromCurrency: Currencies
        get() = Currencies.PLN
    override val toCurrency: Currencies
        get() = Currencies.RUB
    override val topicName: String
        get() = topicNameEnvVar.getEnvStringOrDefault("topic_${case.name.lowercase()}")
    override val timerName: String
        get() = timerNameEnvVar.getEnvStringOrDefault("timer_${case.name.lowercase()}")
    override val timerPeriodRequest: Long
        get() = httpPeriodRequestEnvVar.getEnvLongOrDefault(900000L)
    override val timerDelayRequest: Long
        get() = httpDelayRequestEnvVar.getEnvLongOrDefault(60000L)

    companion object {
        val topicNameEnvVar = "KAFKA_TOPIC_${CurrencyCases.PLN_RUB}"
        val timerNameEnvVar = "KAFKA_TIMER_${CurrencyCases.PLN_RUB}"
        val httpPeriodRequestEnvVar = "HTTP_PERIOD_REQUEST_${CurrencyCases.PLN_RUB}"
        val httpDelayRequestEnvVar = "HTTP_DELAY_REQUEST_${CurrencyCases.PLN_RUB}"
    }
}

class CzkRubCaseConfigs: CaseConfigs() {
    override val case: CurrencyCases
        get() = CurrencyCases.CZK_RUB
    override val fromCurrency: Currencies
        get() = Currencies.CZK
    override val toCurrency: Currencies
        get() = Currencies.RUB
    override val topicName: String
        get() = topicNameEnvVar.getEnvStringOrDefault("topic_${case.name.lowercase()}")
    override val timerName: String
        get() = timerNameEnvVar.getEnvStringOrDefault("timer_${case.name.lowercase()}")
    override val timerPeriodRequest: Long
        get() = httpPeriodRequestEnvVar.getEnvLongOrDefault(900000L)
    override val timerDelayRequest: Long
        get() = httpDelayRequestEnvVar.getEnvLongOrDefault(60000L)

    companion object {
        val topicNameEnvVar = "KAFKA_TOPIC_${CurrencyCases.CZK_RUB}"
        val timerNameEnvVar = "KAFKA_TIMER_${CurrencyCases.CZK_RUB}"
        val httpPeriodRequestEnvVar = "HTTP_PERIOD_REQUEST_${CurrencyCases.CZK_RUB}"
        val httpDelayRequestEnvVar = "HTTP_DELAY_REQUEST_${CurrencyCases.CZK_RUB}"
    }
}

class TryRubCaseConfigs: CaseConfigs() {
    override val case: CurrencyCases
        get() = CurrencyCases.TRY_RUB
    override val fromCurrency: Currencies
        get() = Currencies.TRY
    override val toCurrency: Currencies
        get() = Currencies.RUB
    override val topicName: String
        get() = topicNameEnvVar.getEnvStringOrDefault("topic_${case.name.lowercase()}")
    override val timerName: String
        get() = timerNameEnvVar.getEnvStringOrDefault("timer_${case.name.lowercase()}")
    override val timerPeriodRequest: Long
        get() = httpPeriodRequestEnvVar.getEnvLongOrDefault(900000L)
    override val timerDelayRequest: Long
        get() = httpDelayRequestEnvVar.getEnvLongOrDefault(60000L)

    companion object {
        val topicNameEnvVar = "KAFKA_TOPIC_${CurrencyCases.TRY_RUB}"
        val timerNameEnvVar = "KAFKA_TIMER_${CurrencyCases.TRY_RUB}"
        val httpPeriodRequestEnvVar = "HTTP_PERIOD_REQUEST_${CurrencyCases.TRY_RUB}"
        val httpDelayRequestEnvVar = "HTTP_DELAY_REQUEST_${CurrencyCases.TRY_RUB}"
    }
}

class CnyRubCaseConfigs: CaseConfigs() {
    override val case: CurrencyCases
        get() = CurrencyCases.CNY_RUB
    override val fromCurrency: Currencies
        get() = Currencies.CNY
    override val toCurrency: Currencies
        get() = Currencies.RUB
    override val topicName: String
        get() = topicNameEnvVar.getEnvStringOrDefault("topic_${case.name.lowercase()}")
    override val timerName: String
        get() = timerNameEnvVar.getEnvStringOrDefault("timer_${case.name.lowercase()}")
    override val timerPeriodRequest: Long
        get() = httpPeriodRequestEnvVar.getEnvLongOrDefault(900000L)
    override val timerDelayRequest: Long
        get() = httpDelayRequestEnvVar.getEnvLongOrDefault(60000L)

    companion object {
        val topicNameEnvVar = "KAFKA_TOPIC_${CurrencyCases.CNY_RUB}"
        val timerNameEnvVar = "KAFKA_TIMER_${CurrencyCases.CNY_RUB}"
        val httpPeriodRequestEnvVar = "HTTP_PERIOD_REQUEST_${CurrencyCases.CNY_RUB}"
        val httpDelayRequestEnvVar = "HTTP_DELAY_REQUEST_${CurrencyCases.CNY_RUB}"
    }
}

class ThbRubCaseConfigs: CaseConfigs() {
    override val case: CurrencyCases
        get() = CurrencyCases.THB_RUB
    override val fromCurrency: Currencies
        get() = Currencies.THB
    override val toCurrency: Currencies
        get() = Currencies.RUB
    override val topicName: String
        get() = topicNameEnvVar.getEnvStringOrDefault("topic_${case.name.lowercase()}")
    override val timerName: String
        get() = timerNameEnvVar.getEnvStringOrDefault("timer_${case.name.lowercase()}")
    override val timerPeriodRequest: Long
        get() = httpPeriodRequestEnvVar.getEnvLongOrDefault(900000L)
    override val timerDelayRequest: Long
        get() = httpDelayRequestEnvVar.getEnvLongOrDefault(60000L)

    companion object {
        val topicNameEnvVar = "KAFKA_TOPIC_${CurrencyCases.THB_RUB}"
        val timerNameEnvVar = "KAFKA_TIMER_${CurrencyCases.THB_RUB}"
        val httpPeriodRequestEnvVar = "HTTP_PERIOD_REQUEST_${CurrencyCases.THB_RUB}"
        val httpDelayRequestEnvVar = "HTTP_DELAY_REQUEST_${CurrencyCases.THB_RUB}"
    }
}
