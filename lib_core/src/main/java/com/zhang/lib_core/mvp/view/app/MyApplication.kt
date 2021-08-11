package com.zhang.lib_core.mvp.view.app

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import com.zhang.common.observel.ObserverUtils
import com.zhang.lib_core.mvp.view.IView

class MyApplication:Application() {
    private val TAG = "MyApplication"
    lateinit var activitys:MutableList<Activity>
    init {
        activitys = mutableListOf<Activity>()
        registerActivityLifecycleCallbacks(object:Application.ActivityLifecycleCallbacks{
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                activitys.add(activity)
            }

            override fun onActivityStarted(activity: Activity) {

            }

            override fun onActivityResumed(activity: Activity) {

            }

            override fun onActivityPaused(activity: Activity) {

            }

            override fun onActivityStopped(activity: Activity) {
                Log.d(TAG,activity.packageName)
                if (activity is IView){
                    val iView = activity as IView
                    ObserverUtils.getFinalObserverable(iView.getName()).notifiAll("nostop")
                }
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

            }

            override fun onActivityDestroyed(activity: Activity) {
                activitys.remove(activity)
            }

        })
    }
    override fun onCreate() {
        super.onCreate()
        mContent = this
//        head.put("Authorization","bearer 8ciNj0GQpoqWH8PJhsV69MKcF70FLK7VLANlUyi4rxVSffjDHto2KHwNjdP6pww8TOVc62oiwHbwn7nxsXWA0E-vOl4DyJs6lZZM3ctaUnsYT3sWO-R7Vv5OO8jf8vlaIsw4I6ylpQVpGPigIrNcb83DvfwSok-1LugbYMM7r2fwbXRRckgWabQcWWWyac_BOYSxTjYQyyR-Yxhz5v2UUcGG2tTQOMYeNYJvxGOMI8JLY_6ddV2VyKLTaHQCI9_QgewAxl5Ol28_hbbjtXpkrSe-N8CYui_H3fZm-urnD3M")
//        OkGo.getInstance().init(this)
//            .addCommonHeaders(head)
    }
    companion object{
        var mContent:Application? = null
        fun getAppContext():Context{
            return mContent!!
        }
    }
}