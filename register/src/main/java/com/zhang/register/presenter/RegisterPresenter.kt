package com.zhang.register.presenter

import com.zhang.net.ext.doResult
import com.zhang.net.protocol.req.BaseRespEntity
import com.zhang.register.contract.RegisterContract
import com.zhang.register.model.protocal.req.RegisterEntity
import com.zhang.register.model.protocal.resq.RegisterUserEntity
import com.zhang.register.repository.RegisterRepository
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class RegisterPresenter(_view:RegisterContract.RegisterView):RegisterContract.RegisterPresenter(_view) {
    override fun register(entitiy: RegisterEntity) {
//        mPepository.register(entitiy)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object : Observer<BaseRespEntity<RegisterUserEntity>>{
//                override fun onSubscribe(d: Disposable) {
//
//                }
//
//                override fun onNext(t: BaseRespEntity<RegisterUserEntity>) {
//                    mView.get()!!.registerSuccess(t)
//                }
//
//                override fun onError(e: Throwable) {
//                    mView.get()!!.registerFail(e.message.toString())
//                }
//
//                override fun onComplete() {
//
//                }
//            })
        presenterScope.launch {
            mPepository.register(entitiy).doResult({
                mView.get()!!.registerSuccess(it)
            },{
                mView.get()!!.registerFail("访问网络接口错误!")
            },{

            })
        }
    }

    override fun createRepository(): RegisterContract.RegisRepository {
        return RegisterRepository()
    }
}