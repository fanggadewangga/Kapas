package com.puyo.kapas.feature_kapas.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.puyo.kapas.feature_kapas.presentation.auth.LoginScreen
import com.puyo.kapas.feature_kapas.presentation.auth.SignupScreen
import com.puyo.kapas.feature_kapas.presentation.landing.LandingScreen
import com.puyo.kapas.feature_kapas.presentation.splash.SplashScreen
import com.puyo.kapas.feature_kapas.presentation.verification.CardVerificationScreen
import com.puyo.kapas.feature_kapas.presentation.verification.FaceVerificationScreen

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

        composable(route = Screen.CameraScreen.route) {

        }

        composable(route = Screen.CardVerificationScreen.route) {
            CardVerificationScreen(navController = navController)
        }

        composable(Screen.FaceVerificationScreen.route) {
            FaceVerificationScreen(navController = navController)
        }

        composable(Screen.IdentityVerificationScreen.route) {

        }

        composable(route = Screen.ConfirmedVerificationScreen.route) {

        }

        composable(route = Screen.HomeScreen.route) {

        }

        composable(route = Screen.JobScreen.route) {

        }

        composable(route = Screen.JobDetailScreen.route) {

        }

        composable(route = Screen.HistoryScreen.route) {

        }

        composable(route = Screen.LeaderboardScreen.route) {

        }

        composable(route = Screen.ProfileScreen.route) {

        }
    }
}