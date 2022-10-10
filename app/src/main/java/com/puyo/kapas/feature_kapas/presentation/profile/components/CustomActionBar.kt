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
import androidx.compose.ui.text.style.TextAlign
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
    Row(
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
        .fillMaxWidth()
        .background(color = Orange)
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_arrow_back),
            contentDescription = "Arrow",
            modifier = Modifier
                .padding(bottom = 8.dp, start = 16.dp)
                .size(24.dp)
                .clickable {  onClick }
        )

        Column {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 64.dp, bottom = 8.dp, end = 16.dp)
            )
        }
    }
}

@Preview
@Composable
fun CustomActionBarPrev() {
    CustomActionBar(title = "Edit Profile", onClick = {})
}