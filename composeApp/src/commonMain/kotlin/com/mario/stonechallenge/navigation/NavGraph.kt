package com.mario.stonechallenge.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mario.stonechallenge.screen.login.LoginScreen
import com.mario.stonechallenge.screen.products.ProductsScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String = Screen.Login.route
) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screen.Login.route) {
            LoginScreen(
                navigateToProducts = {
                    navController.navigate(
                        route = Screen.Products.route
                    )
                }
            )
        }
        composable(route = Screen.Products.route) {
            ProductsScreen(
                goBackToLogin = {
                    navController.navigate(
                        route = Screen.Login.route
                    )
                }
            )
        }
    }
}