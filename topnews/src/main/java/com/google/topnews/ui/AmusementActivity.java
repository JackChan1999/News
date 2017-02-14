package com.google.topnews.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.topnews.R;
import com.google.topnews.bean.AmusementNews;

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
 * time：2016/11/26 9:50
 * des ：${TODO}
 * gitVersion：$Rev$
 * updateAuthor：$Author$
 * updateDate：$Date$
 * updateDes：${TODO}
 * ============================================================
 **/
public class AmusementActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private NewsAdapter  mAdapter;
    String url = "http://c.m.163.com/nc/article/headline/T1348648517839/0-20.html";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        setContentView(R.layout.layout_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
    }

    private void initData() {
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                System.out.println(s);
                parseData(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });

        Volley.newRequestQueue(this).add(request);
    }

    private void parseData(String s) {
        Gson gson = new Gson();
        AmusementNews listdata = gson.fromJson(s, AmusementNews.class);
        mAdapter = new NewsAdapter(this, listdata.T1348648517839);
        mRecyclerView.setAdapter(mAdapter);
    }


    private class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

        private Context                      mContext;
        private List<AmusementNews.NewsData> listdata;
        private final int item_normal = 0;
        private final int item_image  = 1;


        public NewsAdapter(Context context, List<AmusementNews.NewsData> listdata) {
            mContext = context;
            this.listdata = listdata;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = null;
            if (viewType == item_image) {
                itemView = LayoutInflater.from(mContext).inflate(R.layout.item_image, parent,
                        false);
            } else {
                itemView = LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false);
            }
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext,"click",Toast.LENGTH_SHORT).show();
                }
            });*/
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.setData(listdata.get(position), getItemViewType(position));
            //System.out.println(listdata.get(position).url);
        }

        @Override
        public int getItemCount() {
            return listdata.size();
        }

        @Override
        public int getItemViewType(int position) {
            if (listdata.get(position).imgextra != null) {
                return item_image;
            }
            return super.getItemViewType(position);
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView iv;
            private TextView  title;
            private TextView  digest;

            public ViewHolder(View itemView) {
                super(itemView);
            }

            private void setData(AmusementNews.NewsData data, int itemtype) {
                if (itemtype == item_image) {
                    ImageView iv1 = (ImageView) itemView.findViewById(R.id.imageView1);
                    ImageView iv2 = (ImageView) itemView.findViewById(R.id.imageView2);
                    ImageView iv3 = (ImageView) itemView.findViewById(R.id.imageView3);

                    Glide.with(mContext).load(data.imgsrc).into(iv1);
                    Glide.with(mContext).load(data.imgextra.get(0).imgsrc).into(iv2);
                    Glide.with(mContext).load(data.imgextra.get(1).imgsrc).into(iv3);
                } else {
                    iv = (ImageView) itemView.findViewById(R.id.pic);
                    title = (TextView) itemView.findViewById(R.id.title);
                    digest = (TextView) itemView.findViewById(R.id.digest);

                    Glide.with(mContext).load(data.imgsrc).into(iv);
                    title.setText(data.title);
                    digest.setText(data.digest);
                }
            }
        }

    }
}
