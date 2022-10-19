package com.puyo.kapas.feature_kapas.data.source.local

sealed class LocalAnswer<out T> {
    data class Success<out T> (val data: T): LocalAnswer<T>()
    data class Error(val errorMessage: String): LocalAnswer<Nothing>()
    data class Empty(val message: String = ""): LocalAnswer<Nothing>()
}