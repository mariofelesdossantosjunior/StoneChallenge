package com.mario.repository

import com.mario.repository.model.Product

class ProductRepository {

    private val products = mutableListOf<Product>()

    fun loadProducts() {
        products.add(
            Product(
                1,
                title = "Essence Mascara Lash Princess",
                description = "The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects. Achieve dramatic lashes with this long-lasting and cruelty-free formula.",
                thumbnail = "https://cdn.dummyjson.com/products/images/beauty/Essence%20Mascara%20Lash%20Princess/thumbnail.png"
            )
        )
        products.add(
            Product(
                2,
                title = "Eyeshadow Palette with Mirror",
                description = "The Eyeshadow Palette with Mirror offers a versatile range of eyeshadow shades for creating stunning eye looks. With a built-in mirror, it's convenient for on-the-go makeup application.",
                thumbnail = "https://cdn.dummyjson.com/products/images/beauty/Eyeshadow%20Palette%20with%20Mirror/thumbnail.png"
            )
        )
        products.add(
            Product(
                3,
                title = "Powder Canister",
                description = "The Powder Canister is a finely milled setting powder designed to set makeup and control shine. With a lightweight and translucent formula, it provides a smooth and matte finish.",
                thumbnail = "https://cdn.dummyjson.com/products/images/beauty/Powder%20Canister/thumbnail.png"
            )
        )
        products.add(
            Product(
                4,
                title = "Red Lipstick",
                description = "The Red Lipstick is a classic and bold choice for adding a pop of color to your lips. With a creamy and pigmented formula, it provides a vibrant and long-lasting finish.",
                thumbnail = "https://cdn.dummyjson.com/products/images/beauty/Red%20Lipstick/thumbnail.png"
            )
        )
        products.add(
            Product(
                5,
                title = "Red Nail Polish",
                description = "The Red Nail Polish offers a rich and glossy red hue for vibrant and polished nails. With a quick-drying formula, it provides a salon-quality finish at home.",
                thumbnail = "https://cdn.dummyjson.com/products/images/beauty/Red%20Nail%20Polish/thumbnail.png"
            )
        )
        products.add(
            Product(
                6,
                title = "Calvin Klein CK One",
                description = "CK One by Calvin Klein is a classic unisex fragrance, known for its fresh and clean scent. It's a versatile fragrance suitable for everyday wear.",
                thumbnail = "https://cdn.dummyjson.com/products/images/fragrances/Calvin%20Klein%20CK%20One/thumbnail.png"
            )
        )
        products.add(
            Product(
                7,
                title = "Chanel Coco Noir Eau De",
                description = "Coco Noir by Chanel is an elegant and mysterious fragrance, featuring notes of grapefruit, rose, and sandalwood. Perfect for evening occasions.",
                thumbnail = "https://cdn.dummyjson.com/products/images/fragrances/Chanel%20Coco%20Noir%20Eau%20De/thumbnail.png"
            )
        )
        products.add(
            Product(
                8,
                title = "Dior J'adore",
                description = "J adore by Dior is a luxurious and floral fragrance, known for its blend of ylang-ylang, rose, and jasmine. It embodies femininity and sophistication.",
                thumbnail = "https://cdn.dummyjson.com/products/images/fragrances/Dior%20J'adore/thumbnail.png"
            )
        )
        products.add(
            Product(
                9,
                title = "Dolce Shine Eau de",
                description = "Dolce Shine by Dolce & Gabbana is a vibrant and fruity fragrance, featuring notes of mango, jasmine, and blonde woods. It's a joyful and youthful scent.",
                thumbnail = "https://cdn.dummyjson.com/products/images/fragrances/Dolce%20Shine%20Eau%20de/thumbnail.png"
            )
        )
        products.add(
            Product(
                10,
                title = "Gucci Bloom Eau de",
                description = "Gucci Bloom by Gucci is a floral and captivating fragrance, with notes of tuberose, jasmine, and Rangoon creeper. It's a modern and romantic scent.",
                thumbnail = "https://cdn.dummyjson.com/products/images/fragrances/Gucci%20Bloom%20Eau%20de/thumbnail.png"
            )
        )

    }

    fun findAll(): List<Product> = products
}