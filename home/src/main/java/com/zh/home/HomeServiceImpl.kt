package com.zh.home

import android.content.Context
import com.sankuai.waimai.router.Router
import com.sankuai.waimai.router.annotation.RouterService
import com.sankuai.waimai.router.common.DefaultUriRequest
import com.sankuai.waimai.router.components.UriSourceTools
import com.sankuai.waimai.router.core.OnCompleteListener
import com.sankuai.waimai.router.core.UriRequest
import com.zh.service.RouterUrls
import com.zh.service.inter.HomeService

/**
 * <b>Package:</b> com.zh.home <br>
 * <b>Create Date:</b> 2019-12-03  10:13 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b> 首页模块实现 <br>
 */
@RouterService(interfaces = [HomeService::class], key = [RouterUrls.HOME_SERVICE], singleton = true)
class HomeServiceImpl : HomeService {
    override fun goHome(
        context: Context,
        onSuccessBlock: (() -> Unit)?,
        onFailBlock: (() -> Unit)?
    ) {
        Router.startUri(DefaultUriRequest(context, RouterUrls.HOME_HOME).apply {
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
}