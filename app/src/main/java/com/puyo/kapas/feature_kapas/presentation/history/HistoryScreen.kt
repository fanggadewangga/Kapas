package com.puyo.kapas.feature_kapas.presentation.history

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.puyo.kapas.feature_kapas.data.source.dummy.Dummy
import com.puyo.kapas.feature_kapas.presentation.history.components.HistoryItem
import com.puyo.kapas.feature_kapas.presentation.util.components.BottomNavigationBar
import com.puyo.kapas.ui.components.TopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HistoryScreen(navController: NavController) {

    val dummy = remember {Dummy}
    val coroutineScope = rememberCoroutineScope()

    Scaffold(bottomBar = { BottomNavigationBar(navController = navController) }) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 64.dp)
        ) {
            TopBar(text = "Riwayat Pekerjaan")
            Spacer(modifier = Modifier.height(16.dp))

            // JobList
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                items(dummy.history) {
                    HistoryItem(job = it)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}