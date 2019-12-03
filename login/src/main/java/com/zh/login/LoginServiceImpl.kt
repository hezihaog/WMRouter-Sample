package com.zh.login

import android.app.Activity
import android.content.Context
import com.sankuai.waimai.router.Router
import com.sankuai.waimai.router.annotation.RouterService
import com.sankuai.waimai.router.common.DefaultUriRequest
import com.sankuai.waimai.router.components.UriSourceTools
import com.sankuai.waimai.router.core.OnCompleteListener
import com.sankuai.waimai.router.core.UriRequest
import com.zh.base.isNotContains
import com.zh.base.util.provider.ActivityProvider
import com.zh.service.RouterUrls
import com.zh.service.inter.LoginService
import com.zh.service.login.User
import java.util.concurrent.CopyOnWriteArrayList

/**
 * <b>Package:</b> com.zh.login <br>
 * <b>Create Date:</b> 2019-12-03  11:35 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
@RouterService(
    interfaces = [LoginService::class],
    key = [RouterUrls.LOGIN_SERVICE],
    singleton = true
)
class LoginServiceImpl : LoginService {
    private val mLoginResultBlocks by lazy {
        CopyOnWriteArrayList<LoginService.OnLoginResultObserver>()
    }

    override fun isLogin(): Boolean {
        return LoginStorage.isLogin()
    }

    override fun getUserInfo(): User {
        val userInfo = LoginStorage.getUserInfo()
        return User(
            userInfo.first,
            userInfo.second
        )
    }

    override fun goLogin(
        context: Context,
        onSuccessBlock: (() -> Unit)?,
        onFailBlock: (() -> Unit)?
    ) {
        Router.startUri(DefaultUriRequest(context, RouterUrls.LOGIN_LOGIN).apply {
            from(UriSourceTools.FROM_INTERNAL)
            onComplete(object : OnCompleteListener {
                override fun onSuccess(request: UriRequest) {
                    onSuccessBlock?.invoke()
                }

                override fun onError(request: UriRequest, resultCode: Int) {
                    onFailBlock?.invoke()
                }
            })
        })
    }

    override fun logout(activity: Activity) {
        LoginStorage.logout()
        ActivityProvider.get().finishAllActivity()
        goLogin(activity)
    }

    override fun registerLoginResultObserver(observer: LoginService.OnLoginResultObserver) {
        if (mLoginResultBlocks.isNotContains(this)) {
            mLoginResultBlocks.add(observer)
        }
    }

    override fun unregisterLoginResultObserver(observer: LoginService.OnLoginResultObserver) {
        mLoginResultBlocks.remove(observer)
    }

    override fun notifyLoginSuccess() {
        mLoginResultBlocks.forEach {
            it.onLoginSuccess()
        }
    }

    override fun notifyLoginCancel() {
        mLoginResultBlocks.forEach {
            it.onLoginCancel()
        }
    }

    override fun notifyLoginFailure() {
        mLoginResultBlocks.forEach {
            it.onLoginFailure()
        }
    }
}