package com.zhang.login.model.protocal.req

data class RegisterEntity (
    val birthday: String,
    val id: Int,
    val pwd: String,
    val sex: String,
    val username: String
)