package com.zh.base

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * <b>Package:</b> com.zh.base <br>
 * <b>Create Date:</b> 2019-12-03  21:16 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b>  <br>
 */
abstract class BaseActionBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onLayoutBefore()
        setContentView(onLayoutId())
        val root: View = findViewById(android.R.id.content)
        setupActionBar()
        onBindView(root)
        setData()
    }

    private fun setupActionBar() {
        supportActionBar?.apply {
            //显示标题
            setDisplayShowTitleEnabled(true)
            //不显示程序图标
            setDisplayShowHomeEnabled(false)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * 显示ActionBar的左侧返回键
     */
    protected fun showActionBarBackButton() {
        //显示左边的返回键
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    protected open fun onLayoutBefore() {
    }

    protected abstract fun onLayoutId(): Int

    protected abstract fun onBindView(view: View)

    protected open fun setData() {
    }
}