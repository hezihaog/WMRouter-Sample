package com.zh.service.handler

import com.blankj.utilcode.util.ToastUtils
import com.sankuai.waimai.router.annotation.RouterUri
import com.sankuai.waimai.router.core.UriCallback
import com.sankuai.waimai.router.core.UriHandler
import com.sankuai.waimai.router.core.UriRequest
import com.sankuai.waimai.router.core.UriResult
import com.zh.service.RouterUrls

/**
 * <b>Package:</b> com.zh.service.handler <br>
 * <b>Create Date:</b> 2019-12-05  10:15 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
@RouterUri(path = [RouterUrls.SHOW_TOAST_HANDLER])
class ShowToastHandler : UriHandler() {
    override fun shouldHandle(request: UriRequest): Boolean {
        return true
    }

    override fun handleInternal(request: UriRequest, callback: UriCallback) {
        ToastUtils.showShort("我是Toast消息")
        callback.onComplete(UriResult.CODE_SUCCESS)
    }
}