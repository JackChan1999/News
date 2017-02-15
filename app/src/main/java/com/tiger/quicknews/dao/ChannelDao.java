
package com.tiger.quicknews.dao;
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
import android.content.ContentValues;

import com.tiger.quicknews.bean.ChannelItem;

import java.util.List;
import java.util.Map;

public interface ChannelDao {
    public boolean addCache(ChannelItem item);

    public boolean deleteCache(String whereClause, String[] whereArgs);

    public boolean updateCache(ContentValues values, String whereClause, String[] whereArgs);

    public Map<String, String> viewCache(String selection, String[] selectionArgs);

    public List<Map<String, String>> listCache(String selection, String[] selectionArgs);

    public void clearFeedTable();
}
