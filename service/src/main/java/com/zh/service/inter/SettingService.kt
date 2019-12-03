package com.zh.service.inter

import android.content.Context

/**
 * <b>Package:</b> com.zh.service.inter <br>
 * <b>Create Date:</b> 2019-12-03  13:51 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b> 设置模块服务接口 <br>
 */
interface SettingService {
    /**
     * 跳转到App设置
     */
    fun goAppSetting(
        context: Context,
        onSuccessBlock: (() -> Unit)? = null,
        onFailBlock: (() -> Unit)? = null
    )
}