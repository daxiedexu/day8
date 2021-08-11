package com.zhang.register.model.api

import com.zhang.net.protocol.req.BaseRespEntity
import com.zhang.register.model.protocal.req.RegisterEntity
import com.zhang.register.model.protocal.resq.RegisterUserEntity
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterApi {
    @POST("api/User/register")
    fun register(@Body body:RegisterEntity):Deferred<BaseRespEntity<RegisterUserEntity>>
}