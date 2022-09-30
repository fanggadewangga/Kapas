package com.puyo.kapas.feature_kapas.presentation.auth.component

import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.puyo.kapas.ui.theme.Orange

@Composable
fun CustomCheckBox() {
    val checkedState = remember { mutableStateOf(false) }
    Checkbox(
        checked = checkedState.value,
        onCheckedChange = {checkedState.value = it},
        colors = CheckboxDefaults.colors(
            checkmarkColor = Color.White,
            checkedColor = Orange
        )
    )
}