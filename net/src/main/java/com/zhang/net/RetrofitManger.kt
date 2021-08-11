package com.zhang.net

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.zhang.common.sp.SpManger
import com.zhang.net.api.TokenApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitManger {
    private var token:String  //by SpManger<String>("token","",false)
    init {
        token=""
    }
    companion object{
        val retrofitManger:RetrofitManger by lazy (LazyThreadSafetyMode.SYNCHRONIZED){
            RetrofitManger()
        }
    }
    val retorfit:Retrofit
    init {
        retorfit = Retrofit.Builder()
            .baseUrl("http://39.98.153.96:8082/")
            .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(createOkHttpClient())
            .build()
    }

    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(30,TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .connectTimeout(30,TimeUnit.SECONDS)
            .addNetworkInterceptor(createLogInterceptor())
            .addInterceptor(createTokenInterceptor())
            .build()
    }

    private fun createTokenInterceptor(): Interceptor {
        val interceptor = Interceptor {
            val request = it.request()
            var response:Response? = null
            //如何Token没有问题
            if (token.isNotBlank()){
                response = doRequest(request,it)
            }else{
                response = it.proceed(request)
            }
            if (response!!.code()==401){
                requestToken()
                doRequest(request,it)
            }else{
                response
            }
        }
        return interceptor
    }

    private fun createLogInterceptor(): Interceptor {
        var LoginInterceptor = HttpLoggingInterceptor()
        LoginInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return LoginInterceptor
    }

    private fun requestToken() {
        //获取token
        val tokenApi:TokenApi = create(TokenApi::class.java)
        val tokenService = tokenApi.getToken("password","e61851de19712215110a10615b1331b71761b419b1091181","")
        val result = tokenService!!.execute()
        //拿到token
        val resultToken = result.body()!!.access_token
        token = resultToken
    }

    fun <T> create(service: Class<T>): T {
        return retorfit.create(service)
    }


    private fun doRequest(request: Request, chain: Interceptor.Chain): Response? {
        return chain.proceed(setRequestHeader(request, chain))
    }

    private fun setRequestHeader(request: Request, chain: Interceptor.Chain): Request {
        return request.newBuilder()
            .addHeader("Authorization","bearer $token")
            .build()
    }
}