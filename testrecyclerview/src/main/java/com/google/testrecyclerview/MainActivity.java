package com.google.testrecyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<ListData> listData = new ArrayList<>();
    private MyAdapter mMyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mMyAdapter = new MyAdapter(this);
        mRecyclerView.setAdapter(mMyAdapter);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //listData = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            ListData data = new ListData();
            data.text = "data" + i;
            listData.add(data);
        }
        //mMyAdapter.setData(listData);
        mMyAdapter.notifyDataSetChanged();
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        private Context context;
        //private List<String> data;

        public MyAdapter(Context context){
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemview = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
            return new ViewHolder(itemview);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.setData(listData.get(position).text);
        }

        @Override
        public int getItemCount() {
            return listData.size();
        }

        public void setData(List<String> listdata){
          /*  data.addAll(listdata);
            notifyDataSetChanged();*/
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private TextView tv;

            public ViewHolder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.tv);
            }

            public void setData(String text) {
                tv.setText(text);
            }
        }
    }
}
