package com.puyo.kapas.feature_kapas.domain.model.history

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class History(
    val transactionId: String,
    val jobId: String,
    val title: String,
    val wage: Double
): Parcelable
