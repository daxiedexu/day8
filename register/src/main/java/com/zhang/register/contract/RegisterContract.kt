package com.zhang.register.contract

import com.zhang.lib_core.mvp.model.BaseRepository
import com.zhang.lib_core.mvp.model.IModel
import com.zhang.lib_core.mvp.presenter.BasePresenter
import com.zhang.lib_core.mvp.view.IView
import com.zhang.net.protocol.req.BaseRespEntity
import com.zhang.register.model.protocal.req.RegisterEntity
import com.zhang.register.model.protocal.resq.RegisterUserEntity
import io.reactivex.Observable
import kotlinx.coroutines.Deferred

interface RegisterContract {
    interface RegisterModel:IModel{
        fun register(entitiy:RegisterEntity):Deferred<BaseRespEntity<RegisterUserEntity>>
    }
    abstract class RegisRepository:BaseRepository<RegisterModel>(){
        abstract fun register(entitiy: RegisterEntity):Deferred<BaseRespEntity<RegisterUserEntity>>
    }
    interface RegisterView:IView{
        fun <T> registerSuccess(data:T)
        fun registerFail(msg:String)
    }
    abstract class RegisterPresenter(view:RegisterView):BasePresenter<RegisRepository,RegisterView>(view){
        abstract fun register(entitiy: RegisterEntity)
    }
}