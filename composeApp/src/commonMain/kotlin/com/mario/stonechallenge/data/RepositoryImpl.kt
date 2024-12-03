package com.mario.stonechallenge.data

import com.mario.stonechallenge.data.api.API
import com.mario.stonechallenge.domain.Repository
import com.mario.stonechallenge.domain.model.LoginModel
import com.mario.stonechallenge.domain.model.ProductModel

class RepositoryImpl(
    private val api: API
) : Repository {

    override suspend fun login(
        user: String,
        password: String
    ): Result<LoginModel> {
        return api.login(
            userName = user,
            password = password
        ).mapCatching {
            it.mapTo()
        }
    }

    override suspend fun getProducts(): Result<List<ProductModel>> {
        return api.getAllProducts()
            .mapCatching { products ->
                products.map {
                    it.mapTo()
                }
            }
    }

    override fun saveBearerToken(token: String) {
        api.setBearerToken(token)
    }
}