package com.puyo.kapas.feature_kapas.presentation.job.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.puyo.kapas.ui.theme.Grey
import com.puyo.kapas.ui.theme.Orange

@Composable
fun JobBottomBar(
    wage: Double
) {
    Card(
        elevation = 4.dp,
        modifier = Modifier.fillMaxWidth()
    ) {

        Row(horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .background(color = Color.White, shape = RectangleShape)
                .padding(16.dp)
        ) {
            Column {
                Text(
                    text = "Jumlah Bayaran",
                    color = Grey,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "$wage Rupiah",
                    color = Orange,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )
            }

            Button(
                onClick = { /*TODO*/ },
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(4.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Orange),
                modifier = Modifier.size(height = 36.dp, width = 120.dp)
            ) {
                Text(
                    text = "Melamar",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun JobBottomBarPrev() {
    JobBottomBar(wage = 2000.0)
}