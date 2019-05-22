package com.example.newsshots;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.newsshots.model.Article;
import com.example.newsshots.model.NewsPojoRes;

import java.util.List;

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder> {
    Activity context;
    List<Article> list;

    public NewsRecyclerAdapter(Activity context, List<Article> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = context.getLayoutInflater().inflate(R.layout.news_item_design, viewGroup, false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Article pojoData = list.get(i);
        viewHolder.headline.setText(pojoData.getTitle());
        viewHolder.newsDescription.setText(pojoData.getDescription());
        viewHolder.newsUrl.setText(pojoData.getUrl());
        Glide.with(context).load(pojoData.getUrlToImage()).into(viewHolder.newsIcon);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView headline,newsDescription,newsUrl;
        ImageView newsIcon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            headline=itemView.findViewById(R.id.headline);
            newsDescription=itemView.findViewById(R.id.newsDiscription);
            newsUrl=itemView.findViewById(R.id.newsUrl);
            newsIcon=itemView.findViewById(R.id.newsIcon);
        }
    }
}
