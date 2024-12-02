package com.mario.service

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.mario.routes.model.LoginRequest
import com.mario.utils.Constants
import io.ktor.server.auth.jwt.JWTCredential
import io.ktor.server.auth.jwt.JWTPrincipal
import java.util.Date


class JWTService(
    private val userService: UserService
) {

    val realm = Constants.myRealm
    val secret = Constants.secret
    val audience = Constants.audience
    val issuer = Constants.issuer

    val jwtVerifier: JWTVerifier = JWT
        .require(Algorithm.HMAC256(secret))
        .withAudience(audience)
        .withIssuer(issuer)
        .build()

    fun generateToken(loginRequest: LoginRequest): String? {
        val user = userService.findByUserName(loginRequest.username)

        return if (user != null && user.password == loginRequest.password) {
            JWT
                .create()
                .withAudience(audience)
                .withIssuer(issuer)
                .withClaim("username", loginRequest.username)
                .withExpiresAt(Date(System.currentTimeMillis() + 3_600_000))
                .sign(Algorithm.HMAC256(Constants.secret))
        } else null
    }

    fun customValidation(credential: JWTCredential): JWTPrincipal? {
        val username = extractUsername(credential)
        val foundUser = username?.let(userService::findByUserName)
        return foundUser?.let {
            if (audienceMatches(credential)) {
                JWTPrincipal(credential.payload)
            } else null
        }
    }

    private fun audienceMatches(credential: JWTCredential): Boolean {
        return credential.payload.audience.contains(audience)
    }

    private fun extractUsername(credential: JWTCredential): String? {
        return credential.payload.getClaim("username").asString()
    }
}