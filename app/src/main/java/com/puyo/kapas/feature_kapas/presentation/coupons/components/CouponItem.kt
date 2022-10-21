package com.puyo.kapas.feature_kapas.presentation.coupons.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.puyo.kapas.R
import com.puyo.kapas.ui.theme.Orange

@Composable
fun CouponItem() {
    var isClicked = mutableStateOf(false)
    Box(modifier = Modifier.size(height = 135.dp, width = 320.dp)) {
        Image(
            painter = painterResource(id = R.drawable.img_coupon),
            contentDescription = "Coupon",
            modifier = Modifier.size(height = 135.dp, width = 320.dp)
        )
        Box(modifier = Modifier
            .padding(bottom = 8.dp, end = 16.dp)
            .align(Alignment.BottomEnd)
        ) {
            Button(
                onClick = {
                    isClicked.value = true
                },
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(4.dp),
                colors =
                if (isClicked.value)
                    ButtonDefaults.buttonColors(backgroundColor = Color.Gray)
                else
                    ButtonDefaults.buttonColors(backgroundColor = Orange),
                modifier = Modifier.size(height = 24.dp, width = 64.dp),
            ) {
                Text(
                    text =
                    if (isClicked.value)
                        "Diklaim"
                    else "Klaim",
                    fontSize = 12.sp,
                    color = Color.White,
                )
            }
        }

    }
}

@Preview
@Composable
fun CouponItemPreview() {
    CouponItem()
}