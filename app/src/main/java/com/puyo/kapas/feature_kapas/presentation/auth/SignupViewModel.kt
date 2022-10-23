package com.puyo.kapas.feature_kapas.presentation.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.auth.User
import com.puyo.kapas.feature_kapas.data.repository.Repository
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.user.UserBody
import kotlinx.coroutines.launch

class SignupViewModel(private val repository: Repository) : ViewModel() {
    var emailState = mutableStateOf("")
    var passwordState = mutableStateOf("")
    var confirmPasswordState = mutableStateOf("")

    fun signUp() {
        viewModelScope.launch {
            repository.signUpUser(
                emailState.value,
                passwordState.value
            )
        }
    }
}