package com.puyo.kapas.feature_kapas.presentation.settings.email

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.puyo.kapas.feature_kapas.data.repository.Repository

class ChangeEmailViewModel(private val repository: Repository): ViewModel() {
    var newEmail = mutableStateOf("")
}