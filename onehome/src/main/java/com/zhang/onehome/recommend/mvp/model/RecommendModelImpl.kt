package com.zhang.onehome.recommend.mvp.model

import com.zhang.net.RetrofitManger
import com.zhang.onehome.recommend.bean.RecommendBean
import com.zhang.onehome.recommend.mvp.contract.RecommendContract
import com.zhang.onehome.recommend.mvp.model.api.RecommendApi
import io.reactivex.Observable

class RecommendModelImpl:RecommendContract.RecommendModel {
    override fun recommend(page: Int, pageSize: Int): Observable<RecommendBean> {
        var service = RetrofitManger.retrofitManger.create(RecommendApi::class.java)
        return service.recomment(page,pageSize)
    }
}