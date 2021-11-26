package com.billyluisneedham.mutliplemoduledetektprototype.commonui

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ButtonBase(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
fun ButtonBasePreview() {
    ButtonBase(
        text = "Press Me",
        onClick = {}
    )
}