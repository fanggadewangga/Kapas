package com.puyo.kapas.feature_kapas.presentation.job.add_job

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.puyo.kapas.R
import com.puyo.kapas.feature_kapas.presentation.util.Screen
import com.puyo.kapas.ui.components.CommonInputField
import com.puyo.kapas.ui.theme.Grey
import com.puyo.kapas.ui.theme.Orange

@Composable
fun AddJobScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {

        // Action Bar
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(color = Orange)
            .padding(top = 64.dp, bottom = 8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "Arrow",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(24.dp)
                        .clickable { navController.navigate(Screen.HomeScreen.route) }
                )

                Text(
                    text = "Pasang Lowongan Pekerjaan",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(start = 48.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        
        Text(
            text = "Pasang lowongan pekerjaan Anda di sini!",
            fontSize = 12.sp,
            color = Grey,
            modifier = Modifier.padding(start = 16.dp)
        )

        // Job's Name
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            fontWeight = FontWeight.Medium,
            text = "Nama Pekerjaan",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
        )
        CommonInputField(
            placeholder = "Pembantu Penyetrika"
        )
        Text(
            text = "Tulis nama pekerjaan yang akan Anda pasang",
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(start = 32.dp, bottom = 8.dp)
        )

        // Location
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            fontWeight = FontWeight.Medium,
            text = "Lokasi Pekerjaan",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
        )
        CommonInputField(
            placeholder = "Jl. Veteran No.8, Ketawanggede, Kec. Lowokwaru, Kota Malang, Jawa Timur 65145"
        )
        Text(
            text = "Tulis lokasi pekerjaan yang sesuai",
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(start = 32.dp, bottom = 8.dp)
        )

        // Tempat Pekerjaan
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            fontWeight = FontWeight.Medium,
            text = "Tempat Pekerjaan",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
        )
        CommonInputField(
            placeholder = "Rumah Pribadi"
        )
        Text(
            text = "Tulis tempat pekerjaan yang sesuai ",
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(start = 32.dp, bottom = 8.dp)
        )

        // Jumlah Bayaran
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            fontWeight = FontWeight.Medium,
            text = "Jumlah Bayaran",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
        )
        CommonInputField(
            placeholder = "200.000"
        )
        Text(
            text = "Tulis bayaran yang Anda tawarkan dalam rupiah ",
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(start = 32.dp, bottom = 8.dp)
        )

        // Deskripsi
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            fontWeight = FontWeight.Medium,
            text = "Deskripsi Pekerjaan",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
        )
        CommonInputField(
            placeholder = "Lorem Ipsum"
        )
        Text(
            text = "Tulis deskripsi pekerjaan secara detail",
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(start = 32.dp, bottom = 8.dp)
        )

        // Confirm
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                navController.navigate(Screen.JobPaymentScreen.route)
            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(Orange),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Konfirmasi",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun AddJobPrev() {
    AddJobScreen(rememberNavController())
}