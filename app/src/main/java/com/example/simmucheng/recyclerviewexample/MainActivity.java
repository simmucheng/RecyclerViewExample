package com.example.simmucheng.recyclerviewexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private EasyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        initView();

        mAdapter=new EasyAdapter(this,mDatas);
        mRecyclerView.setAdapter(mAdapter);
        //设置RecyclerView的布局管理
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter.setOnItemClickListener(new EasyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this,"Click "+position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MainActivity.this,"LongClick "+position,Toast.LENGTH_SHORT).show();
            }
        });

        //设置RecyclerView的item的分隔
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
          //      DividerItemDecoration.VERTICAL_LIST));



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


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

        switch (id){
            case R.id.action_add:
                mAdapter.addData(1);
                break;
            case R.id.action_delete:
                mAdapter.deleteData(1);
                break;
            case R.id.action_listview:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.action_gridview:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
                break;
            case R.id.action_hor_gridview:
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,
                        StaggeredGridLayoutManager.HORIZONTAL));
                break;
            case R.id.action_staggered:
                Intent intent=new Intent(this,StaggeredActivity.class);
                startActivity(intent);
            default:
                break;
        }
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
