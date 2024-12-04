package com.mario.stonechallenge.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mario.stonechallenge.domain.model.ProductModel
import com.mario.stonechallenge.presentation.util.Colors

@Composable
fun ProductCardItem(product: ProductModel) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProductImage(
                url = product.thumbnail
            )

            ProductDescription(
                product = product
            )
        }
    }
}