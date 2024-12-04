package com.mario.stonechallenge.presentation.products

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
import androidx.compose.ui.unit.dp
import com.mario.stonechallenge.presentation.components.ProductsList
import com.mario.stonechallenge.presentation.components.ProgressIndicator
import com.mario.stonechallenge.presentation.components.TopBar
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import stonechallenge.composeapp.generated.resources.Res
import stonechallenge.composeapp.generated.resources.message_failure
import stonechallenge.composeapp.generated.resources.products

@OptIn(KoinExperimentalAPI::class)
@Composable
fun ProductsScreen(
    goBackToLogin: () -> Unit
) {
    val viewModel = koinViewModel<ProductsViewModel>()
    val snackBarHostState = remember { SnackbarHostState() }

    val messageFailure = stringResource(Res.string.message_failure)
    LaunchedEffect(viewModel.uiState.isFailure) {
        if (viewModel.uiState.isFailure) {
            snackBarHostState.showSnackbar(
                message = messageFailure
            )
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                text = stringResource(Res.string.products),
                onClick = goBackToLogin
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (viewModel.uiState.isLoading) {
                ProgressIndicator()
            }

            ProductsList(
                products = viewModel.uiState.products
            )
        }
    }
}

