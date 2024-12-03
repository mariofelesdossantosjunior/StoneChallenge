package com.mario.stonechallenge.presentation

import com.mario.stonechallenge.data.RepositoryImpl
import com.mario.stonechallenge.data.api.API
import com.mario.stonechallenge.data.api.ServiceAPI
import com.mario.stonechallenge.data.api.createHttpClient
import com.mario.stonechallenge.domain.LoginUseCase
import com.mario.stonechallenge.domain.Repository
import com.mario.stonechallenge.presentation.login.LoginViewModel
import com.mario.stonechallenge.presentation.login.model.LoginEvent
import io.ktor.client.HttpClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.get
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class LoginViewModelTest : KoinTest {

    private val dispatcher = StandardTestDispatcher()

    private lateinit var viewModel: LoginViewModel

    private val testModule = module {
        single<HttpClient> { createHttpClient() }
        single<API> { ServiceAPI(get()) }
        single<Repository> { RepositoryImpl(get()) }
        single { LoginUseCase(get()) }
        single { LoginViewModel(dispatcher, get()) }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @BeforeTest
    fun setUp() {
        startKoin {
            modules(testModule)
        }

        viewModel = get()

        Dispatchers.setMain(dispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun on_event_should_invoke_charge_user_name() {
        val fakeUserName = "user"

        viewModel.onEvent(
            LoginEvent.UserNameChanged(fakeUserName)
        )

        assertEquals(fakeUserName, viewModel.uiState.userName)
    }
}