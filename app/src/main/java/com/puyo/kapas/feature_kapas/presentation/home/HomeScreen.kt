package com.puyo.kapas.feature_kapas.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.puyo.kapas.R
import com.puyo.kapas.feature_kapas.presentation.home.components.JobItem
import com.puyo.kapas.feature_kapas.presentation.home.components.UserWallet
import com.puyo.kapas.feature_kapas.presentation.jobs.components.AnimatedShimmer
import com.puyo.kapas.feature_kapas.presentation.util.Screen
import com.puyo.kapas.feature_kapas.presentation.util.components.BottomNavigationBar
import com.puyo.kapas.ui.components.CustomSearchField
import org.koin.androidx.compose.getViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    val viewModel = getViewModel<HomeViewModel>()
    val coroutineScope = rememberCoroutineScope()
    val systemUiController = rememberSystemUiController()
    val jobs = viewModel.jobs.value
    val isJobsLoading = viewModel.isJobsLoading.value

    SideEffect {
        systemUiController.statusBarDarkContentEnabled = true
    }

    Scaffold(bottomBar = { BottomNavigationBar(navController = navController) }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {

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
                        placeholder = "Temukan pekerjaan harianmu!",
                        valueState = viewModel.query,
                        onSearch = {
                            viewModel.searchJobs(it)
                        }
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
                UserWallet(balance = 350000.0, point = 235)

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
                        .clickable { navController.navigate(Screen.PostJobScreen.route) }
                )

                Text(
                    text = "Direkomendasikan Untukmu",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(vertical = 16.dp)
                )

                if (isJobsLoading)
                    Column {
                        repeat(10) {
                            AnimatedShimmer()
                        }
                    }
                else {
                    jobs.forEach {
                        JobItem(job = it, navController = navController)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

            }
            Spacer(modifier = Modifier.height(64.dp))
        }
    }
}