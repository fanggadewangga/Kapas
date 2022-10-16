package com.puyo.kapas.feature_kapas.presentation.util

sealed class Screen(val route: String) {
    object SplashScreen: Screen("splash_screen")
    object LandingScreen: Screen("landing_screen")

    // Auth Screen
    object LoginScreen: Screen("login_screen")
    object SignupScreen: Screen("signup_screen")
    object CameraScreen: Screen("camera_screen")
    object CardVerificationScreen: Screen("card_verification_screen")
    object FaceVerificationScreen: Screen("face_verification_screen")
    object IdentityVerificationScreen: Screen("identity_verification_screen")
    object VerificationSuccessScreen: Screen("verification_success_screen")

    // Home Screen
    object HomeScreen: Screen("home_screen")

    // Job Screen
    object JobScreen: Screen("job_screen")
    object JobDetailScreen: Screen("job_detail_screen")
    object AddJobScreen: Screen("add_job_screen")
    object JobPaymentScreen: Screen("job_payment_screen")

    // History
    object HistoryScreen: Screen("history_screen")

    // Leaderboard
    object LeaderboardScreen: Screen("leaderboard_screen")

    // Profile
    object ProfileScreen: Screen("profile_screen")
    object ProfileSettingScreen: Screen("profile_setting_screen")

    // Reward
    object RewardScreen: Screen("reward_screen")

    // args helper
    fun withArgs(vararg args: String): String{
        return buildString{
            append(route)
            args.forEach { args ->
                append("/$args")
            }
        }
    }

}