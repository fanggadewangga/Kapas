package com.puyo.kapas.feature_kapas.presentation.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.puyo.kapas.feature_kapas.data.repository.Repository
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.user.UserBody

class SignupViewModel(private val repository: Repository): ViewModel() {
    var emailState = mutableStateOf("")
    var passwordState = mutableStateOf("")
    var confirmPasswordState = mutableStateOf("")

    suspend fun signUpUser() = repository.signUpUser(
        email = emailState.value,
        password =  passwordState.value,
        body = UserBody(uid = "", email = emailState.value)
    )
}