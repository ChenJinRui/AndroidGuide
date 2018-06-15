package com.soul.androidguide;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.soul.androidguide.adapter.HomeTvAdapter;
import com.soul.androidguide.views.CustomRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    private CustomRecyclerView mRecyclerView;
    private CustomRecyclerView mRecyclerView2;
    private CustomRecyclerView mRecyclerView3;
    private final static int LINE_NUM = 5;
    private StaggeredGridLayoutManager mLayoutManager;
    private StaggeredGridLayoutManager mLayoutManager2;
    private StaggeredGridLayoutManager mLayoutManager3;
    private HomeTvAdapter mAdapter;
    private HomeTvAdapter mAdapter2;
    private HomeTvAdapter mAdapter3;
    private List<Integer> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        mContext = this;

        setContentView(R.layout.activity_main);
        mRecyclerView = (CustomRecyclerView) findViewById(R.id.id_recycler_view);
        mRecyclerView2 = (CustomRecyclerView) findViewById(R.id.id_recycler_view2);
        mRecyclerView3 = (CustomRecyclerView) findViewById(R.id.id_recycler_view3);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView2.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView3.setItemAnimator(new DefaultItemAnimator());
        mLayoutManager = new StaggeredGridLayoutManager(LINE_NUM, StaggeredGridLayoutManager.VERTICAL);
        mLayoutManager.setAutoMeasureEnabled(true);
        mLayoutManager2 = new StaggeredGridLayoutManager(LINE_NUM, StaggeredGridLayoutManager.VERTICAL);
        mLayoutManager2.setAutoMeasureEnabled(true);
        mLayoutManager3 = new StaggeredGridLayoutManager(LINE_NUM, StaggeredGridLayoutManager.VERTICAL);
        mLayoutManager3.setAutoMeasureEnabled(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView2.setLayoutManager(mLayoutManager2);
        mRecyclerView3.setLayoutManager(mLayoutManager3);

        initData();
        mAdapter = new HomeTvAdapter(this, mData);
        mAdapter2 = new HomeTvAdapter(this, mData);
        mAdapter3 = new HomeTvAdapter(this, mData);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView2.setAdapter(mAdapter2);
        mRecyclerView3.setAdapter(mAdapter3);
        mAdapter.setOnItemClickListener(new MyOnItemClickListener());
        mAdapter2.setOnItemClickListener(new MyOnItemClickListener());
        mAdapter3.setOnItemClickListener(new MyOnItemClickListener());
        mRecyclerView.setOnScrollListener(new MyOnScrollListener());
        mRecyclerView2.setOnScrollListener(new MyOnScrollListener());
        mRecyclerView3.setOnScrollListener(new MyOnScrollListener());
    }

    private void initData() {
        mData = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            mData.add(i);
        }
    }
    private class MyOnItemClickListener implements HomeTvAdapter.OnItemClickListener {
        @Override
        public void onItemClick(View view, int position) {
            Toast.makeText(mContext, "click:" + position, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onItemLongClick(View view, int position) {
        }
    }

    private class MyOnScrollListener extends RecyclerView.OnScrollListener {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            //在滚动的时候处理箭头的状态
        }
    }
}
