package com.mario.routes.model

import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    val id: Int?,
    val title: String?,
    val description: String?,
    val thumbnail: String?
)
