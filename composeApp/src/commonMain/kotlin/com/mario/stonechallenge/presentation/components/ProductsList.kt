package com.mario.stonechallenge.presentation.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.mario.stonechallenge.domain.model.ProductModel

@Composable
fun ProductsList(products: List<ProductModel>) {
    LazyColumn {
        items(products) { product ->
            ProductCardItem(product = product)
        }
    }
}