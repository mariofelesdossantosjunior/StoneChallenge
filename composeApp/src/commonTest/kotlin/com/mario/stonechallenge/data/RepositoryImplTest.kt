package com.mario.stonechallenge.data

import com.mario.stonechallenge.data.api.API
import com.mario.stonechallenge.data.dtos.AuthDTO
import kotlinx.coroutines.test.runTest
import org.kodein.mock.Mock
import org.kodein.mock.generated.injectMocks
import org.kodein.mock.tests.TestsWithMocks
import kotlin.test.Test

class RepositoryImplTest : TestsWithMocks() {

    override fun setUpMocks() = mocker.injectMocks(this)

    @Mock
    lateinit var apiService: API

    private val repository by withMocks {
        RepositoryImpl(apiService)
    }

    @Test
    fun should_login_with_api_service() = runTest {
        everySuspending {
            apiService.login(isAny(), isAny())
        } returns Result.success(
            AuthDTO(
                token = "token"
            )
        )

        repository.login(
            user = "user",
            password = "password"
        )

        verifyWithSuspend {
            apiService.login(isAny(), isAny())
        }
    }

    @Test
    fun should_products_with_api_service() = runTest {
        everySuspending {
            apiService.getAllProducts()
        } returns Result.success(
           emptyList()
        )

        repository.getProducts()

        verifyWithSuspend {
            apiService.getAllProducts()
        }
    }
}