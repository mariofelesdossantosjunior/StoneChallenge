package com.mario.routes.model

import com.mario.repository.model.User
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class UserRequest(
    val username: String,
    val password: String
) {
    fun toModel() = User(
        id = UUID.randomUUID(),
        username = username,
        password = password
    )
}
