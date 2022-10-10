package com.puyo.kapas.feature_kapas.presentation.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.puyo.kapas.R
import com.puyo.kapas.feature_kapas.presentation.profile.components.Features
import com.puyo.kapas.feature_kapas.presentation.profile.components.Rank
import com.puyo.kapas.feature_kapas.presentation.profile.components.Wallet
import com.puyo.kapas.feature_kapas.presentation.util.Screen
import com.puyo.kapas.feature_kapas.presentation.util.components.BottomNavigationBar
import com.puyo.kapas.ui.theme.Orange

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController: NavController) {
    val systemUiController = rememberSystemUiController()
    val coroutineScope = rememberCoroutineScope()

    SideEffect {
        systemUiController.setSystemBarsColor(Orange)
    }

    Scaffold(bottomBar = { BottomNavigationBar(navController = navController) }) {
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
        ) {

            // Top Section
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {

                Image(
                    painter = painterResource(id = R.drawable.img_profile_bg),
                    contentDescription = "Background",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(196.dp)
                )

                Column(modifier = Modifier.padding(top = 72.dp)) {
                    // Avatar, Username, Email, and Phone
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp)
                    ) {
                        // Avatar
                        Box {
                            Image(
                                painter = painterResource(id = R.drawable.img_avatar),
                                contentDescription = "Avatar",
                                modifier = Modifier.size(64.dp)
                            )
                            Image(
                                painter = painterResource(id = R.drawable.ic_verified),
                                contentDescription = "Verified",
                                modifier = Modifier
                                    .size(18.dp)
                                    .align(Alignment.BottomEnd)
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(
                                text = "Username",
                                fontSize = 16.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Medium
                            )


                            // Email
                            Spacer(modifier = Modifier.height(4.dp))
                            Row {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_email),
                                    contentDescription = "Email",
                                    tint = Color.White,
                                    modifier = Modifier.size(16.dp)
                                )
                                Text(
                                    text = "Useremail@gmail.com",
                                    fontSize = 12.sp,
                                    color = Color.White,
                                    modifier = Modifier.padding(start = 8.dp)
                                )
                            }

                            // Phone Number
                            Spacer(modifier = Modifier.height(4.dp))
                            Row {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_phone),
                                    contentDescription = "Phone",
                                    tint = Color.White,
                                    modifier = Modifier.size(16.dp)
                                )
                                Text(
                                    text = "081234567890",
                                    fontSize = 12.sp,
                                    color = Color.White,
                                    modifier = Modifier.padding(start = 8.dp)
                                )
                            }
                        }
                    }
                    Wallet(
                        balance = 200000.0,
                        points = 1282,
                        income = 1212.0,
                        outcome = 2222.0,
                        modifier = Modifier.padding(top = 64.dp)
                    )
                }
            }

            Text(
                text = "Peringkat pekerja",
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 16.dp, bottom = 12.dp, start = 16.dp)
            )
            Rank(score = 2191, rank = 407)

            Text(
                text = "Fitur",
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 24.dp, bottom = 12.dp, start = 16.dp)
            )
            Features(navController)

            Text(
                text = "Pengaturan",
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 24.dp, bottom = 12.dp, start = 16.dp)
            )
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = 8.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                // Job History
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { navController.navigate(Screen.ProfileSettingScreen.route) }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_setting),
                        contentDescription = "Setting Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Pengaturan profil",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(navController = rememberNavController())
}