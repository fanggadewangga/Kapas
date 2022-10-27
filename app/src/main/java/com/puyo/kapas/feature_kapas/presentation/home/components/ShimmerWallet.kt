package com.puyo.kapas.feature_kapas.presentation.home.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.puyo.kapas.R
import com.puyo.kapas.ui.theme.Orange

@Composable
fun ShimmerWallet() {
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

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Orange, shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {

        // Balance and Point Section
        Row(
            modifier = Modifier
                .wrapContentSize()
                .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                .padding(start = 16.dp, top = 8.dp, end = 48.dp, bottom = 8.dp)
        ) {

            // Saldo
            Column(
                modifier = Modifier.wrapContentSize()
            ) {

                // Saldo
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_wallet),
                        contentDescription = "Wallet",
                        tint = Orange,
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
                Spacer(modifier = Modifier.height(8.dp))
                Spacer(modifier = Modifier
                    .height(16.dp)
                    .width(56.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(brush)
                )
            }

            // Line
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = R.drawable.img_vertical_line),
                contentDescription = "Vertical Line",
                modifier = Modifier.size(height = 40.dp, width = 2.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))

            // Point
            Column(
                modifier = Modifier.wrapContentSize()
            ) {

                // Point
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_point),
                        contentDescription = "Point",
                        tint = Orange,
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

                Spacer(modifier = Modifier.height(8.dp))
                Spacer(modifier = Modifier
                    .height(16.dp)
                    .width(56.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(brush)
                )
            }
        }

        Spacer(modifier = Modifier.width(32.dp))

        // Top Up
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(end = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_topup),
                contentDescription = "Top up",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Top Up",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShimmerWalletPreview() {
    ShimmerWallet()
}
