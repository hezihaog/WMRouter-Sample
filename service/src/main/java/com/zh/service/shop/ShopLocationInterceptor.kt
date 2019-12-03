package com.zh.service.shop

import android.app.Activity
import com.blankj.utilcode.util.ToastUtils
import com.sankuai.waimai.router.core.UriCallback
import com.sankuai.waimai.router.core.UriInterceptor
import com.sankuai.waimai.router.core.UriRequest
import com.zh.base.WaitLoadingController
import com.zh.service.AppRouterUriResult
import com.zh.service.ModuleServiceManager

/**
 * <b>Package:</b> com.zh.service.shop <br>
 * <b>Create Date:</b> 2019-12-03  14:40 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b> 附近商家定位拦截器，确保进入商店页面时定位成功 <br>
 */
class ShopLocationInterceptor : UriInterceptor {
    override fun intercept(request: UriRequest, callback: UriCallback) {
        val locationService = ModuleServiceManager.getLocationService()
        if (locationService.hasLocation()) {
            //已经有定位了，放行
            callback.onNext()
        } else {
            val context = request.context
            //异常情况，忽略
            if (context !is Activity || context.isFinishing) {
                callback.onNext()
                return
            }
            val controller = WaitLoadingController(context)
            controller.showWait("定位中...")
            //还没有定位，定位成功后，再继续跳转
            locationService.obtainLocation({
                controller.hideWait()
                callback.onNext()
            }, {
                controller.hideWait()
                ToastUtils.showShort("定位失败")
                //定位失败
                callback.onComplete(AppRouterUriResult.CODE_LOCATION_FAILURE)
            })
        }
    }
}