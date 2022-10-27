package com.puyo.kapas.feature_kapas.presentation.profile.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.puyo.kapas.R

@Composable
fun ShimmerRank() {
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

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
        ) {

            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 8.dp)) {

                // Skor
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_score),
                        contentDescription = "Wallet",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "Skor",
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )

                    // Value
                    Spacer(modifier = Modifier.height(4.dp))
                    Spacer(modifier = Modifier
                        .height(16.dp)
                        .width(56.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(brush)
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.ic_line),
                    contentDescription = "Line",
                    modifier = Modifier.size(height = 80.dp, width = 1.dp)
                )

                // Rank
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_rank),
                        contentDescription = "Rank",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "Peringkat",
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )

                    // Value
                    Spacer(modifier = Modifier.height(4.dp))
                    Spacer(modifier = Modifier
                        .height(16.dp)
                        .width(72.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(brush)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ShimmerRankPreview() {
    ShimmerRank()
}