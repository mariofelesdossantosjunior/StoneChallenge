package com.mario.stonechallenge.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mario.stonechallenge.presentation.util.Colors

@Composable
fun ProgressIndicator() {
    CircularProgressIndicator(
        modifier = Modifier.padding(16.dp),
        color = Colors.primaryColor
    )
}