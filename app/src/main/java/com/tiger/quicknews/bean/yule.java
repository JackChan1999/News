package com.tiger.quicknews.bean;

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
 * time：2016/11/25 19:49
 * des ：${TODO}
 * gitVersion：$Rev$
 * updateAuthor：$Author$
 * updateDate：$Date$
 * updateDes：${TODO}
 * ============================================================
 **/
public class yule {


    private List<T1348648517839Entity> T1348648517839;

    public void setT1348648517839(List<T1348648517839Entity> T1348648517839) {
        this.T1348648517839 = T1348648517839;
    }

    public List<T1348648517839Entity> getT1348648517839() {
        return T1348648517839;
    }

    public static class T1348648517839Entity {

        private String          template;
        private String          skipID;
        private String          lmodify;
        private String          postid;
        private String          source;
        private String          title;
        private int             hasImg;
        private String          digest;
        private String          boardid;
        private String          photosetID;
        private String          alias;
        private int             hasAD;
        private String          imgsrc;
        private String          ptime;
        private int             hasHead;
        private int             order;
        private int             imgType;
        private List<?>         editor;
        private int             votecount;
        private boolean         hasCover;
        private String          docid;
        private String          tname;
        private int             priority;
        private List<AdsEntity> ads;
        private int             replyCount;
        private String          ename;
        private int             imgsum;
        private boolean         hasIcon;
        private String          skipType;
        private String          cid;

        public static class AdsEntity {

            private String subtitle;
            private String tag;
            private String title;
            private String imgsrc;
            private String url;

        }
    }
}
