package com.puyo.kapas.feature_kapas.presentation.history.components

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.puyo.kapas.R
import com.puyo.kapas.feature_kapas.domain.model.job.Job
import com.puyo.kapas.ui.theme.DarkGreen
import com.puyo.kapas.ui.theme.LightGreen

@Composable
fun HistoryItem(
    job: Job,
) {

    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.White,
        elevation = 4.dp,
        modifier = Modifier
            .wrapContentSize()
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {

            // Title
            Text(
                text = job.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )

            // Title
            Text(
                text = job.description,
                fontSize = 12.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            // Bottom Section
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_verified),
                    contentDescription = "Verified",
                    Modifier.size(20.dp)
                )
                Text(
                    text = "Pekerjaan Terverifikasi",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(start = 4.dp)
                )

                Spacer(modifier = Modifier.width(110.dp))
                Button(
                    onClick = {
                    },
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier.size(height = 24.dp, width = 80.dp),
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = LightGreen)
                )
                {
                    Text(
                        text = "Selesai",
                        fontSize = 14.sp,
                        color = DarkGreen,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }
            }

        }
    }
}

@Preview
@Composable
fun HistoryItemPreview() {
    HistoryItem(
        job = Job(
            title = "Pembantu Penyetrika",
            posterId = "udauiwdiauwdbada",
            posterAvatarUrl = "wodaodadadw",
            posterName = "Tester",
            location = "Malang",
            wage = 23000.0,
            address = "Jalan Malang",
            description = "Mencari orang yang bisa menyetrika pakaian",
            image_url = "wdaawdadawda",
            latitude = 210.0,
            longitude = 120.0
        )
    )
}
