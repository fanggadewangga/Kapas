package com.puyo.kapas.feature_kapas.presentation.post_job

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.puyo.kapas.R
import com.puyo.kapas.feature_kapas.presentation.util.Screen
import com.puyo.kapas.ui.theme.Orange
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SuccessPostJobScreen(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()

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
                        .clickable { navController.navigate(Screen.HomeScreen.route) }
                )

                Text(
                    text = "Verifikasi",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White,
                )

                Spacer(modifier = Modifier.width(24.dp))
            }
        }


        // Content
        Spacer(modifier = Modifier.height(160.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(painter = painterResource(
                id = R.drawable.img_verification_success),
                contentDescription = "Card",
                modifier = Modifier
                    .size(186.dp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Kami telah menerima berkas Anda dan pembayaran Anda, sekarang akan segera diproses. Silahkan tunggu, kami sedang bekerja secepat yang kami bisa!",
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .size(width = 278.dp, height = 72.dp)
            )
        }
    }

    coroutineScope.launch {
        delay(3000L)
        navController.navigate(Screen.HomeScreen.route)
    }
}


@Preview
@Composable
fun SuccessPrev() {
    SuccessPostJobScreen(navController = rememberNavController())
}