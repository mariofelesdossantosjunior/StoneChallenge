package com.mario.stonechallenge.data.api

import com.mario.stonechallenge.data.dtos.AuthDTO
import com.mario.stonechallenge.data.dtos.ProductDTO

interface API {

    suspend fun login(userName: String, password: String): Result<AuthDTO>

    suspend fun getAllProducts(): Result<List<ProductDTO>>
}