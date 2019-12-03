package com.zh.wmrouter.sample

import android.os.Bundle
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.sankuai.waimai.router.common.DefaultUriRequest
import com.sankuai.waimai.router.core.OnCompleteListener
import com.sankuai.waimai.router.core.UriRequest

/**
 * <b>Package:</b> com.zh.wmrouter.sample <br>
 * <b>Create Date:</b> 2019-12-03  09:58 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
class UriProxyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DefaultUriRequest.startFromProxyActivity(this, object : OnCompleteListener {
            override fun onSuccess(@NonNull request: UriRequest) {
                finish()
            }

            override fun onError(@NonNull request: UriRequest, resultCode: Int) {
                finish()
            }
        })
    }
}