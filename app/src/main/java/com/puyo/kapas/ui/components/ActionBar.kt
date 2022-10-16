package com.puyo.kapas.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import com.puyo.kapas.ui.theme.Orange

@Composable
fun ActionBar(text: String) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = Orange)
        .padding(top = 64.dp, bottom = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = "Arrow",
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(24.dp)
            )

            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 48.dp)
            )
        }
    }
}

@Preview
@Composable
fun ActionBarPrev() {
    ActionBar(text = "Pasang Lowongan Pekerjaan")
}