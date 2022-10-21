package com.puyo.kapas.feature_kapas.presentation.post_job

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.puyo.kapas.feature_kapas.data.repository.Repository

class PostJobViewModel(private val repository: Repository): ViewModel() {
    var jobName = mutableStateOf("")
    var jobAddress = mutableStateOf("")
    var jobLocation = mutableStateOf("")
    var jobWage = mutableStateOf("")
    var jobDescription = mutableStateOf("")
}