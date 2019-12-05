package com.zh.wmrouter.sample.interceptors

import com.sankuai.waimai.router.Router
import com.sankuai.waimai.router.core.UriCallback
import com.sankuai.waimai.router.core.UriInterceptor
import com.sankuai.waimai.router.core.UriRequest
import com.sankuai.waimai.router.utils.RouterUtils
import com.zh.wmrouter.sample.AppConstant

/**
 * <b>Package:</b> com.zh.wmrouter.sample.interceptors <br>
 * <b>Create Date:</b> 2019-12-05  09:34 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b> 通用参数拦截器，对uri添加通用参数 <br>
 */
class CommonParamInterceptor : UriInterceptor {
    /**
     * 通用参数
     */
    private val mCommonParams by lazy {
        val versionCode: Int = Router.callMethod(AppConstant.Method.GET_VERSION_CODE)
        mutableMapOf(
            "platform" to "android",
            "version" to versionCode.toString()
        )
    }

    override fun intercept(request: UriRequest, callback: UriCallback) {
        //拼接通用参数
        val uri = RouterUtils.appendParams(request.uri, mCommonParams)
        request.uri = uri
        callback.onNext()
    }
}