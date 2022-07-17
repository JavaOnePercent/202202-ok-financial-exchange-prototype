package ru.otus.financial.exchange.prototype.adapter

import org.apache.camel.main.Main
import ru.otus.financial.exchange.prototype.adapter.config.*

fun main(args: Array<String>) {
    val currencyCases: List<CaseConfigs> = listOf(
        UsdRubCaseConfigs(),
        EurRubCaseConfigs(),
        GbpRubCaseConfigs(),
        ChfRubCaseConfigs(),
        CadRubCaseConfigs(),
        PlnRubCaseConfigs(),
        CzkRubCaseConfigs(),
        TryRubCaseConfigs(),
        CnyRubCaseConfigs(),
        ThbRubCaseConfigs()
    )

    Main().apply {
        configure().addRoutesBuilder(
            SocketRoute(currencyCases = currencyCases)
        )
        run(args)
    }
}