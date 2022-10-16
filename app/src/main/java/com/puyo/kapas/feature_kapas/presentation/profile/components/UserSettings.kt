package com.puyo.kapas.feature_kapas.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.puyo.kapas.R
import com.puyo.kapas.ui.theme.Peach

@Composable
fun UserSetting(navController: NavController) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Peach
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {

            // Change Email
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                    /*TODO*/
                }
            ) {
                Text(
                    text = "Ubah email",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_next),
                    contentDescription = "Arrow",
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(height = 18.dp, width = 10.dp)
                )
            }
            Divider(modifier = Modifier.fillMaxWidth().padding(top = 8.dp))

            // Change Phone Number
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clickable {
                        /*TODO*/
                    }
            ) {
                Text(
                    text = "Ubah nomor telepon",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_next),
                    contentDescription = "Arrow",
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(height = 18.dp, width = 10.dp)
                )
            }
            Divider(modifier = Modifier.fillMaxWidth().padding(top = 8.dp))

            // Change password
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clickable {
                        /*TODO*/
                    }
            ) {
                Text(
                    text = "Ubah kata sandi",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_next),
                    contentDescription = "Arrow",
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(height = 18.dp, width = 10.dp)
                )
            }
            Divider(modifier = Modifier.fillMaxWidth().padding(top = 8.dp))

            // Reconfirmation KTP
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clickable {
                        /*TODO*/
                    }
            ) {
                Text(
                    text = "Konfirmasi ulang KTP",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_next),
                    contentDescription = "Arrow",
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(height = 18.dp, width = 10.dp)
                )
            }
            Spacer(modifier = Modifier.height(4.dp))

        }
    }
}