package com.mario.stonechallenge.domain

import kotlinx.coroutines.test.runTest
import org.kodein.mock.Mock
import org.kodein.mock.generated.injectMocks
import org.kodein.mock.tests.TestsWithMocks
import kotlin.test.Test

class GetProductsUseCaseTest : TestsWithMocks() {

    override fun setUpMocks() = mocker.injectMocks(this)

    @Mock
    lateinit var repository: Repository

    private val useCase by withMocks {
        GetProductsUseCase(repository)
    }

    @Test
    fun should_invoke_repository() = runTest {
        everySuspending {
            repository.getProducts()
        } returns Result.success(
            emptyList()
        )

        useCase.invoke()

        verifyWithSuspend {
            repository.getProducts()
        }
    }
}