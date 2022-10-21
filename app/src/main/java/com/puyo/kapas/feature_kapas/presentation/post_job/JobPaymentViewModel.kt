package com.puyo.kapas.feature_kapas.presentation.post_job

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.puyo.kapas.feature_kapas.data.repository.Repository

class JobPaymentViewModel(private val repository: Repository): ViewModel() {
    var jobWage = mutableStateOf("")
    var totalPayment = mutableStateOf(1000.0)
}