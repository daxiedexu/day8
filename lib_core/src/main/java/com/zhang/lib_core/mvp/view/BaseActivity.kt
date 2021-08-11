package com.zhang.lib_core.mvp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initData(savedInstanceState)
        initEvent()
    }

    abstract fun getLayoutId():Int
    abstract fun initData(savedInstanceState: Bundle?)
    abstract fun initEvent()
    abstract fun releaseResource()

    override fun onStop() {
        super.onStop()
        releaseResource()
    }
}