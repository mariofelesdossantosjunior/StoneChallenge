package com.mario.stonechallenge.domain

import kotlinx.coroutines.test.runTest
import org.kodein.mock.Mock
import org.kodein.mock.generated.injectMocks
import org.kodein.mock.tests.TestsWithMocks
import kotlin.test.Test

class SaveBearerTokenUseCaseTest : TestsWithMocks() {

    override fun setUpMocks() = mocker.injectMocks(this)

    @Mock
    lateinit var repository: Repository

    private val useCase by withMocks {
        SaveBearerTokenUseCase(repository)
    }

    @Test
    fun should_invoke_repository() = runTest {
        every {
            repository.saveBearerToken(isAny())
        } returns Unit

        val params = SaveBearerTokenUseCase.Params(
            bearerToken = "token"
        )
        useCase.invoke(params)

        verifyWithSuspend {
            repository.saveBearerToken(isAny())
        }
    }
}