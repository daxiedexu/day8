package com.zhang.login.repository

import android.util.Log
import com.zhang.lib_core.mvp.annotation.Model
import com.zhang.login.contract.LoginContract
import com.zhang.login.model.LoginLocalModel
import com.zhang.login.model.LoginModel
import com.zhang.login.model.protocal.req.RegisterEntity
import com.zhang.login.model.protocal.resq.RegisterUserEntity
import com.zhang.net.protocol.req.BaseRespEntity
import io.reactivex.Observable
import kotlinx.coroutines.Deferred

class LoginRepository:LoginContract.LoginRepository() {
    private val TAG = "RegisterRepository"
    @Model
    private val remoteModel:LoginModel? = null
    @Model
    val  localModel:LoginLocalModel? = null
    override fun login(entitiy: RegisterEntity): Deferred<BaseRespEntity<RegisterUserEntity>> {
        Log.d(TAG,localModel.toString())
        return remoteModel!!.login(entitiy)
    }
}