package com.puyo.kapas.feature_kapas.presentation.post_job

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
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
import com.puyo.kapas.feature_kapas.presentation.jobs.components.JobBottomBar
import com.puyo.kapas.feature_kapas.presentation.post_job.components.PaymentSummary
import com.puyo.kapas.feature_kapas.presentation.util.Screen
import com.puyo.kapas.ui.components.CommonInputField
import com.puyo.kapas.ui.theme.Orange
import org.koin.androidx.compose.getViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun JobPaymentScreen(navController: NavController) {
    val viewModel = getViewModel<JobPaymentViewModel>()

    Scaffold(
        bottomBar = {
            JobBottomBar(
                wage =
                if (viewModel.jobWage.value != "") viewModel.jobWage.value.toDouble() + viewModel.totalPayment.value
                else viewModel.totalPayment.value,
                buttonText = "Bayar",
                paymentDescription = "Total Bayar",
                navController = navController,
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_arrow_down),
                        contentDescription = "Arrow Down",
                        modifier = Modifier.size(14.dp)
                    )
                }
            ) {
                navController.navigate(Screen.SuccessPostJobScreen.route)
            }
        }
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
        ) {

            // Action Bar
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
                            .clickable { navController.navigate(Screen.PostJobScreen.route) }
                    )

                    Text(
                        text = "Total Pembayaran",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.width(24.dp))
                }
            }

            // Besar Gaji Pekerja
            Card(
                elevation = 8.dp,
                backgroundColor = Color.White,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = "Besar Gaji Pekerja",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
                    )
                    CommonInputField(
                        placeholder = "",
                        valueState = viewModel.jobWage
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }

            // Pembayaran
            Card(
                elevation = 8.dp,
                backgroundColor = Color.White,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = "Pembayaran",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        Column {
                            // Saldo
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_wallet),
                                    contentDescription = "Wallet",
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "Saldo",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color.Gray
                                )
                            }

                            // Value
                            Text(
                                text = "Rp 200.000",
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.ic_arrow),
                            contentDescription = "Arrow",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Divider(Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
            )

            // Kupon
            Card(
                elevation = 8.dp,
                backgroundColor = Color.White,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .clickable { navController.navigate(Screen.CouponScreen.route) }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_point),
                        contentDescription = "Point",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Makin hemat gunakan Poin Hadiah",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Gray
                    )
                }
            }

            // Payment Summary
            Spacer(modifier = Modifier.height(16.dp))
            PaymentSummary(
                wage =
                if (viewModel.jobWage.value != "") viewModel.jobWage.value.toDouble()
                else 0.0
            )
        }
    }


}

@Preview
@Composable
fun JobPaymentPreview() {
    JobPaymentScreen(navController = rememberNavController())
}