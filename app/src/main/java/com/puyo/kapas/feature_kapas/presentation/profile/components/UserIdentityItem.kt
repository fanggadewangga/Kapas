package com.puyo.kapas.feature_kapas.presentation.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.puyo.kapas.ui.theme.Peach

@Composable
fun UserIdentityItem(
    title: String,
    description: String,
    value: String,
) {
    Column(modifier = Modifier.fillMaxWidth()) {

        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
                .background(shape = RoundedCornerShape(8.dp), color = Peach)
                .padding(start = 8.dp)
        ) {
            Text(
                text = value,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = description,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Gray,
            modifier = Modifier.padding(start = 8.dp)
        )
        Spacer(modifier = Modifier.height(18.dp))
    }
}

@Preview
@Composable
fun UserIdentityPreview() {
    UserIdentityItem(title = "Nomor E-KTP",
        description = "Masukkan nomor E-KTP Anda",
        value = "31242421412")
}