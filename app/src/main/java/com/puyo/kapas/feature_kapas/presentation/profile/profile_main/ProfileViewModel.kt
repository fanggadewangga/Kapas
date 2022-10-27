package com.puyo.kapas.feature_kapas.presentation.profile.profile_main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.puyo.kapas.feature_kapas.data.repository.Repository
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.user.UserResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: Repository): ViewModel() {
    val isLoading = mutableStateOf(false)
    val user: MutableState<UserResponse?> = mutableStateOf(null)

    init {
        viewModelScope.launch {
            isLoading.value = true
            val result = repository.fetchUserDetail("1")
            if (result != null)
                user.value = result
            delay(2500L)
            isLoading.value = false
        }
    }
}