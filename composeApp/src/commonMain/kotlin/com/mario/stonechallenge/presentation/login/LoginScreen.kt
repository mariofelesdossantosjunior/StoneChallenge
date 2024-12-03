package com.mario.stonechallenge.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.mario.stonechallenge.presentation.components.Button
import com.mario.stonechallenge.presentation.components.ProgressIndicator
import com.mario.stonechallenge.presentation.components.TextField
import com.mario.stonechallenge.presentation.components.defaultSpacer
import com.mario.stonechallenge.presentation.login.model.LoginEvent
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import stonechallenge.composeapp.generated.resources.Res
import stonechallenge.composeapp.generated.resources.login
import stonechallenge.composeapp.generated.resources.login_failure
import stonechallenge.composeapp.generated.resources.logo
import stonechallenge.composeapp.generated.resources.name
import stonechallenge.composeapp.generated.resources.password

@OptIn(KoinExperimentalAPI::class)
@Composable
fun LoginScreen(
    navigateToProducts: () -> Unit
) {
    val viewModel = koinViewModel<LoginViewModel>()
    val snackBarHostState = remember { SnackbarHostState() }

    LaunchedEffect(viewModel.uiState.isLoggedIn) {
        if (viewModel.uiState.isLoggedIn) {
            navigateToProducts()
        }
    }

    val messageFailure = stringResource(Res.string.login_failure)
    LaunchedEffect(viewModel.uiState.isFailure) {
        if (viewModel.uiState.isFailure) {
            snackBarHostState.showSnackbar(
                message = messageFailure
            )
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(Res.drawable.logo),
                contentDescription = "logo"
            )

            TextField(
                label = stringResource(Res.string.name),
                value = viewModel.uiState.userName,
                onValueChange = {
                    viewModel.onEvent(
                        LoginEvent.UserNameChanged(it)
                    )
                }
            )

            defaultSpacer()

            TextField(
                label = stringResource(Res.string.password),
                value = viewModel.uiState.password,
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = {
                    viewModel.onEvent(
                        LoginEvent.PasswordChanged(it)
                    )
                }
            )

            defaultSpacer()

            if (viewModel.uiState.isLoading) {
                ProgressIndicator()
            }

            Button(
                text = stringResource(Res.string.login),
                enabled = !viewModel.uiState.isLoading,
                onClick = {
                    viewModel.onEvent(
                        LoginEvent.Login
                    )
                }
            )
        }
    }
}

