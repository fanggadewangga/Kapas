package com.puyo.kapas.feature_kapas.domain.model.leaderboard

import android.os.Parcelable
import com.puyo.kapas.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Leaderboard(
    val uid: String,
    val name: String?,
    val score: Int,
    val avatarUrl: String? = null,
    val avatar: Int = R.drawable.img_avatar
): Parcelable
