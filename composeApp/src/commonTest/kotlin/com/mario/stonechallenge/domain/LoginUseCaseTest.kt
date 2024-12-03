package com.mario.stonechallenge.domain

import com.mario.stonechallenge.domain.model.LoginModel
import kotlinx.coroutines.test.runTest
import org.kodein.mock.Mock
import org.kodein.mock.generated.injectMocks
import org.kodein.mock.tests.TestsWithMocks
import kotlin.test.Test

class LoginUseCaseTest : TestsWithMocks() {

    override fun setUpMocks() = mocker.injectMocks(this)

    @Mock
    lateinit var repository: Repository

    private val useCase by withMocks {
        LoginUseCase(repository)
    }

    @Test
    fun should_invoke_repository() = runTest {
        everySuspending {
            repository.login(isAny(), isAny())
        } returns Result.success(
            LoginModel(token = "token")
        )

        val params = LoginUseCase.Params(userName = "user", password = "password")
        useCase.invoke(params)

        verifyWithSuspend {
            repository.login(isAny(), isAny())
        }
    }
}