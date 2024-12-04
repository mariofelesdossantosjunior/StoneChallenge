package com.mario.stonechallenge.presentation

import com.mario.stonechallenge.domain.GetProductsUseCase
import com.mario.stonechallenge.domain.Repository
import com.mario.stonechallenge.fake.FakeProductModel
import com.mario.stonechallenge.presentation.products.ProductsViewModel
import dev.mokkery.answering.returns
import dev.mokkery.everySuspend
import dev.mokkery.mock
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

class ProductViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @BeforeTest
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun on_load_products_when_success() = runTest {
        val repository = mock<Repository> {
            everySuspend {
                getProducts()
            } returns Result.success(
                listOf(FakeProductModel.mock())
            )
        }

        val viewModel = ProductsViewModel(
            dispatcher = testDispatcher,
            getProductsUseCase = GetProductsUseCase(
                repository = repository
            )
        )

        viewModel.loadProducts()

        runCurrent()

        assertTrue(viewModel.uiState.products.isNotEmpty())
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun on_load_products_when_failure() = runTest {
        val repository = mock<Repository> {
            everySuspend {
                getProducts()
            } returns Result.failure(Exception("Failure"))
        }

        val viewModel = ProductsViewModel(
            dispatcher = testDispatcher,
            getProductsUseCase = GetProductsUseCase(
                repository = repository
            )
        )

        viewModel.loadProducts()

        runCurrent()

        assertTrue(viewModel.uiState.products.isEmpty())
        assertTrue(viewModel.uiState.isFailure)
    }
}