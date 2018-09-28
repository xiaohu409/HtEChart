package com.github.xiaohu409.htechart.widget;

import android.graphics.Bitmap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * 项目名称：     WholesalerManager
 * 文件名：       HtWebViewClient
 * 描述：
 * 作者：         胡涛
 * 日期：         2018/9/28
 * 版本：         v1.0
 */
public class HtWebViewClient extends WebViewClient {

    private String data;

    public HtWebViewClient(String data) {
        this.data = data;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onPageFinished(final WebView view, String url) {
        super.onPageFinished(view, url);
        view.post(new Runnable() {
            @Override
            public void run() {
                view.loadUrl(String.format("javascript:setData(%s)", data));
            }
        });
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
    }


}
