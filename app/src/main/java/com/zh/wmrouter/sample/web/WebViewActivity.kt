package com.zh.wmrouter.sample.web

import android.annotation.SuppressLint
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.sankuai.waimai.router.annotation.RouterRegex
import com.sankuai.waimai.router.common.UriParamInterceptor
import com.zh.base.BaseActionBarActivity
import com.zh.wmrouter.sample.AppConstant
import com.zh.wmrouter.sample.R
import com.zh.wmrouter.sample.interceptors.CommonParamInterceptor

/**
 * <b>Package:</b> com.zh.wmrouter.sample.web <br>
 * <b>Create Date:</b> 2019-12-04  16:23 <br>
 * <b>@author:</b> zihe <br>
 * <b>Description:</b> Web网页内部加载 <br>
 */
@RouterRegex(
    regex = AppConstant.Regex.INNER_URL_REGEX,
    exported = true,
    priority = 1,
    //设置拦截器，添加通用参数
    interceptors = [CommonParamInterceptor::class, UriParamInterceptor::class]
)
class WebViewActivity : BaseActionBarActivity() {
    private lateinit var vProgressBar: ProgressBar
    private lateinit var vWebView: WebView

    private var mUrl: String = ""

    override fun onLayoutBefore() {
        super.onLayoutBefore()
        mUrl = intent?.dataString ?: ""
        if (mUrl.isBlank()) {
            finish()
            return
        }
        LogUtils.d("WebView 加载Url => $mUrl")
    }

    override fun onLayoutId(): Int {
        return R.layout.app_web_view_activity
    }

    override fun onBindView(view: View) {
        supportActionBar?.title = "内部网页浏览器"
        showActionBarBackButton()
        findView(view)
        bindView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun findView(view: View) {
        vProgressBar = view.findViewById(R.id.progress_bar)
        vWebView = view.findViewById(R.id.web_view)
        vWebView.apply {
            val settings = vWebView.settings
            settings.loadWithOverviewMode = false
            //支持JS
            settings.javaScriptEnabled = true
            //支持通过JS打开新窗口
            settings.javaScriptCanOpenWindowsAutomatically = true
            //将图片调整到合适WebView的大小
            settings.useWideViewPort = true
            //缩放至屏幕的大小
            settings.loadWithOverviewMode = true
            //支持自动加载图片
            settings.loadsImagesAutomatically = true
            //支持多窗口
            settings.supportMultipleWindows()
            //支持缩放
            settings.setSupportZoom(true)
            //支持双击缩放、缩小
            settings.builtInZoomControls = true
            //设置允许访问见
            settings.allowFileAccess = true
            //设置支持访问内容，支持file协议
            settings.allowContentAccess = true
            //设置是否允许通过 file url 加载的 Js代码读取其他的本地文件
            settings.allowFileAccessFromFileURLs = true
            //设置是否允许通过 file url 加载的 Javascript 可以访问其他的源(包括http、https等源)
            settings.allowUniversalAccessFromFileURLs = true
            //开启DOM存储
            settings.domStorageEnabled = true
            //不进行缓存
            settings.cacheMode = WebSettings.LOAD_NO_CACHE
            webViewClient = object : WebViewClient() {
                override fun onReceivedError(
                    view: WebView?,
                    errorCode: Int,
                    description: String?,
                    failingUrl: String?
                ) {
                    super.onReceivedError(view, errorCode, description, failingUrl)
                    ToastUtils.showShort("加载失败")
                }
            }
            webChromeClient = object : WebChromeClient() {
                override fun onReceivedTitle(view: WebView?, title: String?) {
                    super.onReceivedTitle(view, title)
                    supportActionBar?.title = title
                }

                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    super.onProgressChanged(view, newProgress)
                    if (newProgress == 100) {
                        //加载结束
                        vProgressBar.visibility = View.GONE
                    } else {
                        vProgressBar.apply {
                            visibility = View.VISIBLE
                            progress = newProgress
                        }
                    }
                }
            }
        }
    }

    private fun bindView() {
        vWebView.loadUrl(mUrl)
    }

    override fun onBackPressed() {
        if (vWebView.canGoBack()) {
            vWebView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}