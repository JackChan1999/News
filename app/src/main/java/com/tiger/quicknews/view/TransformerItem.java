
package com.tiger.quicknews.view;

import android.support.v4.view.ViewPager.PageTransformer;
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
public class TransformerItem {

    public String title;
    public Class<? extends PageTransformer> clazz;

    public TransformerItem(Class<? extends PageTransformer> clazz) {
        this.clazz = clazz;
        title = clazz.getSimpleName();
    }

    @Override
    public String toString() {
        return title;
    }

}
