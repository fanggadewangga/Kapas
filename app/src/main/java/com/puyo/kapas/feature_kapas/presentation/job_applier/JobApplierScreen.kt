package com.puyo.kapas.feature_kapas.presentation.job_applier

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.puyo.kapas.R
import com.puyo.kapas.feature_kapas.data.source.dummy.Dummy
import com.puyo.kapas.feature_kapas.presentation.job_applier.components.JobApplierItem
import com.puyo.kapas.feature_kapas.presentation.util.Screen
import com.puyo.kapas.ui.theme.Orange

@Composable
fun JobApplierScreen(navController: NavController) {
    val dummy = remember { Dummy }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(color = Orange)
            .padding(top = 64.dp, bottom = 8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "Arrow",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(24.dp)
                        .clickable { navController.navigate(Screen.ProfileSettingScreen.route) }
                )

                Text(
                    text = "Pelamar Pekerjaan",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(24.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            items(dummy.applier) {
                JobApplierItem(user = it)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }


}

@Preview
@Composable
fun JobApplierScreenPreview() {
    JobApplierScreen(navController = rememberNavController())
}