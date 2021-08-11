package com.zhang.login.model.api

import com.zhang.login.model.protocal.req.RegisterEntity
import com.zhang.login.model.protocal.resq.RegisterUserEntity
import com.zhang.net.protocol.req.BaseRespEntity
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST("api/User/login")
    fun login(@Body body: RegisterEntity): Deferred<BaseRespEntity<RegisterUserEntity>>
}