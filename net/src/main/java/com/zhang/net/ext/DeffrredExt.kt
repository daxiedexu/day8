package com.zhang.net.ext

import com.zhang.net.protocol.req.BaseRespEntity
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> Deferred<T>.doResult(success:(BaseRespEntity<*>)->Unit,failed:(Throwable)->Unit,completed:Deferred<T>.()->Unit){
    try {
        val result = this.await() as BaseRespEntity<*>
        if (result.code==200){
            withContext(Dispatchers.Main){
                success(result)
            }
        }else{
            withContext(Dispatchers.Main){
                failed(Throwable(result.msg))
            }
        }
    }catch (ex:Throwable){
        val exMsg = ex
        withContext(Dispatchers.Main){
            failed(exMsg)
        }
    }finally {
        withContext(Dispatchers.Main){
            completed()
        }
    }
}