package com.zh.mine

import android.content.Context
import com.sankuai.waimai.router.Router
import com.sankuai.waimai.router.annotation.RouterService
import com.sankuai.waimai.router.common.DefaultUriRequest
import com.sankuai.waimai.router.components.UriSourceTools
import com.sankuai.waimai.router.core.OnCompleteListener
import com.sankuai.waimai.router.core.UriRequest
import com.zh.service.RouterUrls
import com.zh.service.inter.MineService

/**
 * <b>Package:</b> com.zh.mine <br>
 * <b>Create Date:</b> 2019-12-03  11:07 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
@RouterService(interfaces = [MineService::class], key = [RouterUrls.MINE_SERVICE], singleton = true)
class MineServiceImpl : MineService {
    override fun goAccountInfo(
        context: Context,
        onSuccessBlock: (() -> Unit)?,
        onFailBlock: (() -> Unit)?
    ) {
        Router.startUri(DefaultUriRequest(context, RouterUrls.MINE_ACCOUNT_INFO).apply {
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