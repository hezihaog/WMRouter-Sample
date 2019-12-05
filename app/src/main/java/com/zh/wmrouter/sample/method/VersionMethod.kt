package com.zh.wmrouter.sample.method

import com.sankuai.waimai.router.annotation.RouterService
import com.sankuai.waimai.router.method.Func0
import com.zh.wmrouter.sample.App
import com.zh.wmrouter.sample.AppConstant

/**
 * <b>Package:</b> com.zh.wmrouter.sample.method <br>
 * <b>Create Date:</b> 2019-12-05  09:37 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b> 获取版本号，远程方法 <br>
 */
@RouterService(interfaces = [Func0::class], key = [AppConstant.Method.GET_VERSION_CODE])
class VersionMethod : Func0<Int> {
    override fun call(): Int {
        val context = App.getContext()
        return try {
            context.packageManager
                .getPackageInfo(context.packageName, 0)
                .versionCode
        } catch (e: Exception) {
            e.printStackTrace()
            -1
        }
    }
}