package com.mario.stonechallenge.data.di

import com.mario.stonechallenge.data.RepositoryImpl
import com.mario.stonechallenge.data.api.DummyAPI
import com.mario.stonechallenge.data.api.createHttpClient
import com.mario.stonechallenge.domain.Repository
import io.ktor.client.HttpClient
import org.koin.dsl.module

val dataModule = module {

    single<HttpClient> {
        createHttpClient()
    }

    single {
        DummyAPI(get())
    }

    single<Repository> {
        RepositoryImpl(get())
    }
}