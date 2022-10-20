package com.puyo.kapas.feature_kapas.presentation.verification

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.puyo.kapas.R
import com.puyo.kapas.feature_kapas.presentation.util.Screen
import com.puyo.kapas.ui.components.TopBar
import com.puyo.kapas.ui.theme.Orange

@Composable
fun CardVerificationScreen(navController: NavController) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setSystemBarsColor(Orange)
    }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Row {
            TopBar(text = "Verifikasi KTP/E-KTP")
        }

        Spacer(modifier = Modifier.height(72.dp))
        Text(
            text = "Siapkan E-KTP Fisik Anda",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = buildAnnotatedString {
                append("Harap tambahkan dokumen pendukung, jika E-KTP fisik anda ")
                withStyle(style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                )) {
                    append("tidak dapat dibaca ")
                }
                append("atau dalam ")
                withStyle(style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                )) {
                    append("kondisi yang buruk.")
                }
            },
            fontWeight = FontWeight.Light,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 40.dp)
        )

        Spacer(modifier = Modifier.height(120.dp))
        Image(painter = painterResource(
            id = R.drawable.img_card_verification),
            contentDescription = "Card",
            modifier = Modifier
                .size(240.dp)
        )

        Spacer(modifier = Modifier.height(72.dp))
        Image(
            painter = painterResource(id = R.drawable.img_data),
            contentDescription = "Data",
            modifier = Modifier.padding(horizontal = 28.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                navController.navigate(Screen.CardVerificationCameraScreen.route)
            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(Orange),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 28.dp)
        ) {
            Text(
                text = "Mulai",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}