package com.zhang.onehome.recommend.mvp.model.api

import com.zhang.onehome.recommend.bean.RecommendBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RecommendApi {
    @GET("api/Goods/getRecommendGoods?")
    fun recomment(@Query("page") page:Int,@Query("pagesize") pageSize:Int):Observable<RecommendBean>
}