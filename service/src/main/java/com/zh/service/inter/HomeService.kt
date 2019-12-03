package com.zh.service.inter

import android.content.Context

/**
 * <b>Package:</b> com.zh.service <br>
 * <b>Create Date:</b> 2019-12-03  10:12 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b> 首页模块接口 <br>
 */
interface HomeService {
    /**
     * 跳转到首页
     * @param onSuccessBlock 跳转成功回调
     * @param onFailBlock 跳转失败回调
     */
    fun goHome(
        context: Context,
        onSuccessBlock: (() -> Unit)? = null,
        onFailBlock: (() -> Unit)? = null
    )
}