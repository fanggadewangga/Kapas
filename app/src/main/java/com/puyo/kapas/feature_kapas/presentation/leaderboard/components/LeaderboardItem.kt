package com.puyo.kapas.feature_kapas.presentation.leaderboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.puyo.kapas.R
import com.puyo.kapas.feature_kapas.data.source.remote.api.response.leaderboard.LeaderboardResponse
import com.puyo.kapas.feature_kapas.presentation.util.Screen
import com.puyo.kapas.ui.theme.Orange
import com.puyo.kapas.ui.theme.Peach
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun LeaderboardItem(
    user: LeaderboardResponse,
    navController: NavController,
) {
    Card(
        backgroundColor = if (user.uid.toInt() == 1) Peach else Color.White,
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(56.dp)
            .clickable {
                navController.navigate(Screen.RewardScreen.route)
            }
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {

            // Rank
            Text(
                text = user.rank.toString(),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = if (user.rank == 1) Orange else Color.Black,
                modifier = Modifier.padding(
                    start = 16.dp,
                    end =
                    if (user.rank >= 10) 8.dp
                    else 20.dp
                )
            )

            // Image
            Box(modifier = Modifier.size(32.dp)) {
                GlideImage(
                    imageModel = {
                        user.avatarUrl
                    },
                    modifier = Modifier.clip(CircleShape),
                    previewPlaceholder = R.drawable.img_avatar
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