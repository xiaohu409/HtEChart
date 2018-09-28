package com.github.xiaohu409.htechart.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.github.xiaohu409.htechart.R;


/**
 * 对百度EChart的封装
 * 由于EChart只有Web的实现，所以封装的思路就是加载本地html
 * 然后调用js赋值就可以了
 */
public class HtEChartView extends LinearLayout {

    private WebView webView;

    public HtEChartView(Context context) {
        this(context, null);
    }

    public HtEChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HtEChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
       LayoutInflater layoutInflater = LayoutInflater.from(context);
       if (layoutInflater == null) {
            return;
       }
        View view =layoutInflater.inflate(R.layout.ht_echart, this);
        webView = view.findViewById(R.id.web_view_id);
        webView.getSettings().setJavaScriptEnabled(true);
    }

    /**
     * 绑定数据
     * @param data
     */
    public void setData(String data) {
        if (webView == null) {
            return;
        }
        webView.setWebViewClient(new HtWebViewClient(data));
        webView.loadUrl("file:///android_asset/echart/echart.html");
    }
}
