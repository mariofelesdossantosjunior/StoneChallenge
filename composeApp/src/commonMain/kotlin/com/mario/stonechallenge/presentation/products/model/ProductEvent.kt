package com.mario.stonechallenge.presentation.products.model

sealed interface ProductEvent {
    data object GoBackToLogin : ProductEvent
}