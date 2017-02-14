package com.google.topnews.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.topnews.R;
import com.google.topnews.bean.WebViewInfo;

import org.sufficientlysecure.htmltextview.HtmlResImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

/**
 * ============================================================
 * Copyright：${TODO}有限公司版权所有 (c) 2016
 * Author：   陈冠杰
 * Email：    815712739@qq.com
 * GitHub：   https://github.com/JackChen1999
 * <p>
 * Project_Name：QuickNews
 * Package_Name：com.google.topnews.ui
 * Version：1.0
 * time：2016/11/30 16:08
 * des ：${TODO}
 * gitVersion：$Rev$
 * updateAuthor：$Author$
 * updateDate：$Date$
 * updateDes：${TODO}
 * ============================================================
 **/
public class WebViewActivity extends AppCompatActivity {

    private WebView mWebView;
    String url = "http://c.m.163.com/nc/article/C747SGG0000189FI/full.html";
    //private HtmlTextView mHtmlTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_html);

        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.loadUrl("http://news.163.com/16/1130/11/C747SGG0000189FI.html");


        //mHtmlTextView = (HtmlTextView)findViewById(R.id.html_text);


        /*StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String result) {
                parseData(result);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });

        Volley.newRequestQueue(this).add(request);*/
    }

    private void parseData(String result) {
        Gson gson = new Gson();
        WebViewInfo webViewInfo = gson.fromJson(result, WebViewInfo.class);
        //mWebView.loadData(webViewInfo.C747SGG0000189FI.body,"text/html",null);

        String content = webViewInfo.C747SGG0000189FI.body;

        content = content.replace("<!--IMG#0-->","<img src = \"http://dingyue.nosdn.127" +
                ".net/KZvLgaF7ROVrkp3ndPfkD7T8BG7S=MkA5ZctADwwpXFde1480475433772.jpg\" width=\"525\" height=\"583\"/>");
        //mHtmlTextView.setHtml(content, new HtmlResImageGetter(mHtmlTextView));
    }
}
