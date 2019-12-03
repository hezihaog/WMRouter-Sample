package com.zh.service.inter

import android.content.Context

/**
 * <b>Package:</b> com.zh.service.inter <br>
 * <b>Create Date:</b> 2019-12-03  11:06 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b> 我的模块服务 <br>
 */
interface MineService {
    /**
     * 跳转到用户账号信息
     */
    fun goAccountInfo(
        context: Context,
        onSuccessBlock: (() -> Unit)? = null,
        onFailBlock: (() -> Unit)? = null
    )
}