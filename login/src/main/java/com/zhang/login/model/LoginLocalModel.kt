package com.zhang.login.model

import com.zhang.login.contract.LoginContract
import com.zhang.login.model.api.LoginApi
import com.zhang.login.model.protocal.req.RegisterEntity
import com.zhang.login.model.protocal.resq.RegisterUserEntity
import com.zhang.net.RetrofitManger
import com.zhang.net.protocol.req.BaseRespEntity
import kotlinx.coroutines.Deferred

class LoginLocalModel : LoginContract.LoginModel {
    override fun login(entitiy: RegisterEntity): Deferred<BaseRespEntity<RegisterUserEntity>> {
        var service = RetrofitManger.retrofitManger.create(LoginApi::class.java)
        return service.login(entitiy)
    }
}