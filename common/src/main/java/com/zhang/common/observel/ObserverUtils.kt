package com.zhang.common.observel

import android.util.Log
import java.util.*

object ObserverUtils {
    private var map:MutableMap<String,ZObserverable>?=null
    fun getFinalObserverable(key: String):ZObserverable{
        if (!getMap()!!.containsKey(key)){
            val observable= ZObserverable()
            getMap()!!.put(key, observable)
            return observable
        }
        return getObservable(key)!!
    }

    fun getMap():MutableMap<String,ZObserverable>{
        if (map==null){
            Log.d("123","map is null...")
            map= mutableMapOf()
        }
        return map!!
    }

    fun unRegister(key:String){
        if (getMap()!!.containsKey(key)){
            getMap()!!.remove(key)
        }
    }

    fun getObservable(key:String):ZObserverable?{
        if (getMap()!!.containsKey(key))
        {
            return getMap()!!.get(key)
        }
        return null
    }
}