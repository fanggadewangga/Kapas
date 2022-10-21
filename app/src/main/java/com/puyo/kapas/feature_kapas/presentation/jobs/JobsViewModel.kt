package com.puyo.kapas.feature_kapas.presentation.jobs

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.puyo.kapas.feature_kapas.data.repository.Repository

class JobsViewModel(private val repository: Repository): ViewModel() {
    var query = mutableStateOf("")
}