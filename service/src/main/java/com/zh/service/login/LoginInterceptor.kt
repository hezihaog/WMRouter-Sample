package com.zh.service.login

import com.sankuai.waimai.router.core.UriCallback
import com.sankuai.waimai.router.core.UriInterceptor
import com.sankuai.waimai.router.core.UriRequest
import com.zh.service.AppRouterUriResult
import com.zh.service.ModuleServiceManager
import com.zh.service.inter.LoginService

/**
 * <b>Package:</b> com.zh.service.login <br>
 * <b>Create Date:</b> 2019-12-03  12:29 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b> 登录拦截器 <br>
 */
class LoginInterceptor : UriInterceptor {
    override fun intercept(request: UriRequest, callback: UriCallback) {
        val loginService = ModuleServiceManager.getLoginService()
        //登录了，放行
        if (loginService.isLogin()) {
            callback.onNext()
        } else {
            //注册登录成功、失败、取消的回调
            loginService.run {
                registerLoginResultObserver(object : LoginService.OnLoginResultObserver {
                    override fun onLoginSuccess() {
                        unregisterLoginResultObserver(this)
                        callback.onNext()
                    }

                    override fun onLoginCancel() {
                        unregisterLoginResultObserver(this)
                        callback.onComplete(AppRouterUriResult.CODE_LOGIN_CANCEL)
                    }

                    override fun onLoginFailure() {
                        unregisterLoginResultObserver(this)
                        callback.onComplete(AppRouterUriResult.CODE_LOGIN_FAILURE)
                    }
                })
            }
            //跳转去登录
            loginService.goLogin(request.context)
        }
    }
}