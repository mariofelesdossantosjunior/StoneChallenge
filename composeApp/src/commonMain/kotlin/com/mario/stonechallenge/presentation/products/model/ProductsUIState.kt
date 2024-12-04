package com.mario.stonechallenge.presentation.products.model

import com.mario.stonechallenge.domain.model.ProductModel

data class ProductsUIState(
    val isLoading: Boolean = false,
    val products: List<ProductModel> = emptyList(),
    val isFailure: Boolean = false
)