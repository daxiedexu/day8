package com.zhang.lib_core.mvp.model

import android.os.Build
import com.zhang.lib_core.mvp.annotation.Model

abstract class BaseRepository<M:IModel> {
    init {
        initModel()
    }

    private fun initModel() {
        val thatType = this::class.java
        val declareFields = thatType.declaredFields//拿到类中所有的属性
        if (declareFields.size>0){
            var hashModel:Boolean = false
            for (fieid in declareFields){
                var annotation = fieid.getAnnotation(Model::class.java)//拿到Model属性的访问权限
                if (annotation!=null){
                    fieid.isAccessible = true//把访问权限打开
                    var typeNama:String = ""
                    if (Build.VERSION.SDK_INT>=28){
                        typeNama = fieid.genericType.typeName
                    }else{
                        typeNama = fieid.type.name
                    }
                    var forName = Class.forName(typeNama)//拿到类的实例
                    var newInstance = forName.newInstance()
                    fieid.set(this,newInstance)//设置反射的类
                    hashModel = true
                }
            }
            if(!hashModel){
                throw java.lang.IllegalStateException("no set any model....")
            }
        }else{
            throw java.lang.IllegalStateException("no set any field....")
        }
    }
}