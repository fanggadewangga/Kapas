package com.puyo.kapas.feature_kapas.domain.model.user

data class User(
    val uid: String,
    val cardNumber: String?,
    val name: String?,
    val address: String?,
    val birthPlace: String?,
    val birthDate: String?,
    val email: String,
    val phone: String?,
    val avatarUrl: String?,
    val gender: String?,
    val balance: Double,
    val income: Double,
    val outcome: Double,
    val point: Int,
    val score: Int,
    val rank: Int
)
