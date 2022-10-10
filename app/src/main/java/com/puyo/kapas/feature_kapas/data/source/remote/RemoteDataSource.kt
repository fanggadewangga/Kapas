package com.puyo.kapas.feature_kapas.data.source.remote

import com.puyo.kapas.feature_kapas.data.source.remote.api.service.ApiService
import com.puyo.kapas.feature_kapas.data.source.remote.firebase.FirebaseService

class RemoteDataSource(
    private val apiService: ApiService,
    private val firebaseService: FirebaseService
) {
}