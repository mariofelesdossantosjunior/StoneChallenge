package com.mario.stonechallenge.data.api

import com.mario.stonechallenge.data.dtos.LoginDTO
import com.mario.stonechallenge.data.dtos.ProductsDTO
import com.mario.stonechallenge.data.dtos.UserDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody

const val BASE_URL = "https://dummyjson.com"

class DummyAPI(
    private val httpClient: HttpClient
) {

    suspend fun login(
        userName: String,
        password: String
    ): Result<UserDTO> {
        return try {
            val response: UserDTO = httpClient.post(
                urlString = "$BASE_URL/auth/login"
            ) {
                setBody(
                    LoginDTO(
                        userName = userName,
                        password = password
                    )
                )
            }.body()
            Result.success(response)
        } catch (ex: Exception) {
            Result.failure(ex)
        }
    }

    suspend fun getAllProducts(): Result<ProductsDTO> {
        return try {
            val response: ProductsDTO = httpClient.get(
                urlString = "$BASE_URL/products"
            ).body()
            Result.success(response)
        } catch (ex: Exception) {
            Result.failure(ex)
        }
    }
}