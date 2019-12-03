package com.zh.wmrouter.sample

import android.app.Application
import com.blankj.utilcode.util.ToastUtils
import com.sankuai.waimai.router.Router
import com.sankuai.waimai.router.common.DefaultRootUriHandler
import com.sankuai.waimai.router.components.DefaultLogger
import com.sankuai.waimai.router.core.Debugger
import com.sankuai.waimai.router.core.OnCompleteListener
import com.sankuai.waimai.router.core.UriRequest
import com.sankuai.waimai.router.core.UriResult
import com.zh.base.util.provider.ActivityProvider

/**
 * <b>Package:</b> com.zh.wmrouter.sample <br>
 * <b>Create Date:</b> 2019-12-03  09:52 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initActivityProvider()
        initRouter()
    }

    private fun initActivityProvider() {
        ActivityProvider.initialize(this)
    }

    /**
     * 初始化路由
     */
    private fun initRouter() {
        val enableLog = true
        //设置log
        val logger = DefaultLogger()
        Debugger.setLogger(logger)
        //log打印开关
        Debugger.setEnableLog(enableLog)
        //调试开关
        Debugger.setEnableDebug(enableLog)
        //根处理器
        val rootUriHandler = DefaultRootUriHandler(this)
        //设置全局跳转监听，可用于跳转失败时，Toast和埋点
        rootUriHandler.globalOnCompleteListener = object : OnCompleteListener {
            override fun onSuccess(request: UriRequest) {
                //跳转成功
            }

            override fun onError(request: UriRequest, resultCode: Int) {
                var text = request.getStringField(UriRequest.FIELD_ERROR_MSG, null) ?: ""
                if (text.isBlank()) {
                    text = when (resultCode) {
                        UriResult.CODE_NOT_FOUND -> "不支持的跳转链接"
                        UriResult.CODE_FORBIDDEN -> "没有权限"
                        else -> "跳转失败"
                    }
                }
                if (Debugger.isEnableDebug()) {
                    text += "($resultCode)"
                    text += "\n" + request.uri.toString()
                }
                ToastUtils.showLong(text)
            }
        }
        //开始初始化
        Router.init(rootUriHandler)
    }
}