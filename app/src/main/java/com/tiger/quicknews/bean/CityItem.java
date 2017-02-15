
package com.tiger.quicknews.bean;

import com.tiger.quicknews.wedget.city.ContactItemInterface;
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
public class CityItem implements ContactItemInterface
{
    private String nickName;
    private String fullName;

    public CityItem(String nickName, String fullName)
    {
        super();
        this.nickName = nickName;
        this.setFullName(fullName);
    }

    @Override
    public String getItemForIndex()
    {
        return fullName;
    }

    @Override
    public String getDisplayInfo()
    {
        return nickName;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

}
