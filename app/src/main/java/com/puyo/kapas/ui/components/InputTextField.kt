package com.puyo.kapas.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.puyo.kapas.ui.theme.Peach

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    valueState: MutableState<String>? = null,
    placeholder: String = "placeholder",
    fontSize: TextUnit = MaterialTheme.typography.button.fontSize,
) {
    var text by remember { mutableStateOf("") }
    BasicTextField(
        modifier = modifier
            .background(
                color = Peach,
                shape = RoundedCornerShape(8.dp)
            )
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
        ,
        value = text,
        onValueChange = {
            text = it
        },
        singleLine = true,
        cursorBrush = SolidColor(Color.Transparent),
        textStyle = LocalTextStyle.current.copy(
            color = MaterialTheme.colors.onSurface,
            fontSize = fontSize
        ),
        decorationBox = {
            innerTextField -> 
            Row(
                modifier.height(32.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (leadingIcon != null) leadingIcon()
                Spacer(modifier = Modifier.width(8.dp))
                Box(modifier = Modifier
                    .weight(1f)
                ) {
                    if (text.isEmpty())
                        Text(
                            text = placeholder,
                            style = TextStyle(
                                color = Color.Gray,
                                fontWeight = FontWeight.Normal,
                                fontSize = fontSize
                            )
                        )
                    innerTextField()
                }
                if (trailingIcon != null) trailingIcon()
            }
        }
    )
}

@Composable
fun CustomSearchField(
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    valueState: MutableState<String>? = null,
    placeholder: String = "placeholder",
    fontSize: TextUnit = MaterialTheme.typography.button.fontSize,
) {
    var text by remember { mutableStateOf("") }
    Card(shape = RoundedCornerShape(12.dp),
        backgroundColor = Color.White,
        elevation = 8.dp,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ) {
        BasicTextField(
            modifier = modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp)
                )
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp)
            ,
            value = text,
            onValueChange = {
                text = it
            },
            singleLine = true,
            cursorBrush = SolidColor(Color.Transparent),
            textStyle = LocalTextStyle.current.copy(
                color = MaterialTheme.colors.onSurface,
                fontSize = fontSize
            ),
            decorationBox = {
                    innerTextField ->
                Row(
                    modifier.height(35.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    if (leadingIcon != null) leadingIcon()
                    Spacer(modifier = Modifier.width(4.dp))
                    Box(modifier = Modifier
                        .weight(1f)
                    ) {
                        if (text.isEmpty())
                            Text(
                                text = placeholder,
                                style = TextStyle(
                                    color = Color.Gray,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = fontSize
                                )
                            )
                        innerTextField()
                    }
                    if (trailingIcon != null) trailingIcon()
                }
            }
        )
    }
}

@Composable
fun CustomPasswordField(
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    valueState: MutableState<String>? = null,
    placeholder: String = "placeholder",
    fontSize: TextUnit = MaterialTheme.typography.button.fontSize,
) {

    val focusManager = LocalFocusManager.current
    var isVisible by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("") }

    BasicTextField(
        modifier = modifier
            .background(
                color = Peach,
                shape = RoundedCornerShape(8.dp)
            )
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
        ,
        value = text,
        onValueChange = {
            text = it
        },
        singleLine = true,
        cursorBrush = SolidColor(Color.Transparent),
        textStyle = LocalTextStyle.current.copy(
            color = MaterialTheme.colors.onSurface,
            fontSize = fontSize
        ),
        decorationBox = {
                innerTextField ->
            Row(
                modifier.height(32.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (leadingIcon != null) leadingIcon()
                Spacer(modifier = Modifier.width(8.dp))
                Box(modifier = Modifier
                    .weight(1f)
                ) {
                    if (text.isEmpty())
                        Text(
                            text = placeholder,
                            style = TextStyle(
                                color = Color.Gray,
                                fontWeight = FontWeight.Normal,
                                fontSize = fontSize
                            )
                        )
                    innerTextField()
                }
                if (trailingIcon != null) trailingIcon()
            }
        },
        visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions.Default,
        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus(true) })
    )
}

@Composable
fun CommonInputField(
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    valueState: MutableState<String>? = null,
    placeholder: String = "placeholder",
    fontSize: TextUnit = MaterialTheme.typography.button.fontSize,
) {
    var text by remember { mutableStateOf("") }
    Card(shape = RoundedCornerShape(12.dp),
        backgroundColor = Peach,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ) {
        BasicTextField(
            modifier = modifier
                .background(
                    color = Peach,
                    shape = RoundedCornerShape(8.dp)
                )
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp)
            ,
            value = text,
            onValueChange = {
                text = it
            },
            singleLine = true,
            cursorBrush = SolidColor(Color.Transparent),
            textStyle = LocalTextStyle.current.copy(
                color = MaterialTheme.colors.onSurface,
                fontSize = fontSize,
                fontWeight = FontWeight.ExtraBold
            ),
            decorationBox = {
                    innerTextField ->
                Row(
                    modifier.height(35.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    if (leadingIcon != null) leadingIcon()
                    Spacer(modifier = Modifier.width(4.dp))
                    Box(modifier = Modifier
                        .weight(1f)
                    ) {
                        if (text.isEmpty())
                            Text(
                                text = placeholder,
                                style = TextStyle(
                                    color = Color.Gray,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = fontSize
                                )
                            )
                        innerTextField()
                    }
                    if (trailingIcon != null) trailingIcon()
                }
            }
        )
    }
}