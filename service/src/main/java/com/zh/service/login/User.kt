package com.zh.service.login

import java.io.Serializable

/**
 * <b>Package:</b> com.zh.service.login <br>
 * <b>Create Date:</b> 2019-12-03  14:18 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b> 用户信息模型 <br>
 */
data class User(
    /**
     * 用户名
     */
    val username: String,
    /**
     * 密码
     */
    val password: String
) : Serializable {
    companion object {
        private const val serialVersionUID = -7304093289272778657L
    }
}