package com.google.topnews.bean;

import java.io.Serializable;

public class ChannelItem implements Serializable {
  
    private static final long serialVersionUID = -6465237897027410019L;
    
    public Integer id;
    public String name;
    public Integer position;
    public Integer selected;

    public ChannelItem() {
    }

    public ChannelItem(Integer id, String name, Integer position, Integer selected) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.selected = selected;
    }
}