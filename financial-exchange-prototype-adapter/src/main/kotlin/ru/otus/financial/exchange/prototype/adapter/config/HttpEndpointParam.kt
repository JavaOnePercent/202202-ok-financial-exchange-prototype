package ru.otus.financial.exchange.prototype.adapter.config

object HttpEndpointParam {
    private val usdCurrency: String by lazy {
        System.getenv("USD_CURRENCY") ?: "USD"
    }

    private val rubCurrency: String by lazy {
        System.getenv("RUB_CURRENCY") ?: "RUB"
    }

    private val apiKey: String by lazy {
        System.getenv("HTTP_API_KEY") ?: "UU55DD48O45RSE1S"
    }

    val usdRubEndpoint
        get() = "https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=$usdCurrency&to_currency=$rubCurrency&apikey=$apiKey"
}
