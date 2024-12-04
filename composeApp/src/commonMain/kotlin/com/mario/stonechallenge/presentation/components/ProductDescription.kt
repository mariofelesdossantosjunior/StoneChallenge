package com.mario.stonechallenge.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mario.stonechallenge.domain.model.ProductModel

@Composable
fun ProductDescription(
    product: ProductModel
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = product.title,
            style = MaterialTheme.typography.h6
        )
        Text(
            text = product.description,
            style = MaterialTheme.typography.body2,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}