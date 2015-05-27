package com.example.kaite.fragmentbestpractice;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kaite on 2015/5/27.
 */
public class NewContentFragment extends Fragment {

    View mView;
    TextView mNewsTitle;
    TextView mNewsContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_news_content, container, false);
        mNewsTitle = (TextView) mView.findViewById(R.id.news_title);
        mNewsContent = (TextView) mView.findViewById(R.id.news_content);
        return mView;
    }

    public void refresh(String newsTitle, String newsContent) {
        View visibilityLayout= getActivity().findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);

        //visibility_layout
        mNewsTitle.setText(newsTitle);
        mNewsContent.setText(newsContent);
    }
}
