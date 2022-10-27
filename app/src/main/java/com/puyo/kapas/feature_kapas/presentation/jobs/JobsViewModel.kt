package com.puyo.kapas.feature_kapas.presentation.jobs

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.puyo.kapas.feature_kapas.data.repository.Repository
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.job.JobListResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class JobsViewModel(private val repository: Repository): ViewModel() {
    var jobs: MutableState<List<JobListResponse>> = mutableStateOf(ArrayList())
    var query = mutableStateOf("")
    var isJobsLoading = mutableStateOf(false)

    fun searchJobs(query: String) {
        viewModelScope.launch {
            isJobsLoading.value = true
            val result = repository.fetchSearchJobs(query).data
            if (result != null)
                jobs.value = result
            delay(700L)
            isJobsLoading.value = false
        }
    }

    init {
        viewModelScope.launch {
            isJobsLoading.value = true
            val result = repository.fetchJobs()
            if (result != null) {
                jobs.value = result
            }
            delay(3000L)
            isJobsLoading.value = false
        }
    }
}