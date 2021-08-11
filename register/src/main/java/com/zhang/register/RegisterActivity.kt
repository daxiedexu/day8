package com.zhang.register

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.blankj.utilcode.util.ToastUtils
import com.lzy.okgo.OkGo
import com.lzy.okgo.callback.StringCallback
import com.lzy.okgo.model.Response
import com.zhang.lib_core.mvp.view.BaseMvpActivity
import com.zhang.login.LoginActivity
import com.zhang.register.contract.RegisterContract
import com.zhang.register.model.protocal.req.RegisterEntity
import com.zhang.register.presenter.RegisterPresenter
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(),RegisterContract.RegisterView {
    private val TAG = "RegisterActivity"
    override fun createPresenter(): RegisterPresenter {
        return RegisterPresenter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_register
    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun initEvent() {
        act_register_btn.setOnClickListener {
            val username = act_register_username.text.trim().toString()
            val password = act_register_password.text.trim().toString()
            mPresenter.register(RegisterEntity("2021-7-24",0,password,"1",username))
        }
        act_register_efficacy.setOnClickListener {
            OkGo.get<String>("http://39.98.153.96:8082/api/User/authcode").execute(object : StringCallback(){
                override fun onSuccess(response: Response<String>?) {
                    var efficacy = response!!.body().toString()
                    if (!efficacy.isEmpty()){
                        ToastUtils.showLong("获取验证码成功!")
                        sendInform(efficacy)
                    }else{
                        ToastUtils.showLong("获取验证码失败!")
                    }
                }
            })
        }
    }

    //获取到验证码 编辑通知框
    fun sendInform(data:String){
        var builder = NotificationCompat.Builder(this, "1")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("【挨踢科技】")
            .setContentText("验证码：$data 您正在使用短信验证码登录功能，该验证码仅用于身份验证，请勿泄露给他人使用。")
        with(NotificationManagerCompat.from(this)){
            notify(1,builder.build())
        }
    }

    override fun <T> registerSuccess(data: T) {
        Log.d(TAG,data.toString())
        ToastUtils.showShort("注册成功!")
        var intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }

    override fun registerFail(msg: String) {
        ToastUtils.showShort(msg)
    }

    override fun getName(): String {
        return mPresenter.javaClass.simpleName
    }
}