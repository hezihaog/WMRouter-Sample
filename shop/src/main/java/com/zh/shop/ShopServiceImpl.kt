package com.zh.shop

import android.content.Context
import com.sankuai.waimai.router.Router
import com.sankuai.waimai.router.annotation.RouterService
import com.sankuai.waimai.router.common.DefaultUriRequest
import com.sankuai.waimai.router.components.UriSourceTools
import com.sankuai.waimai.router.core.OnCompleteListener
import com.sankuai.waimai.router.core.UriRequest
import com.zh.service.RouterUrls
import com.zh.service.inter.ShopService

/**
 * <b>Package:</b> com.zh.shop <br>
 * <b>Create Date:</b> 2019-12-03  14:36 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
@RouterService(interfaces = [ShopService::class], key = [RouterUrls.SHOP_SERVICE])
class ShopServiceImpl : ShopService {
    override fun goNearShop(
        context: Context,
        onSuccessBlock: (() -> Unit)?,
        onFailBlock: (() -> Unit)?
    ) {
        Router.startUri(DefaultUriRequest(context, RouterUrls.SHOP_NEAR).apply {
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