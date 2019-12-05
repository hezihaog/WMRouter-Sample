package com.zh.home

import android.view.View
import android.widget.Button
import com.sankuai.waimai.router.Router
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
    private lateinit var vGoWebBrowser: Button
    private lateinit var vGoLocalBrowser: Button
    private lateinit var vTestNotFound: Button
    private lateinit var vCallPhone: Button

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
        vGoWebBrowser = view.findViewById(R.id.go_web_browser)
        vGoLocalBrowser = view.findViewById(R.id.go_local_browser)
        vTestNotFound = view.findViewById(R.id.test_not_found)
        vCallPhone = view.findViewById(R.id.call_phone)
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
        vGoWebBrowser.setOnClickListener {
            Router.startUri(this@HomeActivity, "http://www.meituan.com")
        }
        vGoLocalBrowser.setOnClickListener {
            Router.startUri(this@HomeActivity, "http://www.baidu.com")
        }
        vTestNotFound.setOnClickListener {
            Router.startUri(this@HomeActivity, "/not_found")
        }
        vCallPhone.setOnClickListener {
            Router.startUri(this@HomeActivity, "tel:123456789")
        }
    }
}