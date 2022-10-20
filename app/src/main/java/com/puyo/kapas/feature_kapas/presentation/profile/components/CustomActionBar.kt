package com.puyo.kapas.feature_kapas.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
fun CustomActionBar(
    title: String,
    onClick: () -> Unit
) {
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
                    .clickable { onClick }
            )

            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.width(24.dp))
        }
    }
}

@Preview
@Composable
fun CustomActionBarPrev() {
    CustomActionBar(title = "Edit Profile", onClick = {})
}