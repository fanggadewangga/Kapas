package com.puyo.kapas.feature_kapas.presentation.leaderboard

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.puyo.kapas.feature_kapas.data.source.dummy.Dummy
import com.puyo.kapas.feature_kapas.presentation.leaderboard.components.LeaderboardItem
import com.puyo.kapas.feature_kapas.presentation.util.components.BottomNavigationBar
import com.puyo.kapas.ui.theme.Orange
import org.koin.androidx.compose.getViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LeaderboardScreen(navController: NavController) {
    val viewModel = getViewModel<LeaderboardViewModel>()
    val dummy = remember { Dummy }
    val coroutineScope = rememberCoroutineScope()
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.statusBarDarkContentEnabled = true
    }

    Scaffold(bottomBar = { BottomNavigationBar(navController = navController) }) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp, bottom = 56.dp)
        ) {
            // Top Bar
            Column {
                Spacer(modifier = Modifier.height(40.dp))
                Box(
                    contentAlignment = Alignment.TopCenter
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.img_gradien_bg),
                        contentDescription = "Background",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .height(120.dp)
                            .fillMaxWidth()
                    )

                    // Header
                    Row(horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 36.dp)
                            .height(48.dp)
                            .background(color = Orange, shape = RoundedCornerShape(8.dp))
                    ) {
                        Text(
                            text = "Peringkat",
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    // Column Info
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp, top = 100.dp)
                            .height(32.dp)
                            .background(color = Orange, shape = RoundedCornerShape(8.dp))
                    ) {

                        Text(
                            text = "No.",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            modifier = Modifier.padding(start = 12.dp)
                        )

                        Text(
                            text = "Profil",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            modifier = Modifier.padding(start = 24.dp)
                        )

                        Text(
                            text = "Nama",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            modifier = Modifier.padding(start = 24.dp)
                        )

                        Text(
                            text = "Skor",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            modifier = Modifier.padding(start = 112.dp, end = 32.dp)
                        )

                        Text(
                            text = "Hadiah",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White
                        )
                    }

                }
            }


            // Leaderboard List
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(dummy.leaderboards) {
                    LeaderboardItem(user = it, navController = navController)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }

}

@Preview
@Composable
fun LeaderboardPrev() {
    LeaderboardScreen(navController = rememberNavController())
}