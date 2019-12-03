package com.zh.service.inter

import android.app.Activity
import android.content.Context
import com.zh.service.login.User

/**
 * <b>Package:</b> com.zh.service.inter <br>
 * <b>Create Date:</b> 2019-12-03  11:34 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b> 登录模块服务接口 <br>
 */
interface LoginService {
    /**
     * 是否已登录
     */
    fun isLogin(): Boolean

    /**
     * 获取用户信息
     */
    fun getUserInfo(): User

    /**
     * 跳转到登录
     */
    fun goLogin(
        context: Context,
        onSuccessBlock: (() -> Unit)? = null,
        onFailBlock: (() -> Unit)? = null
    )

    /**
     * 退出登录
     */
    fun logout(activity: Activity)

    /**
     * 注册登录结果回调
     * @param observer 登录结果回调
     */
    fun registerLoginResultObserver(observer: OnLoginResultObserver)

    /**
     * 取消注册登录登录结果回调
     * @param observer 登录结果回调
     */
    fun unregisterLoginResultObserver(observer: OnLoginResultObserver)

    interface OnLoginResultObserver {
        /**
         * 登录成功回调
         */
        fun onLoginSuccess()

        /**
         * 登录取消回调
         */
        fun onLoginCancel()

        /**
         * 登录失败回调
         */
        fun onLoginFailure()
    }

    /**
     * 回调登录成功
     */
    fun notifyLoginSuccess()

    /**
     * 回调登录取消
     */
    fun notifyLoginCancel()

    /**
     * 回调登录失败
     */
    fun notifyLoginFailure()
}