package com.puyo.kapas.feature_kapas.presentation.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.puyo.kapas.feature_kapas.data.repository.Repository
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
            repository.signInUser(emailState.value, passwordState.value)
            val uid = repository.getCurrentUserId().toString()
            repository.logOut()
        }
    }
}