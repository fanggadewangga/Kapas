package com.puyo.kapas.feature_kapas.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.puyo.kapas.feature_kapas.data.repository.Repository

class HomeViewModel(private val repository: Repository): ViewModel() {
    var query = mutableStateOf("")
}