package com.google.topnews.manager;

import android.content.ContentValues;

import com.google.topnews.bean.ChannelItem;
import com.google.topnews.dao.ChannelDaoImpl;
import com.google.topnews.db.SQLHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChannelManager {
    public static ChannelManager manager;

    public static List<ChannelItem> defaultUserChannels;
    public static List<ChannelItem> defaultOtherChannels;

    private ChannelDaoImpl channelDao;
    private boolean userExist = false;

    static {
        defaultUserChannels = new ArrayList<ChannelItem>();
        defaultOtherChannels = new ArrayList<ChannelItem>();

        //选择频道列表
        defaultUserChannels.add(new ChannelItem(1, "头条", 1, 1));
        defaultUserChannels.add(new ChannelItem(2, "足球", 2, 1));
        defaultUserChannels.add(new ChannelItem(3, "娱乐", 3, 1));
        defaultUserChannels.add(new ChannelItem(4, "体育", 4, 1));
        defaultUserChannels.add(new ChannelItem(5, "财经", 5, 1));
        defaultUserChannels.add(new ChannelItem(6, "科技", 6, 1));
        // defaultUserChannels.add(new ChannelItem(7, "图片", 1, 0));

        //其他频道列表
        defaultOtherChannels.add(new ChannelItem(7, "CBA", 1, 0));
        defaultOtherChannels.add(new ChannelItem(8, "笑话", 2, 0));
        defaultOtherChannels.add(new ChannelItem(9, "汽车", 3, 0));
        defaultOtherChannels.add(new ChannelItem(10, "时尚", 4, 0));
        defaultOtherChannels.add(new ChannelItem(11, "北京", 5, 0));
        defaultOtherChannels.add(new ChannelItem(12, "军事", 6, 0));
        defaultOtherChannels.add(new ChannelItem(13, "房产", 7, 0));
        defaultOtherChannels.add(new ChannelItem(14, "游戏", 8, 0));
        defaultOtherChannels.add(new ChannelItem(15, "精选", 9, 0));
        defaultOtherChannels.add(new ChannelItem(16, "电台", 10, 0));
        defaultOtherChannels.add(new ChannelItem(17, "情感", 11, 0));
        defaultUserChannels.add(new ChannelItem(18, "电影", 12, 0));
        defaultUserChannels.add(new ChannelItem(19, "NBA", 13, 0));
        defaultUserChannels.add(new ChannelItem(20, "数码", 14, 0));
        defaultUserChannels.add(new ChannelItem(21, "移动", 15, 0));
        defaultUserChannels.add(new ChannelItem(22, "彩票", 16, 0));
        defaultUserChannels.add(new ChannelItem(23, "教育", 17, 0));
        defaultUserChannels.add(new ChannelItem(24, "论坛", 18, 0));
        defaultOtherChannels.add(new ChannelItem(25, "旅游", 19, 0));
        defaultOtherChannels.add(new ChannelItem(26, "手机", 20, 0));
        defaultOtherChannels.add(new ChannelItem(27, "博客", 21, 0));
        defaultOtherChannels.add(new ChannelItem(28, "社会", 22, 0));
        defaultOtherChannels.add(new ChannelItem(29, "家居", 23, 0));
        defaultOtherChannels.add(new ChannelItem(30, "暴雪", 24, 0));
        defaultUserChannels.add(new ChannelItem(31, "亲子", 25, 0));
    }

    private ChannelManager(SQLHelper sqlHelper) throws SQLException {
        if (channelDao == null)
            channelDao = new ChannelDaoImpl(sqlHelper.getContext());
        initDefaultChannel();
        return;
    }

    /**
     * 初始化频道管理类
     */
    public static ChannelManager getManager(SQLHelper dbHelper) throws SQLException {
        if (manager == null)
            synchronized (ChannelManager.class) {
                if (manager == null) {
                    manager = new ChannelManager(dbHelper);
                }
            }
        return manager;
    }

    /**
     * 清除所有的频道
     */
    public void deleteAllChannel() {
        channelDao.clearFeedTable();
    }

    public List<ChannelItem> getUserChannel() {
        Object cacheList = channelDao.listCache(SQLHelper.SELECTED + "= ?", new String[]{"1"});
        if (cacheList != null && !((List<?>) cacheList).isEmpty()) {
            userExist = true;
            List<Map<String, String>> maplist = (List) cacheList;
            int count = maplist.size();
            List<ChannelItem> list = new ArrayList<ChannelItem>();
            for (int i = 0; i < count; i++) {
                ChannelItem navigate = new ChannelItem();
                navigate.id = Integer.valueOf(maplist.get(i).get(SQLHelper.ID));
                navigate.name = maplist.get(i).get(SQLHelper.NAME);
                navigate.position = Integer.valueOf(maplist.get(i).get(SQLHelper.ORDERID));
                navigate.position = Integer.valueOf(maplist.get(i).get(SQLHelper.SELECTED));
                list.add(navigate);
            }
            return list;
        }
        return defaultUserChannels;
    }

    /**
     * 获取其他的频道
     */
    public List<ChannelItem> getOtherChannel() {
        Object cacheList = channelDao.listCache(SQLHelper.SELECTED + "= ?", new String[]{"0"});
        List<ChannelItem> list = new ArrayList<ChannelItem>();
        if (cacheList != null && !((List) cacheList).isEmpty()) {
            List<Map<String, String>> maplist = (List) cacheList;
            int count = maplist.size();
            for (int i = 0; i < count; i++) {
                ChannelItem navigate = new ChannelItem();
                navigate.id = Integer.valueOf(maplist.get(i).get(SQLHelper.ID));
                navigate.name = maplist.get(i).get(SQLHelper.NAME);
                navigate.position = Integer.valueOf(maplist.get(i).get(SQLHelper.ORDERID));
                navigate.selected = Integer.valueOf(maplist.get(i).get(SQLHelper.SELECTED));
                list.add(navigate);
            }
            return list;
        }
        if (userExist) {
            return list;
        }
        cacheList = defaultOtherChannels;
        return (List<ChannelItem>) cacheList;
    }

    /**
     * 保存用户频道到数据库
     */
    public void saveUserChannel(List<ChannelItem> userList) {
        for (int i = 0; i < userList.size(); i++) {
            ChannelItem channelItem = userList.get(i);
            channelItem.id = i;
            channelItem.selected = 1;
            channelDao.addCache(channelItem);
        }
    }

    public void updateChannel(ChannelItem channelItem, String selected) {
        ContentValues values = new ContentValues();
        values.put("selected", selected);
        values.put("id", channelItem.id);
        values.put("name", channelItem.name);
        values.put("orderId", channelItem.position);
        channelDao.updateCache(values, " name = ?", new String[]{channelItem.name});
    }

    // /**
    // * 保存单个用户频道到数据库
    // *
    // * @param userList
    // */
    //
    // public void saveUserChannel(ChannelItem channelItem) {
    // channelDao.addCache(channelItem);
    // }
    //
    // public void deleteUserChannel(ChannelItem channelItem) {
    // channelDao.deleteCache(" name=?", new String[] {
    // channelItem.getName()
    // });
    // }
    //
    // /**
    // * 保存单个其他频道到数据库
    // *
    // * @param userList
    // */
    // public void saveOtherChannel(ChannelItem channelItem) {
    // channelDao.addCache(channelItem);
    // }
    //
    // public void deleteOtherChannel(ChannelItem channelItem) {
    // channelDao.deleteCache(" name=?", new String[] {
    // channelItem.getName()
    // });
    // }

    /**
     * 保存其他频道到数据库
     */
    public void saveOtherChannel(List<ChannelItem> otherList) {
        for (int i = 0; i < otherList.size(); i++) {
            ChannelItem channelItem = otherList.get(i);
            channelItem.id = i;
            channelItem.position = 0;
            channelDao.addCache(channelItem);
        }
    }

    /**
     * 初始化数据库内的频道数据
     */
    private void initDefaultChannel() {
        deleteAllChannel();
        saveUserChannel(defaultUserChannels);
        saveOtherChannel(defaultOtherChannels);
    }
}