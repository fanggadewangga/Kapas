package com.puyo.kapas.feature_kapas.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.puyo.kapas.R
import com.puyo.kapas.feature_kapas.presentation.util.components.BottomNavigationBar
import com.puyo.kapas.ui.theme.Orange

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
    val coroutineScope = rememberCoroutineScope()

    SideEffect {
        systemUiController.setSystemBarsColor(Orange)
    }

    Scaffold(bottomBar = { BottomNavigationBar(navController = navController) }) {

        LazyColumn(
            modifier = Modifier.padding(bottom = 32.dp)
        ) {
            item {
                Column(modifier = Modifier.fillMaxSize()) {

                    // Top & Search Bar

                    // Content
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                    ) {

                        // Banner
                        Image(
                            painter = painterResource(id = R.drawable.img_banner),
                            contentDescription = "banner",
                            modifier = Modifier
                                .fillMaxWidth()
                        )

                        Text(
                            text = "Pasang Lowongan Pekerjaan",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.padding(vertical = 16.dp)
                        )

                        Image(
                            painter = painterResource(id = R.drawable.img_job_banner),
                            contentDescription = "banner",
                            modifier = Modifier
                                .fillMaxWidth()
                        )

                        Text(
                            text = "Direkomendasikan Untukmu",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.padding(vertical = 16.dp)
                        )


                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun HomePreview() {
    HomeScreen(navController = rememberNavController())
}