package com.zh.home

import android.view.View
import android.widget.Button
import com.sankuai.waimai.router.annotation.RouterUri
import com.zh.base.BaseActionBarActivity
import com.zh.service.ModuleServiceManager
import com.zh.service.RouterUrls
import com.zh.service.login.LoginInterceptor

/**
 * <b>Package:</b> com.zh.home <br>
 * <b>Create Date:</b> 2019-12-03  10:10 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
@RouterUri(path = [RouterUrls.HOME_HOME], interceptors = [LoginInterceptor::class])
class HomeActivity : BaseActionBarActivity() {
    private lateinit var vGoAccountInfo: Button
    private lateinit var vGoSetting: Button
    private lateinit var vNearShop: Button

    override fun onLayoutId(): Int {
        return R.layout.home_home_activity
    }

    override fun onBindView(view: View) {
        supportActionBar?.title = "首页"
        findView(view)
        bindView()
    }

    private fun findView(view: View) {
        vGoAccountInfo = view.findViewById(R.id.go_account_info)
        vNearShop = view.findViewById(R.id.near_shop)
        vGoSetting = view.findViewById(R.id.go_setting)
    }

    private fun bindView() {
        vGoAccountInfo.setOnClickListener {
            ModuleServiceManager.getMineService().goAccountInfo(this)
        }
        vNearShop.setOnClickListener {
            ModuleServiceManager.getShopService().goNearShop(this)
        }
        vGoSetting.setOnClickListener {
            ModuleServiceManager.getSettingService().goAppSetting(this)
        }
    }
}