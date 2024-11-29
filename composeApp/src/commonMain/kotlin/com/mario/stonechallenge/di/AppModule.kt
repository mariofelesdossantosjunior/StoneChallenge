package com.mario.stonechallenge.di

import com.mario.stonechallenge.data.di.dataModule
import com.mario.stonechallenge.domain.di.domainModule
import com.mario.stonechallenge.presentation.di.presentationModule
import org.koin.core.context.startKoin

val appModule = listOf(
    dataModule,
    domainModule,
    presentationModule
)

fun initializeKoin() {
    startKoin {
        modules(appModule)
    }
}