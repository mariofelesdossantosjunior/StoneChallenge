package com.mario.stonechallenge.data

import com.mario.stonechallenge.data.api.DummyAPI
import com.mario.stonechallenge.domain.Repository
import com.mario.stonechallenge.domain.model.ProductModel
import com.mario.stonechallenge.domain.model.UserModel

class RepositoryImpl(
    private val api: DummyAPI
) : Repository {

    override suspend fun login(
        user: String,
        password: String
    ): Result<UserModel> {
        return api.login(
            userName = user,
            password = password
        ).mapCatching {
            it.mapTo()
        }
    }

    override suspend fun getProducts(): Result<List<ProductModel>> {
        return api.getAllProducts()
            .mapCatching {
                it.mapTo()
            }
    }
}