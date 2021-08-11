package com.zhang.onehome.recommend.mvp.repository

import android.util.Log
import com.zhang.lib_core.mvp.annotation.Model
import com.zhang.net.protocol.req.BaseRespEntity
import com.zhang.onehome.recommend.bean.RecommendBean
import com.zhang.onehome.recommend.mvp.contract.RecommendContract
import com.zhang.onehome.recommend.mvp.model.RecommendLocalModel
import com.zhang.onehome.recommend.mvp.model.RecommendModelImpl
import io.reactivex.Observable
import kotlinx.coroutines.Deferred

class RecommendRepositoryImpl:RecommendContract.RecommendRepository() {
    private val TAG = "RegisterRepository"
    @Model
    private val remoteModel:RecommendModelImpl? = null
    @Model val  localModel:RecommendLocalModel? = null
    override fun recommend(page: Int, pageSize: Int): Observable<RecommendBean> {
        Log.d(TAG,localModel.toString())
        return remoteModel!!.recommend(page, pageSize)
    }
}