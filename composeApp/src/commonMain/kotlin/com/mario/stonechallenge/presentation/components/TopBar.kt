package com.mario.stonechallenge.presentation.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.mario.stonechallenge.presentation.util.Colors

@Composable
fun TopBar(
    text: String,
    icon: ImageVector = Icons.AutoMirrored.Filled.ArrowBack,
    onClick: () -> Unit,
) {
    TopAppBar(
        backgroundColor = Colors.primaryColor,
        title = {
            Text(
                text = text,
                color = Color.White
            )
        },
        navigationIcon = {
            IconButton(onClick = onClick) {
                Icon(
                    imageVector = icon,
                    tint = Color.White,
                    contentDescription = "Icon"
                )
            }
        }
    )
}