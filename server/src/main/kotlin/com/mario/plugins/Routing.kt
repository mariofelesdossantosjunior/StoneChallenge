package com.mario.plugins

import com.mario.routes.authRoute
import com.mario.routes.productRoute
import com.mario.routes.userRoute
import com.mario.service.JWTService
import com.mario.service.ProductService
import com.mario.service.UserService
import io.ktor.server.application.Application
import io.ktor.server.routing.route
import io.ktor.server.routing.routing

fun Application.configureRouting(
    jwtService: JWTService,
    userService: UserService,
    productService: ProductService
) {
    routing {

        route("/api/user") {
            userRoute(userService)
        }

        route("/api/auth") {
            authRoute(jwtService)
        }

        route("/api/product") {
            productRoute(productService)
        }
    }
}

