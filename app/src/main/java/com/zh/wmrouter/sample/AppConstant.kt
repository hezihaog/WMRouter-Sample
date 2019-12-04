package com.zh.wmrouter.sample

/**
 * <b>Package:</b> com.zh.wmrouter.sample <br>
 * <b>Create Date:</b> 2019-12-04  16:32 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b> 常量类 <br>
 */
class AppConstant private constructor() {
    class Regex private constructor() {
        companion object {
            /**
             * 内部连接正则
             */
            const val INNER_URL_REGEX =
                "http(s)?://(.*\\.)?(meituan|sankuai|dianping)\\.(com|info|cn).*"

            /**
             * Http连接正则
             */
            const val HTTP_URL_REGEX = "http(s)?://.*"
        }
    }
}