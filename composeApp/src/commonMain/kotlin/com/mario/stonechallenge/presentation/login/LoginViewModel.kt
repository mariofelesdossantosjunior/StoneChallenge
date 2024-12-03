package com.mario.stonechallenge.presentation.login

import androidx.annotation.VisibleForTesting
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mario.stonechallenge.domain.LoginUseCase
import com.mario.stonechallenge.presentation.login.model.LoginEvent
import com.mario.stonechallenge.presentation.login.model.LoginUIState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel(
    private val dispatcher: CoroutineDispatcher,
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    var uiState by mutableStateOf(LoginUIState())
        private set

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.UserNameChanged -> {
                changeUserName(event.userName)
            }

            is LoginEvent.PasswordChanged -> {
                changePassword(event.password)
            }

            LoginEvent.Login -> {
                login()
            }
        }
    }

    @VisibleForTesting
    fun changeUserName(userName: String) {
        uiState = uiState.copy(
            userName = userName
        )
    }

    @VisibleForTesting
    fun changePassword(password: String) {
        uiState = uiState.copy(
            password = password
        )
    }

    fun login() {
        uiState = uiState.copy(
            isLoading = true,
            isFailure = false
        )

        viewModelScope.launch(dispatcher) {
            val params = LoginUseCase.Params(
                userName = uiState.userName,
                password = uiState.password
            )

            loginUseCase.invoke(params)
                .onSuccess {
                    uiState = uiState.copy(
                        isLoading = false,
                        isLoggedIn = true
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