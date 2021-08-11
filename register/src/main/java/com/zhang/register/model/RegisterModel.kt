package com.zhang.register.model

import com.zhang.net.RetrofitManger
import com.zhang.net.protocol.req.BaseRespEntity
import com.zhang.register.contract.RegisterContract
import com.zhang.register.model.api.RegisterApi
import com.zhang.register.model.protocal.req.RegisterEntity
import com.zhang.register.model.protocal.resq.RegisterUserEntity
import io.reactivex.Observable
import kotlinx.coroutines.Deferred

class RegisterModel:RegisterContract.RegisterModel {
    override fun register(entitiy: RegisterEntity): Deferred<BaseRespEntity<RegisterUserEntity>> {
        var service  = RetrofitManger.retrofitManger.create(RegisterApi::class.java)
        return service.register(entitiy)
    }
}