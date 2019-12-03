package com.zh.service.inter

import android.content.Context

/**
 * <b>Package:</b> com.zh.service.inter <br>
 * <b>Create Date:</b> 2019-12-03  14:35 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b> 商家模块服务 <br>
 */
interface ShopService {
    /**
     * 跳转到附近的商店
     */
    fun goNearShop(
        context: Context,
        onSuccessBlock: (() -> Unit)? = null,
        onFailBlock: (() -> Unit)? = null
    )
}