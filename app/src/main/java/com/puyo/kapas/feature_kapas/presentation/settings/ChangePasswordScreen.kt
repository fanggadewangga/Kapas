package com.puyo.kapas.feature_kapas.presentation.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.puyo.kapas.R
import com.puyo.kapas.feature_kapas.presentation.profile.components.UserIdentityItem
import com.puyo.kapas.feature_kapas.presentation.util.Screen
import com.puyo.kapas.ui.components.CommonInputField
import com.puyo.kapas.ui.theme.Orange

@Composable
fun ChangePasswordScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {

        // Action Bar
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(color = Orange)
            .padding(top = 64.dp, bottom = 8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "Arrow",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(24.dp)
                        .clickable { navController.navigate(Screen.ProfileSettingScreen.route) }
                )

                Text(
                    text = "Ubah Kata Sandi",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(start = 88.dp)
                )
            }
        }

        // Old password
        UserIdentityItem(
            title = "Kata sandi saat ini",
            description = null,
            value = "**********",
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)
        )

        // New password
        Text(
            fontWeight = FontWeight.Medium,
            text = "Kata sandi baru",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
        )
        CommonInputField(
            placeholder = "****************"
        )

        // Confirm new password
        Text(
            fontWeight = FontWeight.Medium,
            text = "Konfirmasi kata sandi baru",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
        )
        CommonInputField(
            placeholder = "****************"
        )

        // Button
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                navController.navigate(Screen.ProfileSettingScreen.route)
            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(Orange),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Konfirmasi",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun ChangePasswordPreview() {
    ChangePasswordScreen(navController = rememberNavController())
}