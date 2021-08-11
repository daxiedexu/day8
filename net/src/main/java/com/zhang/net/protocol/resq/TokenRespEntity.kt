package com.zhang.net.protocol.resq

data class TokenRespEntity(var access_token:String,var token_type:String,var expires_in:Int=0) {
}