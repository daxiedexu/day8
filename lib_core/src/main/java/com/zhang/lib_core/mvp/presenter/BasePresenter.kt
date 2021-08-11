package com.zhang.lib_core.mvp.presenter

import android.util.Log
import com.zhang.common.observel.ObserverUtils
import com.zhang.common.observel.ZObserver
import com.zhang.lib_core.mvp.model.BaseRepository
import com.zhang.lib_core.mvp.view.IView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import java.lang.ref.SoftReference

abstract class BasePresenter<Repo:BaseRepository<*>,V:IView>(_view:V):ZObserver{
    private val TAG = "BasePresenter"
    protected lateinit var mPepository:Repo
    private lateinit var job:Job
    protected val presenterScope:CoroutineScope by lazy { CoroutineScope(Dispatchers.Main + job) }
    protected lateinit var mView:SoftReference<V>
    init {
        Log.d(TAG,"123123123")
        mPepository = createRepository()
        mView = SoftReference<V>(_view)
        job = Job()
        val observable = ObserverUtils.getFinalObserverable(this.javaClass.simpleName).registerObserver(this)
    }

    abstract fun createRepository(): Repo

    override fun notify(vararg array: String?) {
        Log.d("BasePresenter","notifyAll ${this.toString()}")
        job.cancel()
    }
}