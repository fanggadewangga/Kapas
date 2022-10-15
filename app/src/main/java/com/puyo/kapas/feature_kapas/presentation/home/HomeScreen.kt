package com.puyo.kapas.feature_kapas.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
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
import com.puyo.kapas.feature_kapas.presentation.home.components.UserWallet
import com.puyo.kapas.feature_kapas.presentation.util.components.BottomNavigationBar
import com.puyo.kapas.ui.components.CustomSearchField

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {

    val coroutineScope = rememberCoroutineScope()
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.statusBarDarkContentEnabled = true
    }

    Scaffold(bottomBar = { BottomNavigationBar(navController = navController) }) {

        Column(modifier = Modifier.fillMaxSize()) {

            // Top & Search Bar
            Box(modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_profile_bg),
                    contentDescription = "Background",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(96.dp)
                )
                Column {
                    Spacer(modifier = Modifier.height(64.dp))
                    CustomSearchField(
                        leadingIcon = {
                            Image(
                                painter = painterResource(id = R.drawable.ic_search),
                                contentDescription = "Search",
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        placeholder = "Temukan pekerjaan harianmu!"
                    )
                }
               
            }

            // Content
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
            ) {

                Spacer(modifier = Modifier.height(24.dp))
                // Wallet
                UserWallet(balance = 300000.0, point = 1272)

                Spacer(modifier = Modifier.height(24.dp))
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
            
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ){
                /*TODO : MAKE DUMMY OF JOB LIST TO TEST THE UI*/
            }
        }
    }
}


@Preview
@Composable
fun HomePreview() {
    HomeScreen(navController = rememberNavController())
}