package com.mario.stonechallenge

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform