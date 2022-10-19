package com.puyo.kapas.feature_kapas.data.source.remote.firebase

sealed class FirebaseResponse <out R> {
    data class Success<out T>(val data: T): FirebaseResponse<T>()
    data class Error(val errorMessage: String): FirebaseResponse<Nothing>()
    class Loading<out R>(val data: R? = null) : FirebaseResponse<R>()
    object Empty: FirebaseResponse<Nothing>()
}