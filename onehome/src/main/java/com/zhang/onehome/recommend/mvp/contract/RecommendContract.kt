package com.zhang.onehome.recommend.mvp.contract

import com.zhang.lib_core.mvp.model.BaseRepository
import com.zhang.lib_core.mvp.model.IModel
import com.zhang.lib_core.mvp.presenter.BasePresenter
import com.zhang.lib_core.mvp.view.IView
import com.zhang.onehome.recommend.bean.RecommendBean
import io.reactivex.Observable

interface RecommendContract {
    interface RecommendModel:IModel{
        fun recommend(page:Int,pageSize:Int):Observable<RecommendBean>
    }
    abstract class RecommendRepository:BaseRepository<RecommendModel>(){
        abstract fun recommend(page:Int,pageSize:Int):Observable<RecommendBean>
    }
    interface RecommendView:IView{
        fun recommendSuccess(data:RecommendBean)
        fun recommendFail(msg:String)
    }
    abstract class RecommendPresenter(view: RecommendView):BasePresenter<RecommendRepository,RecommendView>(view){
        abstract fun recommend(page:Int,pageSize:Int)
    }
}