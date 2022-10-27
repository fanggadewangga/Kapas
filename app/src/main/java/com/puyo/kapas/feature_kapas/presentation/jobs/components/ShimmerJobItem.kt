package com.puyo.kapas.feature_kapas.presentation.jobs.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedShimmer() {
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

    JobItemShimmer(brush = brush)
}

@Composable
fun JobItemShimmer(brush: Brush) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Spacer(modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(fraction = 0.9f)
            .clip(RoundedCornerShape(12.dp))
            .background(brush)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier
                .height(20.dp)
                .width(220.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(brush)
            )

            Spacer(modifier = Modifier
                .height(20.dp)
                .width(100.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(brush)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShimmerJobItemPreview() {
    JobItemShimmer(brush = Brush.linearGradient(listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f),
    )))
}