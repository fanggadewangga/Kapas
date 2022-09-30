package com.puyo.kapas.feature_kapas.presentation.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.puyo.kapas.R
import com.puyo.kapas.feature_kapas.presentation.auth.component.CustomCheckBox
import com.puyo.kapas.feature_kapas.presentation.util.Screen
import com.puyo.kapas.ui.theme.Orange
import com.puyo.kapas.ui.theme.Peach

@Composable
fun SignupScreen(navController: NavController) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setSystemBarsColor(color = Orange)
    }

    Column(
        horizontalAlignment = CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Orange)
    ) {

        Spacer(modifier = Modifier.height(48.dp))
        Image(
            painter = painterResource(id = R.drawable.logo_kapas),
            contentDescription = "Kapas Logo",
            modifier = Modifier
                .size(160.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .fillMaxSize()
                .align(CenterHorizontally)
        ) {
            Image(painter = painterResource(id = R.drawable.cloud),
                contentDescription = "Cloud",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 170.dp)
                    .align(Alignment.BottomCenter)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(horizontal = 24.dp)
            ) {
                SignupSection(navController)
            }
        }
    }
}

@Composable
fun SignupSection(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(color = Color.White)
            .padding(24.dp)
    ) {
        Text(
            text = "Daftar",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
        )
        Text(
            text = "Silahkan daftar terlebih dahulu!",
            fontWeight = FontWeight.Light,
            fontSize = 12.sp,
            color = Color.Gray
        )

        // Email
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Peach,
                    shape = RoundedCornerShape(16.dp)
                ),
            value = "",
            onValueChange = {
            },
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.email),
                    contentDescription = "Email",
                    modifier = Modifier.size(16.dp))
            },
            placeholder = {
                Text(
                    text = "Email",
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray,
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Peach,
                focusedBorderColor = Peach
            )
        )

        // Password
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Peach, shape = RoundedCornerShape(16.dp)),
            value = "",
            onValueChange = {

            },
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.password),
                    contentDescription = "Email",
                    modifier = Modifier.size(16.dp))
            },
            placeholder = {
                Text(
                    text = "Password",
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Peach,
                focusedBorderColor = Peach
            )
        )

        // Password Confirmation
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Peach, shape = RoundedCornerShape(16.dp))
            ,
            value = "",
            onValueChange = {

            },
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.password),
                    contentDescription = "Email",
                    modifier = Modifier.size(16.dp))
            },
            placeholder = {
                Text(
                    text = "Konfirmasi Password",
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Peach,
                focusedBorderColor = Peach
            )
        )

        // Terms and Condition
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomCheckBox()
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = buildAnnotatedString {
                    append("Saya setuju dengan semua")
                    withStyle(style = SpanStyle(
                        color = Orange,
                        fontWeight = FontWeight.Bold
                    )
                    ) {
                        append(" Syarat & Ketentuan")
                    }
                    append(" dan")
                    withStyle(style = SpanStyle(
                        color = Orange,
                        fontWeight = FontWeight.Bold
                    )
                    ) {
                        append(" Kebijakan Privasi")
                    }
                },
                fontSize = 12.sp
            )
        }

        // Or
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally)
        ) {
            Image(
                painter = painterResource(id = R.drawable.line),
                contentDescription = "Line",
                modifier = Modifier.size(width = 120.dp, height = 16.dp)
            )
            Text(
                text = " ATAU ",
                color = Color.Gray
            )
            Image(
                painter = painterResource(id = R.drawable.line),
                contentDescription = "Line",
                modifier = Modifier.size(width = 120.dp, height = 16.dp)
            )
        }

        // Button
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            
        },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Peach),
            modifier = Modifier
                .align(CenterHorizontally)
        ) {
            Image(painter = painterResource(id = R.drawable.ic_google),
                contentDescription = "Google Icon",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Daftar dengan Google",
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
        }

        Button(
            onClick = {

            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Orange),
            modifier = Modifier
                .align(CenterHorizontally)
        ) {
            Text(
                text = "Daftar",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(horizontal = 72.dp)
                    .clickable { navController.navigate(Screen.LoginScreen.route) }
            )
        }

        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = buildAnnotatedString {
                append("Sudah memiliki akun? ")
                withStyle(style = SpanStyle(
                    color = Orange,
                    fontWeight = FontWeight.Bold
                )
                ) {
                    append("Silahkan masuk")
                }
            },
            fontSize = 12.sp,
            modifier = Modifier
                .clickable {
                    navController.navigate(Screen.LoginScreen.route)
                }
                .align(CenterHorizontally)
        )

    }
}

@Preview
@Composable
fun Prev() {
    SignupScreen(navController = rememberNavController())
}