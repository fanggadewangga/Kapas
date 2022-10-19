package com.puyo.kapas.feature_kapas.data.source.remote

import com.puyo.kapas.feature_kapas.data.source.remote.api.service.KapasApi
import com.puyo.kapas.feature_kapas.data.source.remote.firebase.FirebaseService

class RemoteDataSource(
    private val kapasApi: KapasApi,
    private val firebaseService: FirebaseService
) {
}