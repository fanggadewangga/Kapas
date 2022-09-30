package com.puyo.kapas.feature_kapas.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.puyo.kapas.R
import com.puyo.kapas.feature_kapas.presentation.util.Constants.TIME_SPLASH
import com.puyo.kapas.feature_kapas.presentation.util.Screen
import com.puyo.kapas.ui.theme.Orange
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Orange
        )
    }

    LaunchedEffect(key1 = true) {
        delay(TIME_SPLASH)
        navController.navigate(Screen.LandingScreen.route) {
            popUpTo(Screen.SplashScreen.route) {
                inclusive = true
            }
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Orange)
    ) {

        Spacer(modifier = Modifier.height(160.dp))
        Image(
            painter = painterResource(id = R.drawable.logo_kapas),
            contentDescription = "Kapas Logo",
            modifier = Modifier
                .size(190.dp)
        )

        Spacer(modifier = Modifier.height(56.dp))
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(id = R.drawable.cloud),
                contentDescription = "Cloud",
                modifier = Modifier
                    .fillMaxSize()
            )

            Image(
                painter = painterResource(id = R.drawable.jobhunt),
                contentDescription = "Jobhunt",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(56.dp)
            )
            }
        }
    }

@Preview
@Composable
fun Preview() {
    SplashScreen(rememberNavController())
}
