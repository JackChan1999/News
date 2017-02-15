
package com.tiger.quicknews.adapter;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
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
public class MyOnClickListener implements OnClickListener {
    private int index = 0;
    private final ViewPager viewPager;

    public MyOnClickListener(int i, ViewPager viewPager) {
        index = i;
        this.viewPager = viewPager;
    }

    @Override
    public void onClick(View v) {
        viewPager.setCurrentItem(index);
    }
}
