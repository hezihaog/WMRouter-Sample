package com.zh.setting

import android.content.Context
import com.sankuai.waimai.router.Router
import com.sankuai.waimai.router.annotation.RouterService
import com.sankuai.waimai.router.common.DefaultUriRequest
import com.sankuai.waimai.router.components.UriSourceTools
import com.sankuai.waimai.router.core.OnCompleteListener
import com.sankuai.waimai.router.core.UriRequest
import com.zh.service.RouterUrls
import com.zh.service.inter.SettingService

/**
 * <b>Package:</b> com.zh.setting <br>
 * <b>Create Date:</b> 2019-12-03  13:52 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
@RouterService(
    interfaces = [SettingService::class],
    key = [RouterUrls.SETTING_SERVICE],
    singleton = true
)
class SettingServiceImpl : SettingService {
    override fun goAppSetting(
        context: Context,
        onSuccessBlock: (() -> Unit)?,
        onFailBlock: (() -> Unit)?
    ) {
        Router.startUri(DefaultUriRequest(context, RouterUrls.SETTING_APP).apply {
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