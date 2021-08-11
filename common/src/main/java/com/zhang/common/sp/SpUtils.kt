package com.zhang.common.sp

import android.content.Context
import android.content.SharedPreferences

object SpUtils {
    private val sp:SharedPreferences by lazy {
        createSharedPreferences()!!
    }

    //returnSp存储对象
    private fun createSharedPreferences():SharedPreferences? {
//        return MyApplication.getAppContext().getSharedPreferences("a1901",Context.MODE_PRIVATE)
        return null
    }

    fun <T> putValue(key:String,value:T,isCommit:Boolean){
        sp.edit().apply {
            when(value){
                is String -> putString(key,value)
                else -> throw IllegalAccessException("You type I don't know")
            }
            if (isCommit) commit() else apply()
        }
    }

    fun <T> getValue(key: String,defaultValue:T):T{
        return when(defaultValue){
            is String -> sp.getString(key,defaultValue)
            else -> throw IllegalAccessException("You type I don't know")
        }as T
    }
}