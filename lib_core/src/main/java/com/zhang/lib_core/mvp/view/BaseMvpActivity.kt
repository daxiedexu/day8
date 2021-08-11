package com.zhang.lib_core.mvp.view
import com.zhang.lib_core.mvp.presenter.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext


abstract class BaseMvpActivity<P:BasePresenter<*,*>>:BaseActivity(),CoroutineScope {
    protected lateinit var mPresenter:P
    lateinit var job:Job
    init {
        mPresenter = createPresenter()
        job = Job()
    }
    abstract fun createPresenter(): P
    override val coroutineContext: CoroutineContext
        get() = job

    override fun releaseResource() {
        job.cancel()
    }
}