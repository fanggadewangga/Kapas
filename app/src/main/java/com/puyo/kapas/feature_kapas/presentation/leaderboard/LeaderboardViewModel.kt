package com.puyo.kapas.feature_kapas.presentation.leaderboard

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.puyo.kapas.feature_kapas.data.repository.Repository
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.leaderboard.LeaderboardResponse

class LeaderboardViewModel(private val repository: Repository): ViewModel() {
    var jobs: MutableState<List<LeaderboardResponse>> = mutableStateOf(ArrayList())

}