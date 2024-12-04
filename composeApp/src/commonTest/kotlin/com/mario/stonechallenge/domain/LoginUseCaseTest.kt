package com.mario.stonechallenge.domain

import com.mario.stonechallenge.fake.FakeLoginModel
import dev.mokkery.answering.returns
import dev.mokkery.everySuspend
import dev.mokkery.matcher.any
import dev.mokkery.mock
import dev.mokkery.verifySuspend
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class LoginUseCaseTest {

    private val repository = mock<Repository>()
    private val useCase = LoginUseCase(repository)

    @Test
    fun should_invoke_repository() = runTest {
        everySuspend {
            repository.login(any(), any())
        } returns Result.success(
            FakeLoginModel.mock()
        )

        val params = LoginUseCase.Params(
            userName = "user",
            password = "password"
        )
        useCase.invoke(params)

        verifySuspend {
            repository.login(any(), any())
        }
    }
}