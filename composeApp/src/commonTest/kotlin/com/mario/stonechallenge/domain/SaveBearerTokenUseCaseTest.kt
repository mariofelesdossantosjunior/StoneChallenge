package com.mario.stonechallenge.domain

import dev.mokkery.answering.returns
import dev.mokkery.every
import dev.mokkery.matcher.any
import dev.mokkery.mock
import dev.mokkery.verify
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class SaveBearerTokenUseCaseTest {

    private val repository = mock<Repository>()
    private val useCase = SaveBearerTokenUseCase(repository)

    @Test
    fun should_invoke_repository() = runTest {
        every {
            repository.saveBearerToken(any())
        } returns Unit

        val params = SaveBearerTokenUseCase.Params(
            bearerToken = "token"
        )
        useCase.invoke(params)

        verify {
            repository.saveBearerToken(any())
        }
    }
}