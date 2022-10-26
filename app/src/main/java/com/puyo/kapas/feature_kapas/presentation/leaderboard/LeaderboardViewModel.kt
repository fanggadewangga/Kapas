package com.puyo.kapas.feature_kapas.presentation.leaderboard

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.puyo.kapas.feature_kapas.data.repository.Repository
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.leaderboard.LeaderboardResponse
import kotlinx.coroutines.launch

class LeaderboardViewModel(private val repository: Repository): ViewModel() {
    var users: MutableState<List<LeaderboardResponse>> = mutableStateOf(ArrayList())

    init {
        viewModelScope.launch {
            val result = repository.fetchLeaderboard()
            if (result != null)
                users.value = result
        }
    }
}