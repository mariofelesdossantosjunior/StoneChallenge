package com.mario.stonechallenge.domain

import com.mario.stonechallenge.domain.model.ProductModel

class GetProductsUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(): Result<List<ProductModel>> {
        return repository.getProducts()
    }

}