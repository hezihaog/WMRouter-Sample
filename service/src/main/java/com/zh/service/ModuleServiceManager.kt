package com.zh.service

import com.sankuai.waimai.router.Router
import com.zh.service.inter.*

/**
 * <b>Package:</b> com.zh.service <br>
 * <b>Create Date:</b> 2019-12-03  10:29 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b> App模块服务管理 <br>
 */
class ModuleServiceManager private constructor() {
    companion object {
        /**
         * 获取登录模块服务
         */
        fun getLoginService(): LoginService {
            return Router.getService(LoginService::class.java, RouterUrls.LOGIN_SERVICE)
        }

        /**
         * 获取首页模块服务
         */
        fun getHomeService(): HomeService {
            return Router.getService(HomeService::class.java, RouterUrls.HOME_SERVICE)
        }

        /**
         * 获取我的模块服务
         */
        fun getMineService(): MineService {
            return Router.getService(MineService::class.java, RouterUrls.MINE_SERVICE)
        }

        /**
         * 获取设置模块服务
         */
        fun getSettingService(): SettingService {
            return Router.getService(SettingService::class.java, RouterUrls.SETTING_SERVICE)
        }

        /**
         * 获取商店模块服务
         */
        fun getShopService(): ShopService {
            return Router.getService(ShopService::class.java, RouterUrls.SHOP_SERVICE)
        }

        /**
         * 获取位置服务
         */
        fun getLocationService(): LocationService {
            return Router.getService(LocationService::class.java, RouterUrls.LOCATION_SERVICE)
        }
    }
}