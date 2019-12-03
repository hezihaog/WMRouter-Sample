package com.zh.wmrouter.sample

import android.view.View
import com.zh.base.BaseActionBarActivity
import com.zh.service.ModuleServiceManager

class MainActivity : BaseActionBarActivity() {
    override fun onLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onBindView(view: View) {
        ModuleServiceManager.getHomeService().goHome(this, {
            finish()
        }, {
            finish()
        })
    }
}