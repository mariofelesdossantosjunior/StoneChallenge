package com.mario

import com.mario.plugins.configureRouting
import com.mario.plugins.configureSecurity
import com.mario.plugins.configureSerialization
import com.mario.repository.ProductRepository
import com.mario.repository.UserRepository
import com.mario.service.JWTService
import com.mario.service.ProductService
import com.mario.service.UserService
import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    embeddedServer(
        Netty,
        port = 8080,
        host = "0.0.0.0",
        module = Application::module
    ).start(wait = true)
}

fun Application.module() {
    val userRepository = UserRepository()
    val productRepository = ProductRepository()
    val userService = UserService(userRepository)
    val productService = ProductService(productRepository)
    val jwtService = JWTService(userService)

    configureSerialization()
    configureSecurity(jwtService)
    configureRouting(
        jwtService = jwtService,
        userService = userService,
        productService = productService
    )
}


