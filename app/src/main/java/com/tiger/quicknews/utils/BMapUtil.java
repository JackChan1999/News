package com.tiger.quicknews.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.View.MeasureSpec;
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
public class BMapUtil {
	/**
	 * 从view 得到图片
	 * @param view
	 * @return
	 */
	public static Bitmap getBitmapFromViews(View view) {
//        view.destroyDrawingCache();
//        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
//                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
//        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
//        view.setDrawingCacheEnabled(true);
//        Bitmap bitmap = view.getDrawingCache(true);
//        return bitmap;  
		int spec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);  
        view.measure(spec, spec);  
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());  
        Bitmap b = Bitmap.createBitmap(view.getWidth(), view.getHeight(),  
                Bitmap.Config.ARGB_8888); 
        Canvas c = new Canvas(b);  
        c.translate(-view.getScrollX(), -view.getScrollY());  
        view.draw(c);  
        view.setDrawingCacheEnabled(true);  
        Bitmap cacheBmp = view.getDrawingCache();  
        Bitmap bitmap = cacheBmp.copy(Bitmap.Config.ARGB_8888, true);  
        view.destroyDrawingCache();  
        return bitmap;
	}
}
