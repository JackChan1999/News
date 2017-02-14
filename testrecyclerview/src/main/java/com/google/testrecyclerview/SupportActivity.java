package com.google.testrecyclerview;

import android.app.Activity;

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
 * Package_Name：com.google.testrecyclerview
 * Version：1.0
 * time：2016/12/18 11:57
 * des ：${TODO}
 * gitVersion：$Rev$
 * updateAuthor：$Author$
 * updateDate：$Date$
 * updateDes：${TODO}
 * ============================================================
 **/
public abstract class SupportActivity extends Activity {
    protected List<ListData> listData = new ArrayList<>();

    public abstract void init();
}
