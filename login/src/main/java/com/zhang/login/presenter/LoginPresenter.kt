package com.zhang.login.presenter

import com.zhang.login.contract.LoginContract
import com.zhang.login.model.protocal.req.RegisterEntity
import com.zhang.login.model.protocal.resq.RegisterUserEntity
import com.zhang.login.repository.LoginRepository
import com.zhang.net.ext.doResult
import com.zhang.net.protocol.req.BaseRespEntity
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class LoginPresenter(_view:LoginContract.LoginView):LoginContract.LoginPresenter(_view) {
    override fun login(entitiy: RegisterEntity) {
//        mPepository.login(entitiy)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object : Observer<BaseRespEntity<RegisterUserEntity>>{
//                override fun onSubscribe(d: Disposable) {
//
//                }
//
//                override fun onNext(t: BaseRespEntity<RegisterUserEntity>) {
//                    mView.get()!!.loginSuccess(t)
//                }
//
//                override fun onError(e: Throwable) {
//                    mView.get()!!.loginFail(e.message.toString())
//                }
//
//                override fun onComplete() {
//
//                }
//            })
        presenterScope.launch {
            mPepository.login(entitiy).doResult({
                mView.get()!!.loginSuccess(it)
            },{
                mView.get()!!.loginFail("访问网络接口错误!")
            },{

            })
        }
    }

    override fun createRepository(): LoginContract.LoginRepository {
        return LoginRepository()
    }
}