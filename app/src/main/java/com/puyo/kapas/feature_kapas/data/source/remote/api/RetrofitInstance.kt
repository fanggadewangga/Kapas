package com.puyo.kapas.feature_kapas.data.source.remote.api

import com.puyo.kapas.feature_kapas.data.source.remote.api.service.KapasApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    fun create(): KapasApi =
        Retrofit.Builder()
            .baseUrl("https://kapas-api.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KapasApi::class.java)
}