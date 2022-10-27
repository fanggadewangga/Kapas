package com.puyo.kapas.feature_kapas.presentation.jobs

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.puyo.kapas.R
import com.puyo.kapas.feature_kapas.data.source.dummy.Dummy
import com.puyo.kapas.feature_kapas.presentation.home.components.JobItem
import com.puyo.kapas.feature_kapas.presentation.jobs.components.AnimatedShimmer
import com.puyo.kapas.feature_kapas.presentation.util.Screen
import com.puyo.kapas.feature_kapas.presentation.util.components.BottomNavigationBar
import com.puyo.kapas.ui.components.CustomSearchField
import org.koin.androidx.compose.getViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun JobScreen(navController: NavController) {
    val viewModel = getViewModel<JobsViewModel>()
    val jobs = viewModel.jobs.value
    val isJobsLoading = viewModel.isJobsLoading.value
    val dummy = remember { Dummy }
    val coroutineScope = rememberCoroutineScope()
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.statusBarDarkContentEnabled = true
    }

    Scaffold(bottomBar = { BottomNavigationBar(navController = navController) }) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, bottom = 64.dp)
        ) {

            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.img_gradien_bg),
                    contentDescription = "Background"
                )
                Column(Modifier.fillMaxWidth()) {
                    // Banner
                    Spacer(modifier = Modifier.height(40.dp))
                    Image(
                        painter = painterResource(id = R.drawable.img_job_banner),
                        contentDescription = "Banner",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .clickable { navController.navigate(Screen.PostJobScreen.route) }
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    // Search Bar
                    CustomSearchField(
                        leadingIcon = {
                            Image(
                                painter = painterResource(id = R.drawable.ic_search),
                                contentDescription = "Search",
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        placeholder = "Temukan pekerjaan harianmu!",
                        modifier = Modifier.fillMaxWidth(),
                        valueState = viewModel.query,
                        onSearch = {
                            viewModel.searchJobs(it)
                        }
                    )
                }

            }

            // Title
            Text(
                text = "Temukan Pekerjaan",
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(16.dp)
            )

            // JobList
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                item {
                    if (isJobsLoading) {
                        repeat(15) {
                            AnimatedShimmer()
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    } else {
                        jobs.forEach { job ->
                            JobItem(job = job, navController = navController)
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }
        }
    }
}

