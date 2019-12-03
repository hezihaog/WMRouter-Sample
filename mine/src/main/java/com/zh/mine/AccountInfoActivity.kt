package com.zh.mine

import android.view.View
import android.widget.TextView
import com.sankuai.waimai.router.annotation.RouterUri
import com.zh.base.BaseActionBarActivity
import com.zh.service.ModuleServiceManager
import com.zh.service.RouterUrls
import com.zh.service.login.LoginInterceptor

/**
 * <b>Package:</b> com.zh.mine <br>
 * <b>Create Date:</b> 2019-12-03  11:01 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b> 账号信息 <br>
 */
@RouterUri(path = [RouterUrls.MINE_ACCOUNT_INFO], interceptors = [LoginInterceptor::class])
class AccountInfoActivity : BaseActionBarActivity() {
    private lateinit var vUsername: TextView
    private lateinit var vPassword: TextView

    override fun onLayoutId(): Int {
        return R.layout.mine_account_info_activity
    }

    override fun onBindView(view: View) {
        supportActionBar?.title = "我的账号"
        showActionBarBackButton()
        findView(view)
        bindView()
    }

    private fun findView(view: View) {
        vUsername = view.findViewById(R.id.username)
        vPassword = view.findViewById(R.id.password)
    }

    private fun bindView() {
    }

    override fun setData() {
        super.setData()
        vUsername.text = "用户名：" + ModuleServiceManager.getLoginService().getUserInfo().username
        vPassword.text = "密码：" + ModuleServiceManager.getLoginService().getUserInfo().password
    }
}