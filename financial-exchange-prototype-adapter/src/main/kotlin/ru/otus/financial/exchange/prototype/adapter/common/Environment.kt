package ru.otus.financial.exchange.prototype.adapter.common

import ru.otus.financial.exchange.prototype.adapter.exception.InvalidVarFormatAdapterException
import ru.otus.financial.exchange.prototype.adapter.exception.NullVarValueAdapterException

fun String.getEnvString() = this.getEnvOrThrowException()
fun String.getEnvLong() = this.getEnvOrThrowException().toLongOrThrowException()

fun String.getEnvStringOrDefault(default: String) = this.getEnv() ?: default
fun String.getEnvLongOrDefault(default: Long) = this.getEnv()?.toLongOrNull() ?: default

private fun String.getEnv() = System.getenv(this)
private fun String.getEnvOrThrowException() = this.getEnv() ?: throw NullVarValueAdapterException(this)
private fun String.toLongOrThrowException() = this.toLongOrNull() ?: throw InvalidVarFormatAdapterException(this)
