package com.puyo.kapas.feature_kapas.presentation.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.puyo.kapas.R
import com.puyo.kapas.feature_kapas.presentation.profile.components.CustomActionBar
import com.puyo.kapas.feature_kapas.presentation.profile.components.UserIdentityItem
import com.puyo.kapas.feature_kapas.presentation.profile.components.UserSetting
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
        Column(modifier = Modifier.padding(16.dp)
        ) {

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
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(start = 24.dp)
                ) {

                    // Upload Photo
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(height = 24.dp, width = 99.dp)
                            .background(shape = RoundedCornerShape(16.dp), color = Orange)
                            .clickable {
                                /*TODO*/
                            }
                    ) {
                        Text(
                            text = "Unggah Foto",
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Delete Photo
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(1.dp, Orange),
                        modifier = Modifier
                            .size(height = 24.dp, width = 99.dp)
                            .clickable {
                                /*TODO*/
                            }
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Hapus Foto",
                                color = Orange,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                        }

                    }
                }
            }

            // Settings
            Spacer(modifier = Modifier.height(16.dp))
            UserSetting(navController = navController)
            
            // User Identity
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Identitas Diri",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            UserIdentityItem(
                title = "Nomor E-KTP",
                description = "Masukkan nomor E-KTP Anda",
                value = "31234567890"
            )
            UserIdentityItem(
                title = "Nama Lengkap",
                description = "Masukkan nama lengkap sesuai E-KTP Anda",
                value = "FANGGI DHYANA"
            )
            UserIdentityItem(
                title = "Tempat Lahir" ,
                description = "Masukkan tempat lahir sesuai E-KTP Anda",
                value = "MALANG"
            )
        }
    }
}

@Preview
@Composable
fun ProfileSettingPreview() {
    ProfileSettingScreen(navController = rememberNavController())
}