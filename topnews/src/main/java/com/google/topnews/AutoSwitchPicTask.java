package com.google.topnews;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;

import com.google.topnews.bean.News;

import java.util.ArrayList;
import java.util.List;

public class AutoSwitchPicTask extends Handler implements Runnable {
    /**
     * 开启任务
     */
    public void start() {
        stop();
        postDelayed(this, 2000);
    }

    /**
     * 关闭任务
     */
    public void stop() {
        removeCallbacks(this);
    }

    @Override
    public void run() {
        // ViewPager选中下一个，如果是最后一个就选中第一个

        int position = mPicPager.getCurrentItem();
        if (position != mPicPager.getAdapter().getCount() - 1) {
            // 选中下一个
            mPicPager.setCurrentItem(++position);
        } else {
            // 如果是最后一个就选中第一个
            mPicPager.setCurrentItem(0);
        }

        // 发送延时任务
        postDelayed(this, 2000);
    }

    /**
     * 处理数据
     *
     * @param result
     * json
     * @param isRefresh
     */
    protected void processData(String result, boolean isRefresh) {
        NewItemData newItemData = GsonTools.changeGsonToBean(result, NewItemData.class);
        if (null != newItemData) {

            // 跟服务器交互成功
            // http：200
            if (newItemData.retcode == 200) {
                //true ：说明下拉刷新
                if(isRefresh){
                    if (null != mViewPager) {
                        // 让点停止
                        mViewPager.stop();
                    }

                    mNews.clear();
                    isLoading = true;
                    // 获取到热门新闻
                    List<Topnews> topnews = newItemData.data.topnews;
                    // 轮播图的标题
                    List<String> mTitleLists = new ArrayList<String>();

                    // 轮播图的背景图片
                    List<String> mImageLists = new ArrayList<String>();
                    // 初始化轮播图的点
                    initDot(topnews.size());
                    // 迭代所有的热门新闻
                    for (Topnews top : newItemData.data.topnews) {
                        mTitleLists.add(top.title);
                        mImageLists.add(top.topimage);
                    }

                    for (News news : newItemData.data.news) {
                        mNews.add(news);
                    }
                    // 自己可以跳动
                    mViewPager = new RollViewPager(mContext, mDotLists,
                            new ViewPageOnTouchListener() {

                                @Override
                                public void onViewPageClickListener() {
                                    Toast.makeText(mContext, "我被点击了", 0).show();
                                }

                            });
                    // 设置标题数据
                    mViewPager.setTextTitle(mTopNewsTitle, mTitleLists);
                    // 设置背景图片
                    mViewPager.setImageRes(mImageLists);
                    // 开始跳动
                    mViewPager.start();
                    // 添加到轮播图
                    top_news_viewpager.removeAllViews();
                    top_news_viewpager.addView(mViewPager);
                }


                // 判断当前是否有头
                if (mListView.getRefreshableView().getHeaderViewsCount() < 1) {
                    mListView.getRefreshableView().addHeaderView(topView);
                }
                //判断当前是否有更多的数据

                moreUrl = newItemData.data.more;
                //判断服务器是否有更多的数据

                if(TextUtils.isEmpty(moreUrl)){
                    //说明服务器没有更多的数据
                    //设置是否有更多数据的标志
                    mListView.setHasMoreData(false);
                }else{
                    //说明服务器有更多的数据
                    mListView.setHasMoreData(true);
                }
                //true：说明下拉刷新
                if(isRefresh){
                    mNews.clear();
                    //进行追加
                    mNews.addAll(newItemData.data.news);
                }else{
                    mNews.addAll(newItemData.data.news);
                }


                if (null == mAapter) {
                    mAapter = new NewItemAapter(mContext, mNews);
                    mListView.getRefreshableView().setAdapter(mAapter);
                } else {
                    mAapter.notifyDataSetChanged();
                }

                //告诉下拉刷新我们已经完成
                mListView.onPullDownRefreshComplete();
                //结束滚动加载
                mListView.onPullUpRefreshComplete();
            }
        }
    }

}