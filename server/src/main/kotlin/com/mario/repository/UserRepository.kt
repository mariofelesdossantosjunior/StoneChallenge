package com.mario.repository

import com.mario.repository.model.User

class UserRepository {

    private val users = mutableListOf<User>()

    fun findAll(): List<User> = users

    fun finByUserName(name: String): User? = users.firstOrNull { it.username == name }

    fun save(user: User) = users.add(user)
}