package com.puyo.kapas.feature_kapas.presentation.profile.profile_setting

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.puyo.kapas.feature_kapas.presentation.profile.components.ShimmerUserAvatar
import com.puyo.kapas.feature_kapas.presentation.profile.components.ShimmerUserIdentity
import com.puyo.kapas.feature_kapas.presentation.profile.components.UserIdentityItem
import com.puyo.kapas.feature_kapas.presentation.profile.components.UserSetting
import com.puyo.kapas.feature_kapas.presentation.util.Screen
import com.puyo.kapas.ui.theme.Orange
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import org.koin.androidx.compose.getViewModel

@Composable
fun ProfileSettingScreen(navController: NavController) {
    val viewModel = getViewModel<ProfileSettingViewModel>()
    val isLoading = viewModel.isLoading.value
    val user = viewModel.user.value
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setSystemBarsColor(Orange)
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
    ) {

        // Action Bar
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(color = Orange)
            .padding(top = 64.dp, bottom = 8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "Arrow",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(24.dp)
                        .clickable { navController.navigate(Screen.ProfileScreen.route) }
                )

                Text(
                    text = "Ubah Email",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.width(24.dp))
            }
        }

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
                if (isLoading)
                    ShimmerUserAvatar()
                else
                    GlideImage(
                        imageModel = {
                            user?.avatarUrl
                        },
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(64.dp),
                        imageOptions = ImageOptions(contentScale = ContentScale.Crop,
                            contentDescription = "Avatar"),
                        previewPlaceholder = R.drawable.img_avatar
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
            if (isLoading)
                ShimmerUserIdentity()
            else
                UserIdentityItem(
                    title = "Nomor E-KTP",
                    description = "Masukkan nomor E-KTP Anda",
                    value = user?.cardNumber ?: "xxxxxxxxxxxxx"
                )
            if (isLoading)
                ShimmerUserIdentity()
            else
                UserIdentityItem(
                    title = "Nama Lengkap",
                    description = "Masukkan nama lengkap sesuai E-KTP Anda",
                    value = user?.name ?: "Username"
                )
            if (isLoading)
                ShimmerUserIdentity()
            else
                UserIdentityItem(
                    title = "Tempat Lahir",
                    description = "Masukkan tempat lahir sesuai E-KTP Anda",
                    value = user?.birthDate ?: "User Birthplace"
                )
        }
    }
}

@Preview
@Composable
fun ProfileSettingPreview() {
    ProfileSettingScreen(navController = rememberNavController())
}