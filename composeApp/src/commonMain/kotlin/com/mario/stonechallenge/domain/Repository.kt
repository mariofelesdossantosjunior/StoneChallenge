package com.mario.stonechallenge.domain

import com.mario.stonechallenge.domain.model.Product

interface Repository {
    fun login(user: String, password: String): Boolean
    fun getProducts(): List<Product>
}