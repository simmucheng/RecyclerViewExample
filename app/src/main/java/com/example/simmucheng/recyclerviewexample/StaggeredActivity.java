package com.example.simmucheng.recyclerviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class StaggeredActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private StaggeredAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        initView();

        mAdapter=new StaggeredAdapter(this,mDatas);
        mRecyclerView.setAdapter(mAdapter);
        //设置RecyclerView的布局管理
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(3,
               StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);


        mAdapter.setOnItemClickListener(new EasyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onItemLongClick(View view, int position) {
                mAdapter.deleteData(position);
            }
        });
        //设置RecyclerView的item的分隔
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
          //      DividerItemDecoration.VERTICAL_LIST));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }
    private void initView() {
        mRecyclerView=(RecyclerView) findViewById(R.id.id_recyclerView);
    }
    private void initDatas() {
        mDatas=new ArrayList<String>();
        for(int i='A';i<='z';i++){
            mDatas.add(""+(char)i);
        }
    }
}
