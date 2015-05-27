package com.example.kaite.fragmentbestpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kaite on 2015/5/27.
 */
public class NewsAdapter extends ArrayAdapter<News> {
    int mResourceId = 0;
    List<News> mNewsList;

    public NewsAdapter(Context context, int resource, List<News> objects) {
        super(context, resource, objects);
        mResourceId = resource;
        mNewsList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News news = mNewsList.get(position);
        View v;
        ViewHolder viewHolder;
        if (convertView == null) {
            v = LayoutInflater.from(getContext()).inflate(R.layout.news_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.newsTitle = (TextView) v.findViewById(R.id.news_title);
            v.setTag(viewHolder);
        } else {
            v = convertView;
            viewHolder = (ViewHolder) v.getTag();

        }

        viewHolder.newsTitle.setText(news.getTitle());

        return v;
    }


    class ViewHolder {
        public TextView newsTitle;
    }
}
