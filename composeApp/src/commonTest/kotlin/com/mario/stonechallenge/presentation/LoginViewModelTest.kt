package com.mario.stonechallenge.presentation

import com.mario.stonechallenge.domain.LoginUseCase
import com.mario.stonechallenge.domain.Repository
import com.mario.stonechallenge.domain.SaveBearerTokenUseCase
import com.mario.stonechallenge.fake.FakeLoginModel
import com.mario.stonechallenge.presentation.login.LoginViewModel
import com.mario.stonechallenge.presentation.login.model.LoginEvent
import dev.mokkery.answering.returns
import dev.mokkery.every
import dev.mokkery.everySuspend
import dev.mokkery.matcher.any
import dev.mokkery.mock
import dev.mokkery.verify
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
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class LoginViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private val repository = mock<Repository>()
    private lateinit var viewModel: LoginViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @BeforeTest
    fun setUp() {

        viewModel = LoginViewModel(
            dispatcher = testDispatcher,
            loginUseCase = LoginUseCase(
                repository = repository
            ),
            saveBearerTokenUseCase = SaveBearerTokenUseCase(
                repository = repository
            )
        )

        Dispatchers.setMain(testDispatcher)
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

    @Test
    fun on_event_should_invoke_charge_password() {
        val fakePassword = "password"

        viewModel.onEvent(
            LoginEvent.PasswordChanged(fakePassword)
        )

        assertEquals(fakePassword, viewModel.uiState.password)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun on_event_should_invoke_login_when_success() = runTest {
        every {
            repository.saveBearerToken(any())
        } returns Unit

        everySuspend {
            repository.login(any(), any())
        } returns Result.success(
            FakeLoginModel.mock()
        )

        viewModel = LoginViewModel(
            dispatcher = testDispatcher,
            loginUseCase = LoginUseCase(
                repository = repository
            ),
            saveBearerTokenUseCase = SaveBearerTokenUseCase(
                repository = repository
            )
        )

        viewModel.onEvent(
            LoginEvent.Login
        )

        runCurrent()

        assertTrue(viewModel.uiState.isLoggedIn)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun on_event_should_invoke_login_when_failure() = runTest {
        everySuspend {
            repository.login(any(), any())
        } returns Result.failure(
            exception = Exception("Failure")
        )

        viewModel = LoginViewModel(
            dispatcher = testDispatcher,
            loginUseCase = LoginUseCase(
                repository = repository
            ),
            saveBearerTokenUseCase = SaveBearerTokenUseCase(
                repository = repository
            )
        )

        viewModel.onEvent(
            LoginEvent.Login
        )

        runCurrent()

        assertFalse(viewModel.uiState.isLoggedIn)
        assertTrue(viewModel.uiState.isFailure)
    }

    @Test
    fun on_event_should_invoke_save_bearer_token() = runTest {
        val fakeToken = "token"

        every {
            repository.saveBearerToken(any())
        } returns Unit

        viewModel.saveBearerToken(
            token = fakeToken
        )

        verify {
            repository.saveBearerToken(any())
        }
    }
}