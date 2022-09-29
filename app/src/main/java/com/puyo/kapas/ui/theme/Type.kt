package com.puyo.kapas.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.puyo.kapas.R

private val poppins = FontFamily(
    Font(R.font.poppins_extralight),
    Font(R.font.poppins_light),
    Font(R.font.poppins_medium),
    Font(R.font.poppins_semibold),
    Font(R.font.poppins_bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = poppins,
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
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