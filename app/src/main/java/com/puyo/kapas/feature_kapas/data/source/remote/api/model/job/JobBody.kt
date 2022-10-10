package com.puyo.kapas.feature_kapas.data.source.remote.api.model.job

import com.google.gson.annotations.SerializedName

data class JobBody(
    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("poster_id")
    val posterId: String,

    @field:SerializedName("location")
    val location: String,

    @field:SerializedName("wage")
    val wage: Double,

    @field:SerializedName("address")
    val address: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("image_url")
    val imageUrl: String,

    @field:SerializedName("latitude")
    val latitude: Double,

    @field:SerializedName("longitude")
    val longitude: Double
)
