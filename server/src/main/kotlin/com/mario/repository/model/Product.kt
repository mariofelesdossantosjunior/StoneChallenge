package com.mario.repository.model

import com.mario.routes.model.ProductResponse

data class Product(
    val id: Int?,
    val title: String?,
    val description: String?,
    val thumbnail: String?
) {
    fun toResponse() = ProductResponse(
        id = this.id,
        title = this.title,
        description = this.description,
        thumbnail = this.thumbnail
    )
}