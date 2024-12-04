package com.mario.stonechallenge.fake

import com.mario.stonechallenge.domain.model.LoginModel

class FakeLoginModel {
    companion object {
        fun mock() = LoginModel(
            token = "token"
        )
    }
}