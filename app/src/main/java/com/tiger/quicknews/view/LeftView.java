
package com.tiger.quicknews.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.tiger.quicknews.R;
import com.tiger.quicknews.activity.*;
import com.tiger.quicknews.initview.SlidingMenuView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
/**
 * ============================================================
 * Copyright：Google有限公司版权所有 (c) 2017
 * Author：   陈冠杰
 * Email：    815712739@qq.com
 * GitHub：   https://github.com/JackChen1999
 * 博客：     http://blog.csdn.net/axi295309066
 * 微博：     AndroidDeveloper
 * <p>
 * Project_Name：QuickNews
 * Package_Name：com.tiger.quicknews
 * Version：1.0
 * time：2016/2/15 16:13
 * des ：${TODO}
 * gitVersion：$Rev$
 * updateAuthor：$Author$
 * updateDate：$Date$
 * updateDes：${TODO}
 * ============================================================
 **/
@EViewGroup(R.layout.activity_left)
public class LeftView extends LinearLayout {

    private final BaseActivity context;

    public LeftView(Context context) {
        super(context);
        this.context = (BaseActivity) context;
    }

    @Click(R.id.pics)
    public void enterPics(View view) {
        context.openActivity(TuPianActivity_.class);
        isShow();
    }

    @Click(R.id.video)
    public void enterVideo(View view) {
        context.openActivity(VideoActivity_.class);
        isShow();
    }

    @Click(R.id.ties)
    public void enterMessage(View view) {
        context.openActivity(MessageActivity_.class);
        isShow();
    }

    @Click(R.id.tianqi)
    public void enterTianQi(View view) {
        context.openActivity(WeatherActivity_.class);
        isShow();
    }

    @Click(R.id.more)
    public void enterMore(View view) {
        context.openActivity(MoreActivity_.class);
        isShow();
    }

    public void isShow() {
        if (SlidingMenuView.instance().slidingMenu.isMenuShowing()) {
            SlidingMenuView.instance().slidingMenu.showContent();
        }
    }

}
