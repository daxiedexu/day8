package com.zhang.common.observel

import java.util.*

class ZObserverable {
    private val observers:MutableList<ZObserver> by lazy { mutableListOf() }
    //注册
    fun registerObserver(observer: ZObserver):Boolean{
        if (observer !in observers){
            observers.add(observer)
            return true
        }else{
            return false
        }
    }
    //销毁
    fun unregisterobser(observer: ZObserver):Boolean{
        if(observer in observers){
            observers.remove(observer)
            return true
        }else{
            return false
        }
    }
    //移除所有的关观察者
    fun removeobserver(){
        observers.clear()
    }
    //通知所有观察者
    fun notifiAll(vararg args:String?){
        for (observer in observers){
            observer.notify(*args)
        }
    }
}