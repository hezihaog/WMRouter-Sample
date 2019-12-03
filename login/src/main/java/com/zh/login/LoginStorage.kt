package com.zh.login

import com.blankj.utilcode.util.SPUtils

/**
 * <b>Package:</b> com.zh.login <br>
 * <b>Create Date:</b> 2019-12-03  11:45 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b> 登录模块Key-Value存储 <br>
 */
class LoginStorage {
    companion object {
        private const val KEY_USERNAME = "key_username"
        private const val KEY_PASSWORD = "key_password"

        /**
         * 保存用户信息
         */
        fun saveUserInfo(username: String, password: String) {
            SPUtils.getInstance().put(KEY_USERNAME, username)
            SPUtils.getInstance().put(KEY_PASSWORD, password)
        }

        /**
         * 获取用户信息
         */
        fun getUserInfo(): Pair<String, String> {
            val username = SPUtils.getInstance().getString(KEY_USERNAME, "")
            val password = SPUtils.getInstance().getString(KEY_PASSWORD, "")
            return Pair(username, password)
        }

        /**
         * 是否登录
         */
        fun isLogin(): Boolean {
            return SPUtils.getInstance().getString(KEY_USERNAME, "").isNotBlank()
        }

        /**
         * 退出登录
         */
        fun logout() {
            SPUtils.getInstance().remove(KEY_USERNAME)
            SPUtils.getInstance().remove(KEY_PASSWORD)
        }
    }
}