package com.mario.stonechallenge.domain

import com.mario.stonechallenge.domain.model.ProductModel
import com.mario.stonechallenge.domain.model.UserModel

interface Repository {
    suspend fun login(user: String, password: String): Result<UserModel>
    suspend fun getProducts(): Result<List<ProductModel>>
}