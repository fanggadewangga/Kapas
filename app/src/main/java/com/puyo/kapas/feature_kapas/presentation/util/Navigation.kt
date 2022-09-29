package com.puyo.kapas.feature_kapas.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.puyo.kapas.feature_kapas.presentation.landing.LandingScreen
import com.puyo.kapas.feature_kapas.presentation.splash.SplashScreen

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

        }

        composable(route = Screen.SignupScreen.route) {

        }

        composable(route = Screen.CameraScreen.route) {

        }

        composable(route = Screen.CardVerificationScreen.route) {

        }

        composable(Screen.FaceVerificationScreen.route) {

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