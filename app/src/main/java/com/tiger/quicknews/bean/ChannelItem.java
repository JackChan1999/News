
package com.tiger.quicknews.bean;

import java.io.Serializable;

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
