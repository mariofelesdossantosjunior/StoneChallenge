package com.mario.stonechallenge.domain.model

data class UserModel(
    val id: Int,
    val username: String,
    val accessToken: String,
    val refreshToken: String
)