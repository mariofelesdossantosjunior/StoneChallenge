package com.mario.service

import com.mario.repository.ProductRepository
import com.mario.repository.model.Product

class ProductService(
    private val productRepository: ProductRepository
) {

    init {
        productRepository.loadProducts()
    }

    fun findAll(): List<Product> {
        return productRepository.findAll()
    }
}