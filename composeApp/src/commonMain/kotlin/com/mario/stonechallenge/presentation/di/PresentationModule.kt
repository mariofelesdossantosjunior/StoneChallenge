package com.mario.stonechallenge.presentation.di

import com.mario.stonechallenge.presentation.login.LoginViewModel
import com.mario.stonechallenge.presentation.products.ProductsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        LoginViewModel(
            dispatcher = Dispatchers.IO,
            loginUseCase = get(),
            saveBearerTokenUseCase = get()
        )
    }

    viewModel {
        ProductsViewModel(
            dispatcher = Dispatchers.IO,
            getProductsUseCase = get()
        )
    }
}