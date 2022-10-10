package com.puyo.kapas.feature_kapas.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import com.puyo.kapas.R

@Composable
fun Wallet(
    balance: Double,
    points: Int,
    income: Double,
    outcome: Double,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 24.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
        ) {

            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                // Balance & Income
                Column {

                    // Balance
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_wallet),
                            contentDescription = "Wallet",
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = "Saldo",
                            color = Color.Gray,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }

                    // Value
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Rp. ${balance.toInt()}",
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )

                    // Income
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_income),
                            contentDescription = "Income",
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = "Pemasukan",
                            color = Color.Gray,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }

                    // Value
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Rp. ${income.toInt()}",
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.ic_line),
                    contentDescription = "Line",
                    modifier = Modifier.size(height = 80.dp, width = 1.dp)
                )

                // Point & Outcome
                Column {

                    // Point
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_point),
                            contentDescription = "Point",
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = "Poin",
                            color = Color.Gray,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }

                    // Value
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "${points.toInt()}",
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )

                    // Income
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_outcome),
                            contentDescription = "Outcome",
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = "Pengeluaran",
                            color = Color.Gray,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }

                    // Value
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Rp. ${outcome.toInt()}",
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }
        }
    }

}


@Preview
@Composable
fun WalletPreview() {
    Wallet(balance = 2000000.0, points = 192, income = 192888.0, outcome = 48999.0)
}