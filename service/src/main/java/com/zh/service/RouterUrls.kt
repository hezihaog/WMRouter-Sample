package com.zh.service

/**
 * <b>Package:</b> com.zh.service <br>
 * <b>Create Date:</b> 2019-12-03  10:25 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b> 统一管理Router的Url <br>
 */
class RouterUrls private constructor() {
    companion object {
        /**
         * 显示吐司
         */
        const val SHOW_TOAST_HANDLER = "/show_toast_handler"

        //--------------------------- 首页 ---------------------------

        /**
         * 首页模块服务
         */
        const val HOME_SERVICE = "/homes"
        /**
         * 首页
         */
        const val HOME_HOME = "/home/home"

        //--------------------------- 登录 ---------------------------

        /**
         * 登录模块服务
         */
        const val LOGIN_SERVICE = "/logins"
        /**
         * 登录页面
         */
        const val LOGIN_LOGIN = "/login/login"

        //--------------------------- 商店 ---------------------------

        /**
         * 商店模块服务
         */
        const val SHOP_SERVICE = "/shops"
        /**
         * 附近的商家
         */
        const val SHOP_NEAR = "/shop/near"

        //--------------------------- 位置 ---------------------------

        /**
         * 位置服务
         */
        const val LOCATION_SERVICE = "/location"

        //--------------------------- 我的 ---------------------------

        /**
         * 我的模块服务
         */
        const val MINE_SERVICE = "/mines"
        /**
         * 账户信息
         */
        const val MINE_ACCOUNT_INFO = "mines/account/info"

        //--------------------------- 设置 ---------------------------

        /**
         * 设置模块服务
         */
        const val SETTING_SERVICE = "/settings"
        /**
         * App设置页面
         */
        const val SETTING_APP = "/setting/app"
    }
}