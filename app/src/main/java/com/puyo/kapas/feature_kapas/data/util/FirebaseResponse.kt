package com.puyo.kapas.feature_kapas.data.util

sealed class FirebaseResponse <out R> {
    data class Success<out T>(val data: T): FirebaseResponse<T>()
    data class Error(val errorMessage: String): FirebaseResponse<Nothing>()
    object Empty: FirebaseResponse<Nothing>()
}