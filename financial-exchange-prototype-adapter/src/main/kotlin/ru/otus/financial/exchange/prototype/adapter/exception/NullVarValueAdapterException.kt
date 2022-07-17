package ru.otus.financial.exchange.prototype.adapter.exception

class NullVarValueAdapterException(nameVar: String) : RuntimeException("Variable '${nameVar}' is null")

