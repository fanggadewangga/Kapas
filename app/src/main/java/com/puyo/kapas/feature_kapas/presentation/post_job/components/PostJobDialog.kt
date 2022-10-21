package com.puyo.kapas.feature_kapas.presentation.post_job.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.puyo.kapas.feature_kapas.presentation.util.Screen
import com.puyo.kapas.ui.theme.Orange

@Composable
fun PostJobDialog(navController: NavController) {
    val context = LocalContext.current
    val isDialogOpened = remember { mutableStateOf(true) }

    if (isDialogOpened.value) {
        AlertDialog(
            onDismissRequest = { isDialogOpened.value = false },
            title = {
                Text(
                    text = "Yakin untuk melamar pekerjaan?",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            text = {
                Text(
                    text = buildAnnotatedString {
                        append("Dengan melanjutkan, saya setuju dengan ")
                        withStyle(style = SpanStyle(
                            color = Orange,
                            fontWeight = FontWeight.Bold,
                        )) {
                            append("Syarat & Ketentuan ")
                        }
                        append("yang berlaku")
                    },
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            buttons = {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                    Spacer(modifier = Modifier.width(32.dp))
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        backgroundColor = Color.White,
                        border = BorderStroke(1.dp, Orange),
                        modifier = Modifier
                            .size(width = 100.dp, height = 32.dp)
                            .clickable {
                                isDialogOpened.value = false
                                navController.navigate(Screen.PostJobScreen.route)
                            }
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.height(40.dp)
                        ) {
                            Text(
                                text = "Batal",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = Orange,
                                modifier = Modifier.padding(top = 6.dp)
                            )
                        }
                    }
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        backgroundColor = Orange,
                        modifier = Modifier
                            .size(width = 100.dp, height = 32.dp)
                            .clickable {
                                isDialogOpened.value = false
                                navController.navigate(Screen.SuccessPostJobScreen.route)
                            }
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxHeight()
                        ) {
                            Text(
                                text = "Konfirmasi",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = Color.White,
                                modifier = Modifier.padding(top = 6.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(32.dp))
                }
            },
            backgroundColor = Color.White,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.size(width = 290.dp, height = 160.dp)
        )
    }
}

@Preview
@Composable
fun DialogPreview() {
    PostJobDialog(navController = rememberNavController())
}