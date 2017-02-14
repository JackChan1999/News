package com.google.topnews.bean;

import java.util.List;

/**
 * ============================================================
 * Copyright：${TODO}有限公司版权所有 (c) 2016
 * Author：   陈冠杰
 * Email：    815712739@qq.com
 * GitHub：   https://github.com/JackChen1999
 * <p>
 * Project_Name：QuickNews
 * Package_Name：com.google.topnews.bean
 * Version：1.0
 * time：2016/11/30 16:29
 * des ：${TODO}
 * gitVersion：$Rev$
 * updateAuthor：$Author$
 * updateDate：$Date$
 * updateDes：${TODO}
 * ============================================================
 **/
public class WebViewInfo {


    public Data C747SGG0000189FI;

    public class Data {

        public String                    template;
        public List<ImgEntity>           img;
        public SourceinfoEntity          sourceinfo;
        public List<TopiclistNewsEntity> topiclist_news;
        public List<?>                   link;
        public String                    shareLink;
        public List<VideoEntity>         video;
        public int                       threadVote;
        public String                    source;
        public String                    body;
        public String                    title;
        public String                    tid;
        public boolean                   picnews;
        public List<SpinfoEntity>        spinfo;
        public List<RelativeSysEntity>   relative_sys;
        public String                    digest;
        public List<?>                   boboList;
        public String                    ptime;
        public String                    ec;
        public String                    docid;
        public int                       threadAgainst;
        public boolean                   hasNext;
        public String                    dkeys;
        public List<?>                   users;
        public List<?>                   ydbaike;
        public int                       replyCount;
        public String                    voicecomment;
        public String                    replyBoard;
        public List<?>                   votes;
        public List<?>                   topiclist;


         class ImgEntity {
            public String ref;
            public String src;
            public String alt;
            public String pixel;

        }

         class SourceinfoEntity {

            public String ename;
            public String alias;
            public String tname;
            public String tid;


        }

         class TopiclistNewsEntity {

            public String  ename;
            public boolean hasCover;
            public String  alias;
            public String  tname;
            public String  subnum;
            public String  tid;
            public String  cid;

        }

        class VideoEntity {

            public String broadcast;
            public String url_mp4;
            public String mp4Hd_url;
            public String alt;
            public String videosource;
            public String appurl;
            public String m3u8Hd_url;
            public String mp4_url;
            public String cover;
            public String vid;
            public String url_m3u8;
            public String topicid;
            public String ref;
            public String commentboard;
            public String size;
            public String commentid;
            public String m3u8_url;


        }

        class SpinfoEntity {

            public String ref;
            public String spcontent;
            public String sptype;


        }

        class RelativeSysEntity {

            public String docID;
            public String from;
            public String id;
            public String source;
            public String href;
            public String title;
            public String imgsrc;
            public String type;
            public String ptime;
        }
    }
}
