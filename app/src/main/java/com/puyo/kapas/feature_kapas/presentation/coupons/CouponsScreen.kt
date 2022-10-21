package com.puyo.kapas.feature_kapas.presentation.coupons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.puyo.kapas.feature_kapas.presentation.coupons.components.CouponItem
import com.puyo.kapas.feature_kapas.presentation.profile.components.CustomActionBar
import com.puyo.kapas.feature_kapas.presentation.util.Screen
import com.puyo.kapas.ui.theme.Grey

@Composable
fun CouponScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxWidth()) {
        CustomActionBar(
            title = "Tukarkan Poin Hadiah",
            onClick = {
                navController.navigate(Screen.PostJobScreen.route)
            }
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(top = 16.dp, start = 24.dp, end = 24.dp)
        ) {


            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.ic_point),
                        contentDescription = "Point",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Point Saya",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 2.dp)
                    )
                }
                Text(
                    text = "235",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Divider(
                thickness = 1.dp,
                color = Grey,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                item {
                    for (i in 1..15) {
                        CouponItem()
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                }
            }
        }
    }
}

@Preview
@Composable
fun CouponScreenPrev() {
    CouponScreen(navController = rememberNavController())
}