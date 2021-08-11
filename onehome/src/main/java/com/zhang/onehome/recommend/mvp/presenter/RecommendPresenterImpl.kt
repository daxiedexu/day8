package com.zhang.onehome.recommend.mvp.presenter

import com.zhang.onehome.recommend.bean.RecommendBean
import com.zhang.onehome.recommend.mvp.contract.RecommendContract
import com.zhang.onehome.recommend.mvp.repository.RecommendRepositoryImpl
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class RecommendPresenterImpl(_view:RecommendContract.RecommendView):RecommendContract.RecommendPresenter(_view) {
    override fun recommend(page: Int, pageSize: Int) {
        mPepository.recommend(page,pageSize)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<RecommendBean>{
                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: RecommendBean) {
                    mView.get()!!.recommendSuccess(t)
                }

                override fun onError(e: Throwable) {
                    mView.get()!!.recommendFail(e.message.toString())
                }

                override fun onComplete() {

                }
            })
    }

    override fun createRepository(): RecommendContract.RecommendRepository {
        return RecommendRepositoryImpl()
    }
}