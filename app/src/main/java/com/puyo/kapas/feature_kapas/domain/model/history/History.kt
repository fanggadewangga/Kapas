package com.puyo.kapas.feature_kapas.domain.model.history

data class History(
    val transactionId: String,
    val jobId: String,
    val title: String,
    val wage: Double
)