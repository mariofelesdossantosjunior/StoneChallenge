package com.mario.stonechallenge.presentation.products

import androidx.lifecycle.ViewModel
import com.mario.stonechallenge.domain.GetProductsUseCase
import kotlinx.coroutines.CoroutineDispatcher

class ProductsViewModel(
    private val dispatcher: CoroutineDispatcher,
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {
}