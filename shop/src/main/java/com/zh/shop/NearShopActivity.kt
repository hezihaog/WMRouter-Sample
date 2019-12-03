package com.zh.shop

import android.view.View
import com.sankuai.waimai.router.annotation.RouterUri
import com.zh.base.BaseActionBarActivity
import com.zh.service.RouterUrls
import com.zh.service.shop.ShopLocationInterceptor

/**
 * <b>Package:</b> com.zh.shop <br>
 * <b>Create Date:</b> 2019-12-03  14:38 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
@RouterUri(path = [RouterUrls.SHOP_NEAR], interceptors = [ShopLocationInterceptor::class])
class NearShopActivity : BaseActionBarActivity() {
    override fun onLayoutId(): Int {
        return R.layout.shop_near_activity
    }

    override fun onBindView(view: View) {
        supportActionBar?.title = "附近的商家"
        showActionBarBackButton()
    }
}