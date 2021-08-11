package com.zhang.lib_core.mvp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment:Fragment() {
    var baseView:View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (baseView==null){
            baseView = inflater.inflate(getLayoutId(),container,false)
        }
        return baseView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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