package com.iwantto.iwantto.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iwantto.iwantto.R;

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.LinearViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;


    public StaggeredGridAdapter(Context context, OnItemClickListener listener){
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public StaggeredGridAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_staggered_grid_recycleview_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StaggeredGridAdapter.LinearViewHolder holder, int position) {
        if(position % 2 != 0){
            holder.imageView.setImageResource(R.drawable.image1);
        }else{
            holder.imageView.setImageResource(R.drawable.image2);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv);
        }
    }

    public interface OnItemClickListener{
        Void onClick(int pos);
    }
}
