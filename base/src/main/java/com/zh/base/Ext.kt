package com.zh.base

/**
 * <b>Package:</b> com.zh.base <br>
 * <b>Create Date:</b> 2019-12-03  12:43 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */

/**
 * 判断元素是否不包含
 */
fun <T> List<T>.isNotContains(element: T): Boolean {
    return !this.contains(element)
}