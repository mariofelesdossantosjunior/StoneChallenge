package com.mario.stonechallenge.presentation

import com.mario.stonechallenge.domain.LoginUseCase
import com.mario.stonechallenge.domain.Repository
import com.mario.stonechallenge.domain.SaveBearerTokenUseCase
import com.mario.stonechallenge.domain.model.LoginModel
import com.mario.stonechallenge.presentation.login.LoginViewModel
import com.mario.stonechallenge.presentation.login.model.LoginEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.kodein.mock.Mock
import org.kodein.mock.generated.injectMocks
import org.kodein.mock.tests.TestsWithMocks
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
class LoginViewModelTest : TestsWithMocks() {

    private val testDispatcher = StandardTestDispatcher()

    override fun setUpMocks() = mocker.injectMocks(this)

    @Mock
    lateinit var repository: Repository

    private lateinit var loginUseCase: LoginUseCase
    private lateinit var saveBearerTokenUseCase: SaveBearerTokenUseCase
    private lateinit var viewModel: LoginViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @BeforeTest
    fun setUp() {
        loginUseCase = LoginUseCase(repository)
        saveBearerTokenUseCase = SaveBearerTokenUseCase(repository)

        viewModel = LoginViewModel(
            dispatcher = testDispatcher,
            loginUseCase = loginUseCase,
            saveBearerTokenUseCase = saveBearerTokenUseCase
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

    @Test
    fun on_event_should_invoke_login_when_success() = runTest {
        val fakeUserName = "admin"
        val fakePassword = "123"
        val fakeToken = "token"

        every {
            saveBearerTokenUseCase.invoke(
                SaveBearerTokenUseCase.Params(
                    bearerToken = fakeToken
                )
            )
        } returns Unit

        everySuspending {
            loginUseCase.invoke(
                LoginUseCase.Params(
                    userName = fakeUserName,
                    password = fakePassword
                )
            )
        } returns Result.success(
            value = LoginModel(token = "token")
        )

        viewModel.onEvent(
            LoginEvent.Login
        )

        runCurrent()

        assertTrue(viewModel.uiState.isLoggedIn)
    }

    @Test
    fun on_event_should_invoke_login_when_failure() = runTest {
        val fakeUserName = "admin"
        val fakePassword = "123"

        everySuspending {
            loginUseCase.invoke(
                LoginUseCase.Params(
                    userName = fakeUserName,
                    password = fakePassword
                )
            )
        } returns Result.failure(
            exception = Exception("Falha ao logar")
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
            saveBearerTokenUseCase.invoke(
                SaveBearerTokenUseCase.Params(
                    bearerToken = fakeToken
                )
            )
        } returns Unit

        viewModel.saveBearerToken(
            token = fakeToken
        )

        verify {
            saveBearerTokenUseCase.invoke(
                SaveBearerTokenUseCase.Params(
                    bearerToken = fakeToken
                )
            )
        }
    }
}