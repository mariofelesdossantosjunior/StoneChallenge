package com.mario.repository

import com.mario.repository.model.User
import java.util.UUID

class UserRepository {

    private val users = mutableListOf<User>()

    fun loadDefaultUser() {
        users.add(
            User(
                UUID.randomUUID(),
                username = "admin",
                password = "123"
            )
        )
    }

    fun findAll(): List<User> = users

    fun finByUserName(name: String): User? = users.firstOrNull { it.username == name }

    fun save(user: User) = users.add(user)
}