package com.mario.stonechallenge.domain

import dev.mokkery.answering.returns
import dev.mokkery.everySuspend
import dev.mokkery.mock
import dev.mokkery.verifySuspend
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class GetProductsUseCaseTest {

    private val repository = mock<Repository>()
    private val useCase = GetProductsUseCase(repository)

    @Test
    fun should_invoke_repository() = runTest {
        everySuspend {
            repository.getProducts()
        } returns Result.success(
            emptyList()
        )

        useCase.invoke()

        verifySuspend {
            repository.getProducts()
        }
    }
}