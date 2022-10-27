package com.puyo.kapas.feature_kapas.presentation.job_applier.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.puyo.kapas.R
import com.puyo.kapas.feature_kapas.domain.model.user.User
import com.puyo.kapas.ui.theme.Orange
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun JobApplierItem(user: User) {
    Card(elevation = 8.dp,
        modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White, shape = RoundedCornerShape(8.dp))
        .padding(vertical = 8.dp)
    ) {
        Column {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                // Avatar
                Box {
                    GlideImage(
                        imageModel = {
                            user.avatarUrl
                        },
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(64.dp),
                        imageOptions = ImageOptions(contentScale = ContentScale.Crop,
                            contentDescription = "Avatar"),
                        previewPlaceholder = R.drawable.img_avatar
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_verified),
                        contentDescription = "Verified",
                        modifier = Modifier
                            .size(18.dp)
                            .align(Alignment.BottomEnd)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    user.name?.let {
                        Text(
                            text = it,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }


                    // Email
                    Spacer(modifier = Modifier.height(4.dp))
                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_email),
                            contentDescription = "Email",
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = user.email,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }

                    // Phone Number
                    Spacer(modifier = Modifier.height(4.dp))
                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_phone),
                            contentDescription = "Phone",
                            modifier = Modifier.size(16.dp)
                        )
                        user.phone?.let {
                            Text(
                                text = it,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.width(180.dp))
                Card(
                    shape = RoundedCornerShape(4.dp),
                    backgroundColor = Color.White,
                    border = BorderStroke(1.dp, Orange),
                    modifier = Modifier
                        .size(width = 72.dp, height = 24.dp)
                        .clickable {

                        }
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.height(32.dp)
                    ) {
                        Text(
                            text = "Tolak",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Orange,
                            modifier = Modifier.padding(top = 2.dp)
                        )
                    }
                }

                Card(
                    shape = RoundedCornerShape(4.dp),
                    backgroundColor = Orange,
                    modifier = Modifier
                        .size(width = 72.dp, height = 24.dp)
                        .clickable {

                        }
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Text(
                            text = "Terima",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = Color.White,
                            modifier = Modifier.padding(top = 2.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(4.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

    }
}

@Preview
@Composable
fun JobApplierItemPreview() {
    JobApplierItem(user = User(
        "1",
        "1",
        "user",
        "malang",
        "malang",
        "1 jan ",
        "user@gmail.com",
        "081",
        "url",
        "p",
        0.0,
        0.0,
        0.0,
        0,
        1,
        1
    )
    )
}