package com.mario.routes

import com.mario.routes.model.LoginRequest
import com.mario.service.JWTService
import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.post

fun Route.authRoute(jwtService: JWTService) {

    post {
        val loginRequest = call.receive<LoginRequest>()
        val token = jwtService.generateToken(loginRequest)

        token?.let {
            call.respond(hashMapOf("token" to it))
        } ?: call.respond(HttpStatusCode.Unauthorized)
    }
}
