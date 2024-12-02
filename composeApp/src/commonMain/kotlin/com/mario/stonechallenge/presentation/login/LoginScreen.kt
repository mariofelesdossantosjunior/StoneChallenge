package com.mario.stonechallenge.presentation.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mario.stonechallenge.presentation.login.model.LoginEvent
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun LoginScreen(
    navigateToProducts: () -> Unit
) {
    val viewModel = koinViewModel<LoginViewModel>()

    LaunchedEffect(viewModel.uiState.isLoggedIn) {
        if (viewModel.uiState.isLoggedIn) {
            navigateToProducts()
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                viewModel.onEvent(
                    event = LoginEvent.Login
                )
            }
        ) {
            Text(text = "Login")
        }
    }
}