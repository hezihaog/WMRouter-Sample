package com.zh.base

import android.app.ProgressDialog
import android.content.Context

/**
 * <b>Package:</b> com.zh.base <br>
 * <b>Create Date:</b> 2019-12-03  14:53 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
class WaitLoadingController(context: Context) {
    private var mLoadingDialog: ProgressDialog = ProgressDialog(context)

    /**
     * 显示等待弹窗
     */
    fun showWait(text: String) {
        mLoadingDialog.setMessage(text)
        if (!mLoadingDialog.isShowing) {
            mLoadingDialog.show()
        }
    }

    /**
     * 隐藏等待弹窗
     */
    fun hideWait() {
        try {
            mLoadingDialog.dismiss()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}