package com.mario.routes

import com.mario.repository.model.Product
import com.mario.service.ProductService
import io.ktor.http.HttpStatusCode
import io.ktor.server.auth.authenticate
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.productRoute(
    productService: ProductService
) {

    authenticate {
        get {
            val products = productService.findAll()

            call.respond(
                status = HttpStatusCode.OK,
                message = products.map(Product::toResponse)
            )
        }
    }
}