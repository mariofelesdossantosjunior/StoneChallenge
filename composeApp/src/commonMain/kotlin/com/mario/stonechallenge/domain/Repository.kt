package com.mario.stonechallenge.domain

import com.mario.stonechallenge.domain.model.ProductModel
import com.mario.stonechallenge.domain.model.LoginModel

interface Repository {
    suspend fun login(user: String, password: String): Result<LoginModel>
    suspend fun getProducts(): Result<List<ProductModel>>
}