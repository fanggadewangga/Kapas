package com.puyo.kapas.feature_kapas.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.puyo.kapas.R
import com.puyo.kapas.feature_kapas.presentation.profile.components.CustomActionBar
import com.puyo.kapas.feature_kapas.presentation.util.Screen
import com.puyo.kapas.ui.theme.Orange

@Composable
fun ProfileSettingScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
    val coroutineScope = rememberCoroutineScope()

    SideEffect {
        systemUiController.setSystemBarsColor(Orange)
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .background(color = Color.White)
    ) {

        // Top Bar
        CustomActionBar(
            title = "Pengaturan Profil",
            onClick = {
                navController.navigate(Screen.ProfileScreen.route)
            }
        )

        // Content
        Column(modifier = Modifier.padding(16.dp)) {

            // Avatar and Edit Profile Button
            Text(
                text = "Foto Profil",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray
            )
            Row(modifier = Modifier.padding(top = 16.dp)) {
                
                // Avatar
                Image(
                    painter = painterResource(id = R.drawable.img_avatar),
                    contentDescription = "Avatar",
                    modifier = Modifier.size(64.dp)
                )
                
                // Buttons
                Column(modifier = Modifier.padding(start = 24.dp)) {
                    /*CUSTOM BUTTON*/
                }
            }

            // Settings

        }
    }
}

@Preview
@Composable
fun ProfileSettingPreview() {
    ProfileSettingScreen(navController = rememberNavController())
}