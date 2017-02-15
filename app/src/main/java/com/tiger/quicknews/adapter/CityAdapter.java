
package com.tiger.quicknews.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.tiger.quicknews.R;
import com.tiger.quicknews.wedget.city.ContactItemInterface;
import com.tiger.quicknews.wedget.city.ContactListAdapter;

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
public class CityAdapter extends ContactListAdapter
{

    public CityAdapter(Context _context, int _resource,
            List<ContactItemInterface> _items)
    {
        super(_context, _resource, _items);
    }

    @Override
    public void populateDataForRow(View parentView, ContactItemInterface item,
            int position)
    {
        View infoView = parentView.findViewById(R.id.infoRowContainer);
        TextView nicknameView = (TextView) infoView
                .findViewById(R.id.cityName);

        nicknameView.setText(item.getDisplayInfo());
    }

}
