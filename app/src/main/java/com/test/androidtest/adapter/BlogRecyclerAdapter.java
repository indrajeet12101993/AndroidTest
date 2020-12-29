package com.test.androidtest.adapter;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.test.androidtest.R;
import com.test.androidtest.model.blogResponse.DataItem;

import java.util.List;

public class BlogRecyclerAdapter extends RecyclerView.Adapter<BlogRecyclerAdapter.MyViewHolder>  {
    List<DataItem> mBlogrtable;

    public BlogRecyclerAdapter(List<DataItem> bloogTable) {
        this.mBlogrtable =bloogTable;
    }

    @NonNull
    @Override
    public BlogRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.blog_list, viewGroup, false);
        return new BlogRecyclerAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final BlogRecyclerAdapter.MyViewHolder viewHolder, int i) {



       // viewHolder.text1.setText("Send");

        DataItem dataItem = mBlogrtable.get(i);
        if(dataItem.getTopic()!=null){
            viewHolder.tv_topic.setText(mBlogrtable.get(i).getTopic());

        }
        if(dataItem.getTitle()!=null){
            viewHolder.tv_title.setText(mBlogrtable.get(i).getTitle());

        }



        Glide.with(viewHolder.itemView.getContext())
                .load(dataItem.getImage()).
                into(viewHolder.iv_blog);



    }

    @Override
    public int getItemCount() {
        return   mBlogrtable.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_topic, tv_title;
        ImageView iv_blog;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_topic = itemView.findViewById(R.id.tv_topic);
            tv_title = itemView.findViewById(R.id.tv_title);
            iv_blog = itemView.findViewById(R.id.iv_blog);


        }
    }

}
