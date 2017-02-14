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
 * Package_Name：com.google.topnews
 * Version：1.0
 * time：2016/11/26 10:09
 * des ：${TODO}
 * gitVersion：$Rev$
 * updateAuthor：$Author$
 * updateDate：$Date$
 * updateDes：${TODO}
 * ============================================================
 **/
public class AmusementNews {

    public List<NewsData> T1348648517839;

    public class NewsData {

        //public String               template;
        public List<ImgextraEntity> imgextra;
        public String               skipID;
        //public String               lmodify;
        public String               postid;
        public String               source;
        public String               title;
        public int                  hasImg;
        public String               digest;
        public String               boardid;
        public String               photosetID;
        public String               alias;
        public int                  hasAD;
        public String               imgsrc;
        //public String               ptime;
        //public int                  hasHead;
        //public int                  order;
        public int                  votecount;
        //public boolean              hasCover;
        public String               docid;
        public String               tname;
        //public int                  priority;
        public List<AdsEntity>      ads;
        public int                  replyCount;
        public String               ename;
        //public int                  imgsum;
        public boolean              hasIcon;
        public String               skipType;
        public String               cid;
        public String               url;


        public class ImgextraEntity {

            public String imgsrc;
        }

        public class AdsEntity {

            public String subtitle;
            public String tag;
            public String title;
            public String imgsrc;
            public String url;
        }
    }
}
