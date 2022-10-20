package com.puyo.kapas.feature_kapas.presentation.landing

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
import com.puyo.kapas.feature_kapas.presentation.util.Screen
import com.puyo.kapas.ui.theme.Orange

@Composable
fun LandingScreen(navController: NavController) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setSystemBarsColor(color = Orange)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(Orange)) {

        Spacer(modifier = Modifier.height(160.dp))
        Image(painter = painterResource(id = R.drawable.img_jobhunt_landing),
            contentDescription = "Kapas Logo",
            modifier = Modifier.size(190.dp))

        Spacer(modifier = Modifier.height(32.dp))
        Text(fontSize = 22.sp,
            fontWeight = FontWeight.ExtraBold,
            text = "Temukan Pekerjaan Anda\ndan Hidup Lebih Sejahtera",
            textAlign = TextAlign.Center,
            color = Color.White)

        Spacer(modifier = Modifier.height(32.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)) {

            Image(painter = painterResource(id = R.drawable.img_cloud),
                contentDescription = "Cloud",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
            )

            Button(
                onClick = {
                    navController.navigate(Screen.SignupScreen.route)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 72.dp)
            ) {
                Text(
                    text = "Lanjut",
                    color = Orange,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_next),
                    modifier = Modifier.size(16.dp),
                    contentDescription = "Arrow Next")
            }
            }

        }
    }

@Preview
@Composable
fun Preview() {
    LandingScreen(navController = rememberNavController())
}