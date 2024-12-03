package com.mario.stonechallenge.domain

class SaveBearerTokenUseCase(
    private val repository: Repository
) {

    class Params(val bearerToken: String)

    operator fun invoke(params: Params) {
        repository.saveBearerToken(params.bearerToken)
    }

}