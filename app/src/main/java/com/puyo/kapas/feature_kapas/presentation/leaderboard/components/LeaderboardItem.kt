package com.puyo.kapas.feature_kapas.presentation.leaderboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.puyo.kapas.R
import com.puyo.kapas.feature_kapas.domain.model.leaderboard.Leaderboard
import com.puyo.kapas.ui.theme.Orange
import com.puyo.kapas.ui.theme.Peach

@Composable
fun LeaderboardItem(
    user: Leaderboard,
) {
    Card(
        backgroundColor = if (user.uid.toInt() == 1) Peach else Color.White,
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(56.dp)) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {

            // Rank
            Text(
                text = user.uid,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = if (user.uid.toInt() == 1) Orange else Color.Black,
                modifier = Modifier.padding(
                    start = 16.dp,
                    end =
                    if (user.uid.toInt() >= 10) 8.dp
                    else 20.dp
                )
            )

            // Image
            Box(modifier = Modifier.size(32.dp)) {
                AsyncImage(
                    placeholder = painterResource(id = R.drawable.img_avatar),
                    error = painterResource(id = R.drawable.img_avatar),
                    model = user.avatarUrl,
                    contentDescription = "User Avatar",
                    modifier = Modifier.size(32.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_verified),
                    contentDescription = "Verified icon",
                    modifier = Modifier
                        .size(12.dp)
                        .align(Alignment.BottomEnd)
                )


            }

            // Name
            user.name?.let {
                Text(
                    text = it,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .width(160.dp)
                        .padding(start = 24.dp)
                )
            }

            // Score
            Text(
                text = user.score.toString(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(64.dp)
                    .padding(start = 8.dp)
                    .background(color = Orange, shape = RoundedCornerShape(4.dp))
            )

            // Arrow Icon
            Spacer(modifier = Modifier.width(24.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_arrow),
                contentDescription = "Arrow",
                modifier = Modifier.size(24.dp)
            )

        }
    }

}

@Preview
@Composable
fun LeaderboardItemPreview() {
    LeaderboardItem(
        user = Leaderboard(
            uid = "1",
            name = "Faiq Arya Dewangga",
            avatarUrl = "avatarURL",
            score = 200
        )
    )
}