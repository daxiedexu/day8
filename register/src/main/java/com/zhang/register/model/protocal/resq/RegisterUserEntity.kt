package com.zhang.register.model.protocal.resq

data class RegisterUserEntity (
    val birthday: String,
    val id: Int,
    val pwd: String,
    val sex: String,
    val username: String
)