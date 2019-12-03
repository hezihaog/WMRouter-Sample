package com.zh.location

import android.os.Handler
import android.os.Looper
import com.sankuai.waimai.router.annotation.RouterService
import com.zh.service.RouterUrls
import com.zh.service.inter.LocationService

/**
 * <b>Package:</b> com.zh.location <br>
 * <b>Create Date:</b> 2019-12-03  14:47 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
@RouterService(interfaces = [LocationService::class], key = [RouterUrls.LOCATION_SERVICE])
class LocationServiceImpl : LocationService {
    private val mMainHandler by lazy {
        Handler(Looper.getMainLooper())
    }

    override fun hasLocation(): Boolean {
        return false
    }

    override fun obtainLocation(successBlock: () -> Unit, failBlock: (() -> Unit)?) {
        //模拟定位
        mMainHandler.postDelayed({
            successBlock()
        }, 800)
    }
}