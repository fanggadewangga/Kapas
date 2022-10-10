package com.puyo.kapas.feature_kapas.data.source.remote.api.model.leaderboard

import com.google.gson.annotations.SerializedName

data class LeaderboardResponse(
    @field:SerializedName("uid")
    val uid: String,

    @field:SerializedName("name")
    val name: String?,

    @field:SerializedName("score")
    val score: Int,

    @field:SerializedName("avatar_url")
    val avatarUrl: String?
)
