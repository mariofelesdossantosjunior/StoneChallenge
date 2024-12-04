package com.mario.stonechallenge.data.api

import com.mario.stonechallenge.data.dtos.AuthDTO
import com.mario.stonechallenge.data.dtos.LoginDTO
import com.mario.stonechallenge.data.dtos.ProductDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.HttpHeaders
import io.ktor.client.request.headers

const val BASE_URL = "http://192.168.122.1:8080/api"

class ServiceAPI(
    private val httpClient: HttpClient
) : API {

    private var token: String? = null

    override suspend fun login(
        userName: String,
        password: String
    ): Result<AuthDTO> {
        return try {
            val response: AuthDTO = httpClient.post(
                urlString = "$BASE_URL/login"
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

    override suspend fun getAllProducts(): Result<List<ProductDTO>> {
        val token = this.token ?: return Result.failure(Exception("Token not found"))
        return try {
            val response: List<ProductDTO> = httpClient.get(
                urlString = "$BASE_URL/product"
            ) {
                headers {
                    append(
                        HttpHeaders.Authorization, "Bearer $token"
                    )
                }
            }.body()
            Result.success(response)
        } catch (ex: Exception) {
            Result.failure(ex)
        }
    }

    override fun setBearerToken(token: String) {
        this.token = token
    }
}