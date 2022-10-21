package com.puyo.kapas.feature_kapas.presentation.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.puyo.kapas.feature_kapas.data.repository.Repository

class LoginViewModel(private val repository: Repository): ViewModel() {
    var emailState = mutableStateOf("")
    var passwordState = mutableStateOf("")
}