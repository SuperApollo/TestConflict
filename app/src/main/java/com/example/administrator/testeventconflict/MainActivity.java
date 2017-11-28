package com.example.administrator.testeventconflict;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener {

    private ScrollView mScrollView;
    private RecyclerView mRecycler;
    private TextView mTv;
    private List<String> mDatas;
    private MyAdapter mMyAdatper;
    private final String TAG = MainActivity.this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        init();

    }

    @SuppressLint("NewApi")
    private void init() {
        mDatas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mDatas.add(i + "");
        }
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this) {
            @Override
            public boolean canScrollVertically() {
                return super.canScrollVertically();
            }
        };
        mRecycler.setLayoutManager(linearLayoutManager);
        mRecycler.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
            }
        });
        mMyAdatper = new MyAdapter(mDatas, MainActivity.this);
        mMyAdatper.setOnItemClickListener(this);
        mRecycler.setAdapter(mMyAdatper);

    }

    private void initView() {
        mScrollView = findViewById(R.id.scroll);
        mTv = findViewById(R.id.tv);
        mRecycler = findViewById(R.id.recycler);
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.d(TAG, "点击了" + mDatas.get(position));
        Toast.makeText(MainActivity.this, "点击了" + mDatas.get(position), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(View view, int position) {

    }
}
