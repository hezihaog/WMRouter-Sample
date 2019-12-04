package com.zh.wmrouter.sample.web

import android.content.Intent
import com.sankuai.waimai.router.annotation.RouterRegex
import com.sankuai.waimai.router.core.UriCallback
import com.sankuai.waimai.router.core.UriHandler
import com.sankuai.waimai.router.core.UriRequest
import com.sankuai.waimai.router.core.UriResult
import com.zh.wmrouter.sample.AppConstant

/**
 * <b>Package:</b> com.zh.wmrouter.sample.web <br>
 * <b>Create Date:</b> 2019-12-04  16:34 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b> 系统浏览器-处理，将链接交给系统浏览器执行 <br>
 */
@RouterRegex(regex = AppConstant.Regex.HTTP_URL_REGEX)
class SystemBrowserHandler : UriHandler() {
    override fun shouldHandle(request: UriRequest): Boolean {
        return true
    }

    override fun handleInternal(request: UriRequest, callback: UriCallback) {
        //调起系统浏览器
        try {
            val intent = Intent().apply {
                action = Intent.ACTION_VIEW
                data = request.uri
            }
            request.context.startActivity(intent)
            callback.onComplete(UriResult.CODE_SUCCESS)
        } catch (e: Exception) {
            e.printStackTrace()
            callback.onComplete(UriResult.CODE_ERROR)
        }
    }
}