package com.puyo.kapas.feature_kapas.data.source.remote.api.model.user

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @field:SerializedName("uid")
    val uid: String,

    @field:SerializedName("card_number")
    val cardNumber: String?,

    @field:SerializedName("name")
    val name: String?,

    @field:SerializedName("address")
    val address: String?,

    @field:SerializedName("birth_place")
    val birthPlace: String?,

    @field:SerializedName("birth_date")
    val birthDate: String?,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("phone")
    val phone: String?,

    @field:SerializedName("avatar_url")
    val avatarUrl: String?,

    @field:SerializedName("gender")
    val gender: String?,

    @field:SerializedName("balance")
    val balance: Double,

    @field:SerializedName("income")
    val income: Double,

    @field:SerializedName("outcome")
    val outcome: Double,

    @field:SerializedName("point")
    val point: Int,

    @field:SerializedName("score")
    val score: Int,

    @field:SerializedName("rank")
    val rank: Int
)
