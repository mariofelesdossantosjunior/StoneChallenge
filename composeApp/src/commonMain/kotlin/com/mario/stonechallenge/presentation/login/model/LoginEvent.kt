package com.mario.stonechallenge.presentation.login.model

sealed interface LoginEvent {
    data class UserNameChanged(val userName: String) : LoginEvent
    data class PasswordChanged(val password: String) : LoginEvent
    data object Login : LoginEvent
}