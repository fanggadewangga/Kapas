package com.puyo.kapas.feature_kapas.presentation.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.puyo.kapas.feature_kapas.data.repository.Repository
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.job.JobListResponse
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.user.UserResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository): ViewModel() {
    var jobs: MutableState<List<JobListResponse>> = mutableStateOf(ArrayList())
    var user:MutableState<UserResponse?> = mutableStateOf(null)
    var query = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    fun searchJobs(query: String) {
        viewModelScope.launch {
            isLoading.value = true
            val result = repository.fetchSearchJobs(query).data
            if (result != null)
                jobs.value = result
            delay(1500L)
            isLoading.value = false
        }
    }

    init {
        viewModelScope.launch {
            isLoading.value = true
            val jobsResult = repository.fetchJobs()
            val userResult = repository.fetchUserDetail("1")
            if (jobsResult != null) {
                jobs.value = jobsResult
            }
            if (userResult != null)
                user.value = userResult
            delay(3000L)
            isLoading.value = false
        }
    }
}