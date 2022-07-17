package ru.otus.financial.exchange.prototype.adapter.exception

class InvalidVarFormatAdapterException(nameVar: String) : RuntimeException("Variable '${nameVar}' is invalid")
