package com.puyo.kapas.feature_kapas.presentation.settings.number

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.puyo.kapas.R
import com.puyo.kapas.feature_kapas.presentation.profile.components.UserIdentityItem
import com.puyo.kapas.feature_kapas.presentation.util.Screen
import com.puyo.kapas.ui.components.CommonInputField
import com.puyo.kapas.ui.theme.Orange
import org.koin.androidx.compose.getViewModel

@Composable
fun ChangeNumberScreen(navController: NavController) {
    val viewModel = getViewModel<ChangeNumberViewModel>()

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
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
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
                    text = "Ubah Nomor Telepon",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.width(24.dp))
            }
        }

        // Old number
        UserIdentityItem(
            title = "Nomor telepon saat ini",
            description = null,
            value = "081295584111",
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)
        )

        // New number
        Text(
            fontWeight = FontWeight.Medium,
            text = "Nomor telepon baru",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
        )
        CommonInputField(
            placeholder = "Isi nomor telepon baru",
            valueState = viewModel.newNumber
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