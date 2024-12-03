package com.mario.stonechallenge.data.dtos


import com.mario.stonechallenge.domain.model.LoginModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthDTO(
    @SerialName("token")
    val token: String?
) {
    fun mapTo() = LoginModel(
        token = this.token
    )
}