package com.puyo.kapas.feature_kapas.presentation.job

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.puyo.kapas.R
import com.puyo.kapas.feature_kapas.presentation.util.Screen
import com.puyo.kapas.feature_kapas.presentation.util.components.BottomNavigationBar
import com.puyo.kapas.ui.theme.Orange

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun JobScreen(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.statusBarDarkContentEnabled = true
    }

    Scaffold(bottomBar = { BottomNavigationBar(navController = navController) }) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
        ) {

            // Banner
            Spacer(modifier = Modifier.height(40.dp))
            Image(
                painter = painterResource(id = R.drawable.img_job_banner),
                contentDescription = "Banner",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate(Screen.JobDetailScreen.route) }
            )

            Spacer(modifier = Modifier.height(16.dp))
            // Search Bar
            Box(modifier = Modifier
                .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .height(49.dp)
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color.Gray,
                        focusedBorderColor = Orange,
                        cursorColor = Orange
                    ),
                    placeholder = {
                        Text(
                            text = "Temukan pekerjaan harianmu!",
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "Search",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    modifier = Modifier.matchParentSize()
                )
            }

            // Title
            Text(
                text = "Temukan Pekerjaan",
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            // JobList
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                /*TODO : MAKE DUMMY OF JOB LIST TO TEST THE UI*/
            }
        }
    }
}
