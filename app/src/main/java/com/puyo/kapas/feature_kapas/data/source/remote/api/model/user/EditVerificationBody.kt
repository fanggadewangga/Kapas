package com.puyo.kapas.feature_kapas.data.source.remote.api.model.user

import com.google.gson.annotations.SerializedName

data class EditVerificationBody(
    @field:SerializedName("card_number")
    val cardNumber: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("birth_place")
    val birthPlace: String,

    @field:SerializedName("birth_date")
    val birthDate: String,

    @field:SerializedName("gender")
    val gender: String
)
