package com.puyo.kapas.feature_kapas.domain.model.leaderboard

data class Leaderboard(
    val uid: String,
    val name: String?,
    val score: Int,
    val avatarUrl: String
)
