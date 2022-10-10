package com.puyo.kapas.feature_kapas.presentation.history

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.puyo.kapas.feature_kapas.presentation.util.components.BottomNavigationBar
import com.puyo.kapas.feature_kapas.presentation.verification.components.TopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HistoryScreen(navController: NavController) {

    val coroutineScope = rememberCoroutineScope()

    Scaffold(bottomBar = { BottomNavigationBar(navController = navController) }) {
        TopBar(text = "Riwayat Pekerjaan")

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                /*TODO : MAKE DUMMY OF JOB LIST TO TEST THE UI*/
            }
        }
    }
}