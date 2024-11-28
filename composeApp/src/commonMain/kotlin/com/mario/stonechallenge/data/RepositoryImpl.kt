package com.mario.stonechallenge.data

import com.mario.stonechallenge.domain.Repository
import com.mario.stonechallenge.domain.model.Product

class RepositoryImpl : Repository {

    override fun login(
        user: String,
        password: String
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun getProducts(): List<Product> {
        TODO("Not yet implemented")
    }
}