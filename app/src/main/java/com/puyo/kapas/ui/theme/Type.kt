package com.puyo.kapas.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.puyo.kapas.R

private val roboto = FontFamily(
    Font(R.font.opensans_light),
    Font(R.font.opensans_regular),
    Font(R.font.opensans_medium),
    Font(R.font.opensans_semibold),
    Font(R.font.opensans_bold),
    Font(R.font.opensans_extrabold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = roboto,
    body1 = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h1 = TextStyle(
        fontFamily = roboto,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)