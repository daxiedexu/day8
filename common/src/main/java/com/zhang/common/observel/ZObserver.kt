package com.zhang.common.observel

interface ZObserver {
    /*
    * 通知
    * */
    fun notify(vararg array: String?)
}