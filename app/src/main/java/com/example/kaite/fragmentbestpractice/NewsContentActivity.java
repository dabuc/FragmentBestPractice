package com.example.kaite.fragmentbestpractice;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by kaite on 2015/5/27.
 */
public class NewsContentActivity extends Activity {

    /**
     * @param context
     * @param newsTitle   新闻标题
     * @param newsContent 新闻内容
     */
    public static void actionStart(Context context, String newsTitle, String newsContent) {

        Intent i = new Intent(context, NewsContentActivity.class);
        i.putExtra("news_title", newsTitle);
        i.putExtra("news_content", newsContent);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_news_content);
        Intent i = getIntent();
        String newsTitle = i.getStringExtra("news_title");
        String newsContent = i.getStringExtra("news_content");
        NewContentFragment newContentFragment = (NewContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
        newContentFragment.refresh(newsTitle, newsContent);
    }
}
