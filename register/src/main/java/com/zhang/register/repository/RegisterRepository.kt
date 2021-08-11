package com.zhang.register.repository

import android.util.Log
import com.zhang.lib_core.mvp.annotation.Model
import com.zhang.net.protocol.req.BaseRespEntity
import com.zhang.register.contract.RegisterContract
import com.zhang.register.model.RegisterLocalModel
import com.zhang.register.model.RegisterModel
import com.zhang.register.model.protocal.req.RegisterEntity
import com.zhang.register.model.protocal.resq.RegisterUserEntity
import kotlinx.coroutines.Deferred

class RegisterRepository:RegisterContract.RegisRepository() {
    private val TAG = "RegisterRepository"
    @Model
    private val remoteModel:RegisterModel? = null
    @Model
    private val  localModel:RegisterLocalModel? = null
    override fun register(entitiy: RegisterEntity): Deferred<BaseRespEntity<RegisterUserEntity>> {
        Log.d(TAG,localModel.toString())
        return remoteModel!!.register(entitiy)
    }
}