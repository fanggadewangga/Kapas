package com.puyo.kapas.feature_kapas.presentation.util.components

import com.puyo.kapas.R

sealed class NavigationItem(
    var route: String,
    var icon: Int,
    var iconSelected: Int,
    var title: String
) {
    object Home: NavigationItem("home_screen", R.drawable.ic_home, R.drawable.ic_home_selected, "Beranda" )
    object Job: NavigationItem("job_screen", R.drawable.ic_job, R.drawable.ic_job_selected, "Pekerjaan")
    object History: NavigationItem("history_screen", R.drawable.ic_history, R.drawable.ic_history_selected, "Riwayat")
    object Leaderboard: NavigationItem("leaderboard_screen", R.drawable.ic_leaderboard, R.drawable.ic_leaderboard_selected, "Peringkat")
    object Profile: NavigationItem("profile_screen", R.drawable.ic_profile, R.drawable.ic_profile_selected, "Profil")
}