package com.mario.routes

import com.mario.routes.model.UserRequest
import com.mario.service.UserService
import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.post

fun Route.userRoute(
    userService: UserService
) {

    post {
        val user = call.receive<UserRequest>()

        userService.save(
            user.toModel()
        ) ?: return@post call.respond(HttpStatusCode.BadRequest)

        call.respond(
            HttpStatusCode.Created
        )
    }
}