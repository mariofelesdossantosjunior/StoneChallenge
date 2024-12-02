package com.mario.service

import com.mario.repository.UserRepository
import com.mario.repository.model.User

class UserService(
    private val userRepository: UserRepository
) {

    fun findAll(): List<User> {
        return userRepository.findAll()
    }

    fun findByUserName(name: String): User? {
        return userRepository.finByUserName(name)
    }

    fun save(user: User): User? {
        val userExists = findByUserName(user.username)
        return if (userExists == null) {
            userRepository.save(user)
            user
        } else {
            null
        }
    }
}