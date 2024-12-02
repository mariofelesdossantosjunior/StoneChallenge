package com.mario.repository

import com.mario.repository.model.Product

class ProductRepository {

    private val products = mutableListOf<Product>()

    fun loadProducts() {
        products.add(Product(1, "Product 1", "Description 1", "https://picsum.photos/200"))
        products.add(Product(2, "Product 2", "Description 2", "https://picsum.photos/200"))
        products.add(Product(3, "Product 3", "Description 3", "https://picsum.photos/200"))
        products.add(Product(4, "Product 4", "Description 4", "https://picsum.photos/200"))
        products.add(Product(5, "Product 5", "Description 5", "https://picsum.photos/200"))
        products.add(Product(6, "Product 6", "Description 6", "https://picsum.photos/200"))
        products.add(Product(7, "Product 7", "Description 7", "https://picsum.photos/200"))
    }

    fun findAll(): List<Product> = products
}