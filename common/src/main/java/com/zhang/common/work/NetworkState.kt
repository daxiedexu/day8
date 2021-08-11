package com.zhang.common.work

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.NetworkInfo

class NetworkState {
    companion object{
        fun getNetworkState(context:Context):Boolean{
            val connectivityManager = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager?
            var allNetworkInfo: Array<out NetworkInfo> = connectivityManager!!.allNetworkInfo
            for (item in allNetworkInfo.iterator()){
                if (item.state==NetworkInfo.State.CONNECTED){
                    return true
                }
            }
            return false
        }
    }
}