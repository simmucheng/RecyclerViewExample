package com.example.simmucheng.recyclerviewexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by simmucheng on 16/5/25.
 */
public class EasyAdapter extends RecyclerView.Adapter<MyViewHolder>{
    private Context mContext;
    protected List<String>mDatas;
    private LayoutInflater mInflater;

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }
    private OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener listener){
        this.onItemClickListener=listener;
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
           holder.tv.setText(mDatas.get(position));
        setUpItemEvent(holder);

    }
    protected void setUpItemEvent(final MyViewHolder holder){
        if(onItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int getlayoutposition=holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder.itemView,getlayoutposition);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int getlayoutposition=holder.getLayoutPosition();
                    onItemClickListener.onItemLongClick(holder.itemView,getlayoutposition);
                    return false;
                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.item_single_textview,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    public EasyAdapter(Context context, List<String>datas) {
        this.mContext=context;
        this.mDatas=datas;
        mInflater=LayoutInflater.from(context);
    }
    public void addData(int position){
        mDatas.add(position,"Insert one");
        notifyItemInserted(position);
    }
    public void deleteData(int position){
        mDatas.remove(position);
        notifyItemRemoved(position);
    }



}
class MyViewHolder extends RecyclerView.ViewHolder{
    TextView tv;
    public MyViewHolder(View itemView) {
        super(itemView);
        tv=(TextView) itemView.findViewById(R.id.id_tv);
    }
}
