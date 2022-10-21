package com.puyo.kapas.feature_kapas.presentation.verification.identity_verification

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.puyo.kapas.R
import com.puyo.kapas.feature_kapas.presentation.verification.components.VerificationDialog
import com.puyo.kapas.ui.components.CustomTextField
import com.puyo.kapas.ui.components.TopBar
import com.puyo.kapas.ui.theme.Orange
import org.koin.androidx.compose.getViewModel

@Composable
fun IdentityVerificationScreen(
    navController: NavController
) {
    val viewModel = getViewModel<IdentityVerificationViewModel>()

    val dialogState = remember {
        mutableStateOf(false)
    }

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(Orange)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        Row {
            TopBar(text = "Verifikasi Identitas Anda")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.img_card_verification),
                contentDescription = "card",
                modifier = Modifier.size(48.dp)
            )

            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(
                    text = "E-KTP",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 16.sp
                )
                Text(
                    text = "Pastikan data Anda sudah benar.",
                    color = Color.Gray,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp
                )
            }
        }

        Column(modifier = Modifier.padding(horizontal = 24.dp)) {

            // Nomor E-KTP
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Nomor E-KTP",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray
            )
            CustomTextField(
                placeholder = "",
                fontSize = 12.sp,
                valueState = viewModel.cardNumber
            )
            Text(
                text = "Masukkan nomor E-KTP Anda",
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Light
            )

            // Nama Lengkap
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = "Nama Lengkap",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray
            )
            CustomTextField(
                placeholder = "",
                fontSize = 12.sp,
                valueState = viewModel.name
            )
            Text(
                text = "Masukkan nama lengkap sesuai E-KTP Anda",
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Light
            )

            // Tempat Lahir
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = "Tempat Lahir",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray
            )
            CustomTextField(
                placeholder = "",
                fontSize = 12.sp,
                valueState = viewModel.birthPlace
            )
            Text(
                text = "Masukkan tempat lahir sesuai E-KTP Anda",
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Light
            )

            // Tanggal Lahir
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = "Tanggal Lahir",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray
            )
            CustomTextField(
                placeholder = "",
                fontSize = 12.sp,
                valueState = viewModel.birthDate
            )
            Text(
                text = "Masukkan tanggal lahir sesuai E-KTP Anda",
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Light
            )

            // Gender
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = "Jenis Kelamin",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = viewModel.selectedGender.value == "Pria",
                    onClick = { viewModel.selectedGender.value = "Pria" },
                    colors = RadioButtonDefaults.colors(Orange)
                )
                Text(
                    text = "Pria",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.width(24.dp))
                RadioButton(
                    selected = viewModel.selectedGender.value == "Wanita",
                    onClick = { viewModel.selectedGender.value = "Wanita" },
                    colors = RadioButtonDefaults.colors(Orange)
                )
                Text(
                    text = "Wanita",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }


            // Terms
            Spacer(modifier = Modifier.height(24.dp))
            Image(
                painter = painterResource(id = R.drawable.img_verification_terms),
                contentDescription = "Terms",
                modifier = Modifier.fillMaxWidth()
            )

            // Button
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    dialogState.value = true
                },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Orange),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Konfirmasi",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            // Dialog
            if (dialogState.value)
                VerificationDialog(navController = navController)
        }
    }
}

@Preview
@Composable
fun Preview() {
    IdentityVerificationScreen(navController = rememberNavController())
}