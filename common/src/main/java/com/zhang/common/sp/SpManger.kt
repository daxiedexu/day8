package com.zhang.common.sp

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class SpManger <T> constructor( val key:String,val defaultValue:T,val isCommit:Boolean = true):ReadWriteProperty<Any?,T>{
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        var findKey = if (key.isNotBlank()) property.name else key
//        return SpUtils.getValue(findKey,defaultValue)
        return 0 as T
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
//        SpUtils.putValue(key, value, isCommit)
    }
}