package com.mario.stonechallenge.data.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginDTO(
    @SerialName("username")
    val userName: String,
    @SerialName("password")
    val password: String
)