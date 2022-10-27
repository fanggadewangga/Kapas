package com.puyo.kapas.feature_kapas.presentation.profile.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.puyo.kapas.R

@Composable
fun ShimmerProfileTopSection() {
    val colors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f),
    )

    val transition = rememberInfiniteTransition()
    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            )
        )
    )

    val brush = Brush.linearGradient(
        colors = colors,
        start = Offset.Zero,
        end = Offset(x = translateAnimation.value, y = translateAnimation.value)
    )

    Column(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(top = 72.dp)) {
            // Avatar, Username, Email, and Phone
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp)
            ) {
                // Avatar
                Spacer(modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(brush)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Spacer(modifier = Modifier
                        .height(24.dp)
                        .width(180.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(brush)
                    )

                    // Email
                    Spacer(modifier = Modifier.height(4.dp))
                    Spacer(modifier = Modifier
                        .height(24.dp)
                        .width(180.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(brush)
                    )

                    // Phone Number
                    Spacer(modifier = Modifier.height(4.dp))
                    Spacer(modifier = Modifier
                        .height(24.dp)
                        .width(180.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(brush)
                    )
                }
            }
        }

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
                        Spacer(modifier = Modifier
                            .height(16.dp)
                            .width(80.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(brush)
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
                        Spacer(modifier = Modifier
                            .height(16.dp)
                            .width(80.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(brush)
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
                        Spacer(modifier = Modifier
                            .height(16.dp)
                            .width(80.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(brush)
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
                        Spacer(modifier = Modifier
                            .height(16.dp)
                            .width(80.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(brush)
                        )
                    }
                }
            }
        }
    }
}