package com.mario.stonechallenge.di

import com.mario.stonechallenge.data.RepositoryImpl
import com.mario.stonechallenge.domain.Repository
import com.mario.stonechallenge.screen.login.LoginViewModel
import com.mario.stonechallenge.screen.products.ProductsViewModel
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {
    single<Repository> {
        RepositoryImpl()
    }

    viewModel {
        LoginViewModel(get())
    }

    viewModel {
        ProductsViewModel(get())
    }
}

fun initializeKoin() {
    startKoin {
        modules(appModule)
    }
}