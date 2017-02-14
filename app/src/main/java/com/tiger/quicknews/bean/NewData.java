package com.tiger.quicknews.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 * Copyright：${TODO}有限公司版权所有 (c) 2016
 * Author：   陈冠杰
 * Email：    815712739@qq.com
 * GitHub：   https://github.com/JackChen1999
 * <p>
 * Project_Name：QuickNews
 * Package_Name：com.tiger.quicknews.bean
 * Version：1.0
 * time：2016/11/25 22:08
 * des ：${TODO}
 * gitVersion：$Rev$
 * updateAuthor：$Author$
 * updateDate：$Date$
 * updateDes：${TODO}
 * ============================================================
 **/
public class NewData {

    private List<Integer>    extend;
    private List<DataEntity> data;
    private int              retcode;

    public static class DataEntity {

        private List<ChildrenEntity> children;
        private int                  id;
        private String               title;
        private int                  type;


        public static class ChildrenEntity {

            private int    id;
            private String title;
            private int    type;
            private String url;
        }
    }
     //-------------------------------------------------------------
    public class NewsData {

        public int retcode;
        public ArrayList<NewsMenuData> data;

        // 侧边栏数据对象
        public class NewsMenuData {
            public String id;
            public String title;
            public int type;
            public String url;

            public ArrayList<NewsTabData> children;
        }

        // 新闻页面下11个子页签的数据对象
        public class NewsTabData {
            public String id;
            public String title;
            public int type;
            public String url;
        }

    }
}
