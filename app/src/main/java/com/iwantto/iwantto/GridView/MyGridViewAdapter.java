package com.iwantto.iwantto.GridView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.iwantto.iwantto.R;

public class MyGridViewAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    public MyGridViewAdapter(Context context){
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        public ImageView imageView;
        public TextView textView;
    }

    @Override
    public View getView(int position, View converview, ViewGroup parent) {
        ViewHolder holder = null;
        if (converview == null){
            converview = mLayoutInflater.inflate(R.layout.layout_grid_item,null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) converview.findViewById(R.id.iv_grid);
            holder.textView = (TextView) converview.findViewById(R.id.tv_title);
            converview.setTag(holder);
        }else{
            holder = (ViewHolder) converview.getTag();
        }
        //赋值
        holder.textView.setText("花" );
        Glide.with(mContext).load("https://b-ssl.duitang.com/uploads/blog/201306/07/20130607133007_Zu4PM.thumb.700_0.jpeg").into(holder.imageView);
        return converview;
    }
}
