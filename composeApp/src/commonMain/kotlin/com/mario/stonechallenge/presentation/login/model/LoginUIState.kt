package com.mario.stonechallenge.presentation.login.model

data class LoginUIState(
    val isLoading: Boolean = false,
    val isLoggedIn: Boolean = false,
    val isFailure: Boolean = false,
    val userName: String = "admin",
    val password: String = "123"
)