package com.zh.service

/**
 * <b>Package:</b> com.zh.service <br>
 * <b>Create Date:</b> 2019-12-03  12:52 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
interface AppRouterUriResult {
    companion object {
        /**
         * 登录取消
         */
        const val CODE_LOGIN_CANCEL = -100

        /**
         * 登录失败
         */
        const val CODE_LOGIN_FAILURE = -101

        /**
         * 定位失败
         */
        const val CODE_LOCATION_FAILURE = -200
    }
}