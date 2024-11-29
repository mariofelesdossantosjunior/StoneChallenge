package com.mario.stonechallenge.data.dtos


import com.mario.stonechallenge.domain.model.UserModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDTO(
    @SerialName("id")
    val id: Int?,
    @SerialName("username")
    val username: String?,
    @SerialName("accessToken")
    val accessToken: String?,
    @SerialName("refreshToken")
    val refreshToken: String?
) {
    fun mapTo() = UserModel(
        id = this.id ?: 0,
        username = this.username ?: "",
        accessToken = this.accessToken ?: "",
        refreshToken = this.refreshToken ?: ""
    )
}