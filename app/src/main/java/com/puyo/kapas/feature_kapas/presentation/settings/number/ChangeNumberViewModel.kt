package com.puyo.kapas.feature_kapas.presentation.settings.number

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.puyo.kapas.feature_kapas.data.repository.Repository

class ChangeNumberViewModel(private val repository: Repository): ViewModel() {
    var newNumber = mutableStateOf("")
}