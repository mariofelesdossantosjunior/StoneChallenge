package com.mario.stonechallenge.domain.di

import com.mario.stonechallenge.domain.GetProductsUseCase
import com.mario.stonechallenge.domain.LoginUseCase
import com.mario.stonechallenge.domain.SaveBearerTokenUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        LoginUseCase(get())
    }

    factory {
        GetProductsUseCase(get())
    }

    factory {
        SaveBearerTokenUseCase(get())
    }

}