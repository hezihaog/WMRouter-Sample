package com.zh.service.inter

/**
 * <b>Package:</b> com.zh.service.inter <br>
 * <b>Create Date:</b> 2019-12-03  14:45 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b> 位置模块服务接口 <br>
 */
interface LocationService {
    /**
     * 是否有定位
     */
    fun hasLocation(): Boolean

    /**
     * 获取定位
     * @param successBlock 获取定位成功回调
     * @param failBlock 获取定位失败回调
     */
    fun obtainLocation(
        successBlock: () -> Unit,
        failBlock: (() -> Unit)? = null
    )
}