package com.mario.stonechallenge.domain

import com.mario.stonechallenge.domain.model.UserModel

class LoginUseCase(
    private val repository: Repository
) {

    class Params(val userName: String, val password: String)

    suspend operator fun invoke(
        params: Params
    ): Result<UserModel> {
        return repository.login(
            user = params.userName,
            password = params.password
        )
    }
}