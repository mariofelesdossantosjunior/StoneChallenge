package com.mario.stonechallenge.data

import com.mario.stonechallenge.data.api.API
import com.mario.stonechallenge.fake.FakeAuthDTO
import dev.mokkery.answering.returns
import dev.mokkery.everySuspend
import dev.mokkery.matcher.any
import dev.mokkery.mock
import dev.mokkery.verify
import dev.mokkery.verifySuspend
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class RepositoryImplTest {

    @Test
    fun should_login_with_api_service() = runTest {
        val apiService = mock<API> {
            everySuspend {
                login(any(), any())
            } returns Result.success(
                FakeAuthDTO.mock()
            )
        }

        val repository = RepositoryImpl(apiService)

        repository.login(
            user = "user",
            password = "password"
        )

        verifySuspend {
            apiService.login(any(), any())
        }
    }

    @Test
    fun should_products_with_api_service() = runTest {
        val apiService = mock<API> {
            everySuspend {
                getAllProducts()
            } returns Result.success(
                emptyList()
            )
        }

        val repository = RepositoryImpl(apiService)

        repository.getProducts()

        verifySuspend {
            apiService.getAllProducts()
        }
    }

    @Test
    fun should_save_bearer_token_with_api_service() = runTest {
        val apiService = mock<API> {
            everySuspend {
                setBearerToken(any())
            } returns Unit
        }

        val repository = RepositoryImpl(apiService)

        repository.saveBearerToken("token")

        verify {
            apiService.setBearerToken(any())
        }
    }
}