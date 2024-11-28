package com.mario.stonechallenge.navigation

sealed class Screen(val route: String) {
    data object Login : Screen(route = "login")
    data object Products : Screen(route = "products")
}