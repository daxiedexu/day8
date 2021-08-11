package com.zhang.onehome

import android.content.Context
import android.content.Intent
import android.graphics.Outline
import android.os.Bundle
import android.view.View
import android.view.ViewOutlineProvider
import android.view.WindowManager
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.google.gson.Gson
import com.youth.banner.BannerConfig
import com.youth.banner.loader.ImageLoader
import com.zhang.common.work.NetworkState
import com.zhang.lib_core.mvp.view.BaseFragment
import com.zhang.lib_core.mvp.view.BaseMvpFragment
import com.zhang.onehome.adapter.GridAdapter
import com.zhang.onehome.bean.GridBean
import com.zhang.onehome.recommend.adapter.RecommendAdapter
import com.zhang.onehome.recommend.bean.RecommendBean
import com.zhang.onehome.recommend.mvp.contract.RecommendContract
import com.zhang.onehome.recommend.mvp.presenter.RecommendPresenterImpl
import kotlinx.android.synthetic.main.fragment_one_home.*

class OneHomeFragment:BaseMvpFragment<RecommendPresenterImpl>(),RecommendContract.RecommendView {
    val picList:Array<Int> = arrayOf(R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h)
    val gridList:MutableList<GridBean> = mutableListOf(
        GridBean(R.drawable.ic_launcher_background,"直播"),
        GridBean(R.drawable.ic_launcher_background,"直播"),
        GridBean(R.drawable.ic_launcher_background,"直播"),
        GridBean(R.drawable.ic_launcher_background,"直播"),
        GridBean(R.drawable.ic_launcher_background,"直播"),
        GridBean(R.drawable.ic_launcher_background,"直播"),
        GridBean(R.drawable.ic_launcher_background,"直播"),
        GridBean(R.drawable.ic_launcher_background,"直播"),
        GridBean(R.drawable.ic_launcher_background,"直播"),
        GridBean(R.drawable.ic_launcher_background,"直播"))
    var recommendAdapter:RecommendAdapter? = null
        override fun getLayoutId(): Int {
        return R.layout.fragment_one_home
    }

    override fun initData(savedInstanceState: Bundle?) {
        //TODO 设置不弹软键盘
        activity!!.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        //TODO banner
        fg_oneHome_banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        fg_oneHome_banner.setImages(picList.toMutableList())
        fg_oneHome_banner.setImageLoader(object :ImageLoader(){
            override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
                imageView!!.setImageResource(path as Int)
            }
        })
        fg_oneHome_banner.setOutlineProvider(object : ViewOutlineProvider(){
            override fun getOutline(view: View?, outline: Outline?) {
                outline!!.setRoundRect(0,0,view!!.width,view.height, 30F)
            }
        })
        fg_oneHome_banner.setClipToOutline(true)
        fg_oneHome_banner.setDelayTime(1500)
        fg_oneHome_banner.start()
        //TODO 设置Grid
        var gridAdapter = GridAdapter(R.layout.grid_layout, gridList)
        fg_oneHome_grid.adapter = gridAdapter
        fg_oneHome_grid.layoutManager = GridLayoutManager(activity,2,GridLayoutManager.HORIZONTAL,false)
        //TODO 设置推荐列表
        mPresenter.recommend(1,10)
    }

    override fun initEvent() {
        fg_oneHome_edit.setOnClickListener {
            var intent = Intent(activity,SearchActivity::class.java)
            startActivity(intent)
        }
    }

    override fun createPresenter(): RecommendPresenterImpl {
        return RecommendPresenterImpl(this)
    }

    override fun recommendSuccess(data: RecommendBean) {
        if (recommendAdapter==null){
            recommendAdapter = RecommendAdapter(R.layout.recommend_layout, data.data)
            fg_oneHome_recycler_recommend.adapter = recommendAdapter
            fg_oneHome_recycler_recommend.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        }
    }

    override fun recommendFail(msg: String) {
        ToastUtils.showShort(msg)
    }

    override fun getName(): String {
        TODO("Not yet implemented")
    }
}