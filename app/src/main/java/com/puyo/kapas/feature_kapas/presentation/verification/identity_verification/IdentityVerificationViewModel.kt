package com.puyo.kapas.feature_kapas.presentation.verification.identity_verification

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.puyo.kapas.feature_kapas.data.repository.Repository

class IdentityVerificationViewModel(private val repository: Repository): ViewModel() {
    var cardNumber = mutableStateOf("")
    var name = mutableStateOf("")
    var birthPlace = mutableStateOf("")
    var birthDate = mutableStateOf("")
    var selectedGender = mutableStateOf("")
}