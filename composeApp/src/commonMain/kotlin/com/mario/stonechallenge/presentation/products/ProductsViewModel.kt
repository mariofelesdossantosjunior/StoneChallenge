package com.mario.stonechallenge.presentation.products

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mario.stonechallenge.domain.GetProductsUseCase
import com.mario.stonechallenge.presentation.products.model.ProductsUIState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProductsViewModel(
    private val dispatcher: CoroutineDispatcher,
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    var uiState by mutableStateOf(ProductsUIState())
        private set

    init {
        loadProducts()
    }

    private fun loadProducts() {
        uiState = uiState.copy(
            isLoading = true,
            isFailure = false
        )

        viewModelScope.launch(dispatcher) {

            delay(2000)

            getProductsUseCase.invoke()
                .onSuccess {
                    uiState = uiState.copy(
                        isLoading = false,
                        products = it
                    )
                }.onFailure {
                    uiState = uiState.copy(
                        isLoading = false,
                        isFailure = true
                    )
                }
        }
    }
}