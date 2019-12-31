package com.zh.login

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.blankj.utilcode.util.AppUtils
import com.sankuai.waimai.router.annotation.RouterUri
import com.zh.base.BaseActionBarActivity
import com.zh.service.ModuleServiceManager
import com.zh.service.RouterUrls

/**
 * <b>Package:</b> com.zh.login <br>
 * <b>Create Date:</b> 2019-12-03  11:39 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b> 登录页面 <br>
 */
@RouterUri(path = [RouterUrls.LOGIN_LOGIN])
class LoginActivity : BaseActionBarActivity() {
    private lateinit var vAppIcon: ImageView
    private lateinit var vUsername: EditText
    private lateinit var vPassword: EditText
    private lateinit var vLogin: Button

    override fun onLayoutId(): Int {
        return R.layout.login_login_activity
    }

    override fun onBindView(view: View) {
        supportActionBar?.title = "登录"
        findView(view)
        bindView()
    }

    private fun findView(view: View) {
        vAppIcon = view.findViewById(R.id.app_icon)
        vUsername = view.findViewById(R.id.username)
        vPassword = view.findViewById(R.id.password)
        vLogin = view.findViewById(R.id.login)
    }

    private fun bindView() {
        vAppIcon.setImageDrawable(AppUtils.getAppIcon())
        vLogin.setOnClickListener {
            val username = vUsername.text.toString().trim()
            if (username.isBlank()) {
                return@setOnClickListener
            }
            val password = vPassword.text.toString().trim()
            if (password.isBlank()) {
                return@setOnClickListener
            }
            //登录成功
            try {
                LoginStorage.saveUserInfo(username, password)
                ModuleServiceManager.getLoginService().notifyLoginSuccess()
                //登录成功，跳转到主页
                ModuleServiceManager.getHomeService().goHome(this)
                finish()
            } catch (e: Exception) {
                e.printStackTrace()
                //登录失败
                ModuleServiceManager.getLoginService().notifyLoginFailure()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        ModuleServiceManager.getLoginService().notifyLoginCancel()
    }
}