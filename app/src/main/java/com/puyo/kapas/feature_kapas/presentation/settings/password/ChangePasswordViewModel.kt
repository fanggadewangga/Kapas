package com.puyo.kapas.feature_kapas.presentation.settings.password

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.puyo.kapas.feature_kapas.data.repository.Repository

class ChangePasswordViewModel(private val repository: Repository): ViewModel() {
    var newPassword = mutableStateOf("")
    var confirmNewPassword = mutableStateOf("")
}