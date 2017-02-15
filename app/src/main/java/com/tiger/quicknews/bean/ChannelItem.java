
package com.tiger.quicknews.bean;

import java.io.Serializable;
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
public class ChannelItem implements Serializable {
  
    // private static final long serialVersionUID = -6465237897027410019L;
    
    public Integer id;
   
    public String name; //频道名称
    
    public Integer orderId; //顺序
   
    public Integer selected;

    public ChannelItem() {
    }

    public ChannelItem(int id, String name, int orderId, int selected) {
        this.id = id;
        this.name = name;
        this.orderId = orderId;
        this.selected = selected;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setSelected(Integer selected) {
        this.selected = selected;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getSelected() {
        return selected;
    }
}
