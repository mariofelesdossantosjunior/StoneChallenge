package com.mario.stonechallenge.fake

import com.mario.stonechallenge.domain.model.ProductModel

class FakeProductModel {
    companion object {
        fun mock() = ProductModel(
            id = 1,
            title = "title",
            description = "description",
            thumbnail = "tumbnail"
        )
    }
}