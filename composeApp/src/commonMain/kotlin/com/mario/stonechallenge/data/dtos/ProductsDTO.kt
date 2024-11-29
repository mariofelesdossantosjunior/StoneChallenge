package com.mario.stonechallenge.data.dtos


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductsDTO(
    @SerialName("products")
    val products: List<ProductDTO>?
) {
    fun mapTo() = products?.map { it.mapTo() } ?: emptyList()
}

