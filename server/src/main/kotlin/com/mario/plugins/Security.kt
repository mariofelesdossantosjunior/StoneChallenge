package com.mario.plugins

import com.mario.service.JWTService
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.auth.Authentication
import io.ktor.server.auth.jwt.jwt

fun Application.configureSecurity(
    jwtService: JWTService
) {

    install(Authentication) {
        jwt {
            realm = jwtService.realm
            verifier(jwtService.jwtVerifier)
            validate { credential ->
                jwtService.customValidation(credential)
            }
        }
    }
}
