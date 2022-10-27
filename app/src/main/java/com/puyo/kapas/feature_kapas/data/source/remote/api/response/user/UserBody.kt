package com.puyo.kapas.feature_kapas.data.source.remote.api.response.user

import com.google.gson.annotations.SerializedName

data class UserBody(
    @field:SerializedName("uid")
    var uid: String,

    @field:SerializedName("card_number")
    val cardNumber: String? = "",

    @field:SerializedName("name")
    val name: String? = "",

    @field:SerializedName("address")
    val address: String? = "",

    @field:SerializedName("birth_place")
    val birthPlace: String? = "",

    @field:SerializedName("birth_date")
    val birthDate: String? = "",

    @field:SerializedName("email")
    var email: String,

    @field:SerializedName("phone")
    val phone: String? = "",

    @field:SerializedName("avatar_url")
    val avatarUrl: String? = "",

    @field:SerializedName("gender")
    val gender: String? = "",

    @field:SerializedName("balance")
    val balance: Double = 0.0,

    @field:SerializedName("income")
    val income: Double = 0.0,

    @field:SerializedName("outcome")
    val outcome: Double = 0.0,

    @field:SerializedName("point")
    val point: Int = 0,

    @field:SerializedName("score")
    val score: Int = 0,

    @field:SerializedName("rank")
    val rank: Int = 0,
)
