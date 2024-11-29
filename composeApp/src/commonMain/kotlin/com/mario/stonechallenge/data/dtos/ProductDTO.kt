package com.mario.stonechallenge.data.dtos

import com.mario.stonechallenge.domain.model.ProductModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductDTO(
    @SerialName("id")
    val id: Int?,
    @SerialName("title")
    val title: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("thumbnail")
    val thumbnail: String?
) {
    fun mapTo() = ProductModel(
        id = this.id?.toLong() ?: 0,
        title = this.title ?: "",
        description = this.description ?: "",
        thumbnail = this.thumbnail ?: ""
    )
}