package com.puyo.kapas.feature_kapas.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.puyo.kapas.feature_kapas.domain.model.job.Job
import com.puyo.kapas.feature_kapas.presentation.add_job.JobPaymentScreen
import com.puyo.kapas.feature_kapas.presentation.add_job.PostJobScreen
import com.puyo.kapas.feature_kapas.presentation.add_job.components.SuccessPostJobScreen
import com.puyo.kapas.feature_kapas.presentation.auth.LoginScreen
import com.puyo.kapas.feature_kapas.presentation.auth.SignupScreen
import com.puyo.kapas.feature_kapas.presentation.camera.CardVerificationCameraScreen
import com.puyo.kapas.feature_kapas.presentation.camera.FaceVerificationCameraScreen
import com.puyo.kapas.feature_kapas.presentation.history.HistoryScreen
import com.puyo.kapas.feature_kapas.presentation.home.HomeScreen
import com.puyo.kapas.feature_kapas.presentation.job_detail.JobDetailScreen
import com.puyo.kapas.feature_kapas.presentation.jobs.JobScreen
import com.puyo.kapas.feature_kapas.presentation.landing.LandingScreen
import com.puyo.kapas.feature_kapas.presentation.leaderboard.LeaderboardScreen
import com.puyo.kapas.feature_kapas.presentation.profile.ProfileScreen
import com.puyo.kapas.feature_kapas.presentation.profile.ProfileSettingScreen
import com.puyo.kapas.feature_kapas.presentation.reward.RewardScreen
import com.puyo.kapas.feature_kapas.presentation.settings.ChangeEmailScreen
import com.puyo.kapas.feature_kapas.presentation.settings.ChangeNumberScreen
import com.puyo.kapas.feature_kapas.presentation.settings.ChangePasswordScreen
import com.puyo.kapas.feature_kapas.presentation.splash.SplashScreen
import com.puyo.kapas.feature_kapas.presentation.verification.CardVerificationScreen
import com.puyo.kapas.feature_kapas.presentation.verification.FaceVerificationScreen
import com.puyo.kapas.feature_kapas.presentation.verification.IdentityVerificationScreen
import com.puyo.kapas.feature_kapas.presentation.verification.VerificationSuccessScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.SplashScreen.route ) {

        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.LandingScreen.route) {
            LandingScreen(navController = navController)
        }

        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }

        composable(route = Screen.SignupScreen.route) {
            SignupScreen(navController = navController)
        }

        composable(route = Screen.CardVerificationScreen.route) {
            CardVerificationScreen(navController = navController)
        }

        composable(route = Screen.CardVerificationCameraScreen.route) {
            CardVerificationCameraScreen(navController = navController)
        }

        composable(Screen.FaceVerificationScreen.route) {
            FaceVerificationScreen(navController = navController)
        }
        
        composable(Screen.FaceVerificationCameraScreen.route) {
            FaceVerificationCameraScreen(navController = navController)
        }

        composable(Screen.IdentityVerificationScreen.route) {
            IdentityVerificationScreen(navController = navController)
        }

        composable(route = Screen.VerificationSuccessScreen.route) {
            VerificationSuccessScreen(navController = navController)
        }

        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.JobScreen.route) {
            JobScreen(navController = navController)
        }

        composable(route = Screen.JobDetailScreen.route) {
            val result = navController.previousBackStackEntry?.savedStateHandle?.get<Job>(
                key = "job"
            )
            result?.let { it1 -> JobDetailScreen(navController = navController, job = it1) }
        }

        composable(route = Screen.HistoryScreen.route) {
            HistoryScreen(navController = navController)
        }

        composable(route = Screen.LeaderboardScreen.route) {
            LeaderboardScreen(navController = navController)
        }

        composable(route = Screen.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }

        composable(route = Screen.ProfileSettingScreen.route){
            ProfileSettingScreen(navController = navController)
        }
        
        composable(route = Screen.PostJobScreen.route){
            PostJobScreen(navController = navController)
        }
        
        composable(route = Screen.JobPaymentScreen.route){
            JobPaymentScreen(navController = navController)
        }
        
        composable(route = Screen.RewardScreen.route) {
            RewardScreen(navController = navController)
        }
        
        composable(route = Screen.ChangeEmailScreen.route) {
            ChangeEmailScreen(navController = navController)
        }
        
        composable(route = Screen.ChangeNumberScreen.route) {
            ChangeNumberScreen(navController = navController)
        }
        
        composable(route = Screen.ChangePasswordScreen.route) {
            ChangePasswordScreen(navController = navController)
        }
        
        composable(route = Screen.SuccessPostJobScreen.route) {
            SuccessPostJobScreen(navController = navController)
        }
    }
}