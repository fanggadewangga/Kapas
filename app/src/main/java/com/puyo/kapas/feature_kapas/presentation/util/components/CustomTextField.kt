package com.puyo.kapas.feature_kapas.presentation.util.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.puyo.kapas.ui.theme.Peach

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    placeHolder: String = "Placeholder",
    height: Dp = 48.dp,
    textStyle: TextStyle = TextStyle(fontSize = 12.sp),
    valueState: MutableState<String>,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardAction: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    shape: RoundedCornerShape = RoundedCornerShape(5.dp),
) {
    BasicTextField(
        value = valueState.value,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardAction,
        singleLine = singleLine,
        enabled = true,
        maxLines = maxLines,
        onValueChange = {
            valueState.value = it
            onValueChange(it)
        },
        decorationBox = { innerTextField ->
            Box(contentAlignment = Alignment.CenterEnd) {
                Box(
                    modifier = modifier
                        .clip(shape)
                        .background(color = Peach)
                        .border(width = 1.dp, color = Peach, shape = shape)
                        .height(height),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(contentAlignment = Alignment.CenterStart) {
                            if (valueState.value.isEmpty())
                                Text(
                                    text = placeHolder,
                                    style = textStyle,
                                    color = Color.Gray
                                )
                            innerTextField()
                        }

                    }
                }
            }
        })
}