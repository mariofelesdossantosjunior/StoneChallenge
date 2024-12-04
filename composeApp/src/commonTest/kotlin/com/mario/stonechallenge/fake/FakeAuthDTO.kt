package com.mario.stonechallenge.fake

import com.mario.stonechallenge.data.dtos.AuthDTO

class FakeAuthDTO {
    companion object {
        fun mock() = AuthDTO(
            token = "token"
        )
    }
}