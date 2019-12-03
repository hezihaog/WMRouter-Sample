package com.zh.setting

import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.sankuai.waimai.router.annotation.RouterUri
import com.zh.base.BaseActionBarActivity
import com.zh.service.ModuleServiceManager
import com.zh.service.RouterUrls

/**
 * <b>Package:</b> com.zh.setting <br>
 * <b>Create Date:</b> 2019-12-03  13:54 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
@RouterUri(path = [RouterUrls.SETTING_APP])
class AppSettingActivity : BaseActionBarActivity() {
    private lateinit var vLogout: Button

    override fun onLayoutId(): Int {
        return R.layout.setting_app_activity
    }

    override fun onBindView(view: View) {
        supportActionBar?.title = "设置"
        showActionBarBackButton()
        findView(view)
        bindView()
    }

    private fun findView(view: View) {
        vLogout = view.findViewById(R.id.logout)
    }

    private fun bindView() {
        //退出登录
        vLogout.setOnClickListener {
            AlertDialog.Builder(this@AppSettingActivity)
                .setMessage("是否退出登录？")
                .setPositiveButton("确定") { _, _ ->
                    ModuleServiceManager.getLoginService().logout(this@AppSettingActivity)
                }
                .setNegativeButton("取消", null)
                .create()
                .show()
        }
    }
}