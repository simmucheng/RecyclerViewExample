package com.example.simmucheng.recyclerviewexample;

import android.content.Context;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simmucheng on 16/5/25.
 */
public class StaggeredAdapter extends EasyAdapter{
    private List<Integer>mHeights;


    public StaggeredAdapter(Context context, List<String>datas) {
        super(context,datas);

        mHeights=new ArrayList<Integer>();
        for(int i=0;i<mDatas.size();i++){
            mHeights.add((int)(100+Math.random()*100));
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
           holder.tv.setText(mDatas.get(position));
           ViewGroup.LayoutParams lp=holder.itemView.getLayoutParams();
           lp.height=mHeights.get(position);
           holder.itemView.setLayoutParams(lp);
           setUpItemEvent(holder);
    }
}
