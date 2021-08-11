package com.zhang.net.protocol.req

data class BaseRespEntity<T>(var code:Int,var data:T,var msg:String) {
}