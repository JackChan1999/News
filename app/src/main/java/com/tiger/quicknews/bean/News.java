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
 * time：2016/11/25 19:27
 * des ：${TODO}
 * gitVersion：$Rev$
 * updateAuthor：$Author$
 * updateDate：$Date$
 * updateDes：${TODO}
 * ============================================================
 **/
public class News {

    private List<T1348647909107Entity> T1348647909107;

    public static class T1348647909107Entity {

        private String               template;
        private List<ImgextraEntity> imgextra;
        private String               skipID;
        private String               lmodify;
        private String               postid;
        private String               source;
        private String               title;
        private int                  hasImg;
        private String               digest;
        private String               boardid;
        private String               photosetID;
        private String               alias;
        private int                  hasAD;
        private String               imgsrc;
        private String               ptime;
        private int                  hasHead;
        private int                  order;
        private int                  votecount;
        private boolean              hasCover;
        private String               docid;
        private String               tname;
        private int                  priority;
        private List<AdsEntity>      ads;
        private int                  replyCount;
        private String               ename;
        private int                  imgsum;
        private boolean              hasIcon;
        private String               skipType;
        private String               cid;


        public static class ImgextraEntity {

            private String imgsrc;

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public String getImgsrc() {
                return imgsrc;
            }
        }

        public static class AdsEntity {

            private String subtitle;
            private String tag;
            private String title;
            private String imgsrc;
            private String url;

        }
    }
}
