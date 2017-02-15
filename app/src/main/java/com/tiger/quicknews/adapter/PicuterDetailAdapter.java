
package com.tiger.quicknews.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.tiger.quicknews.bean.PicuterDetailModle;
import com.tiger.quicknews.view.PhotoDetailView;
import com.tiger.quicknews.view.PhotoDetailView_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;
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
@EBean
public class PicuterDetailAdapter extends BaseAdapter {

    public List<PicuterDetailModle> lists = new ArrayList<PicuterDetailModle>();

    @RootContext
    Context context;

    public void appendList(List<PicuterDetailModle> list) {
        if (!lists.containsAll(list) && list != null && list.size() > 0) {
            lists.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void clear() {
        lists.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PhotoDetailView photoItemView;
        if (convertView == null) {
            photoItemView = PhotoDetailView_.build(context);
        } else {
            photoItemView = (PhotoDetailView) convertView;
        }

        PicuterDetailModle picuterDetailModle = lists.get(position);

        photoItemView.setImage(lists.size(), position, picuterDetailModle.getAlt(),
                picuterDetailModle.getTitle(), picuterDetailModle.getPic());

        return photoItemView;
    }

}
