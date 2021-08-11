package com.zhang.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.blankj.utilcode.util.ToastUtils
import com.zhang.home.HomeActivity
import com.zhang.lib_core.mvp.view.BaseMvpActivity
import com.zhang.login.contract.LoginContract
import com.zhang.login.model.protocal.req.RegisterEntity
import com.zhang.login.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*
import javax.security.auth.login.LoginException

class LoginActivity : BaseMvpActivity<LoginPresenter>(),LoginContract.LoginView {
    private val TAG = "LoginActivity"
    override fun createPresenter(): LoginPresenter {
        return LoginPresenter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun initEvent() {
        act_login_btn.setOnClickListener {
            var username = act_login_username.text.trim().toString()
            var password = act_login_password.text.trim().toString()
            mPresenter.login(RegisterEntity("2021-7-24",0,password,"1",username))
        }
    }

    override fun <T> loginSuccess(data: T) {
        Log.d(TAG,data.toString())
        ToastUtils.showShort("登录成功!")
        var intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)
    }

    override fun loginFail(msg: String) {
        ToastUtils.showShort(msg)
    }

    override fun getName(): String {
       return  mPresenter.javaClass.simpleName
    }

}