package com.mario.stonechallenge.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.mario.stonechallenge.presentation.login.model.LoginEvent
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import stonechallenge.composeapp.generated.resources.Res
import stonechallenge.composeapp.generated.resources.login
import stonechallenge.composeapp.generated.resources.login_failure
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
            OutlinedTextField(
                value = viewModel.uiState.userName,
                onValueChange = {
                    viewModel.onEvent(
                        LoginEvent.UserNameChanged(it)
                    )
                },
                label = { Text(text = stringResource(Res.string.name)) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            defaultSpacer()

            OutlinedTextField(
                value = viewModel.uiState.password,
                onValueChange = {
                    viewModel.onEvent(
                        LoginEvent.PasswordChanged(it)
                    )
                },
                label = { Text(text = stringResource(Res.string.password)) },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            defaultSpacer()

            if (viewModel.uiState.isLoading) {
                ProgressIndicator()
            }

            Button(
                onClick = {
                    viewModel.onEvent(
                        LoginEvent.Login
                    )
                },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(50.dp),
                enabled = !viewModel.uiState.isLoading
            ) {
                Text(stringResource(Res.string.login))
            }
        }
    }
}

@Composable
fun ProgressIndicator() {
    CircularProgressIndicator(modifier = Modifier.padding(16.dp))
}

@Composable
private fun defaultSpacer() {
    Spacer(modifier = Modifier.height(16.dp))
}