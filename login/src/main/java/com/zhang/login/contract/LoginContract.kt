package com.zhang.login.contract

import com.zhang.lib_core.mvp.model.BaseRepository
import com.zhang.lib_core.mvp.model.IModel
import com.zhang.lib_core.mvp.presenter.BasePresenter
import com.zhang.lib_core.mvp.view.IView
import com.zhang.login.model.protocal.req.RegisterEntity
import com.zhang.login.model.protocal.resq.RegisterUserEntity
import com.zhang.net.protocol.req.BaseRespEntity
import io.reactivex.Observable
import kotlinx.coroutines.Deferred

interface LoginContract {
    interface LoginModel:IModel{
        fun login(entitiy:RegisterEntity):Deferred<BaseRespEntity<RegisterUserEntity>>
    }
    abstract class LoginRepository:BaseRepository<LoginModel>(){
        abstract fun login(entitiy:RegisterEntity):Deferred<BaseRespEntity<RegisterUserEntity>>
    }
    interface LoginView:IView{
        fun <T> loginSuccess(data:T)
        fun loginFail(msg:String)
    }
    abstract class LoginPresenter(view:LoginView):BasePresenter<LoginRepository,LoginView>(view){
        abstract fun login(entitiy: RegisterEntity)
    }
}