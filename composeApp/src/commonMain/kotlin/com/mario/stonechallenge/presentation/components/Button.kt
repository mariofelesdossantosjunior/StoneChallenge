package com.mario.stonechallenge.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mario.stonechallenge.presentation.util.Colors

@Composable
fun Button(
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit

) {
    androidx.compose.material.Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().height(50.dp),
        shape = RoundedCornerShape(50.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Colors.primaryColor
        )
    ) {
        Text(
            text = text,
            color = Color.White
        )
    }
}