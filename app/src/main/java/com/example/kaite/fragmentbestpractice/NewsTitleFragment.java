package com.example.kaite.fragmentbestpractice;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaite on 2015/5/27.
 */
public class NewsTitleFragment extends Fragment implements AdapterView.OnItemClickListener {
    private List<News> mNewsList;
    private ListView mNewsTitleListView;
    private NewsAdapter mNewsAdapter;
    private boolean isTwoPane;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mNewsList = getNews();
        mNewsAdapter = new NewsAdapter(activity, R.layout.news_item, mNewsList);

    }

    private List<News> getNews() {
        List<News> newsList = new ArrayList<>();
        News news1 = new News();
        news1.setTitle("Succeed in College as a Learning Disabled Student");
        news1.setContent("College freshmen will soon learn to live with a roommate, adjust to a new social scene and survive less-than-stellar dining hall food. Students with learning disabilities will face these transitions while also grappling with a few more hurdles.");
        newsList.add(news1);
        News news2 = new News();
        news2.setTitle("Google Android exec poached by China's Xiaomi");
        news2.setContent("China's Xiaomi has poached a key Google executive involved in the tech giant's Android phones, in a move seen as a coup for the rapidly growing Chinese smartphone maker.");
        newsList.add(news2);
        return newsList;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_new_title, container, false);
        mNewsTitleListView = (ListView) v.findViewById(R.id.news_title_list_view);
        mNewsTitleListView.setAdapter(mNewsAdapter);
        mNewsTitleListView.setOnItemClickListener(this);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.new_content_layout) == null) {
            isTwoPane = false;//单屏显示
        } else {
            isTwoPane = true;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        News news = mNewsList.get(position);

        if (isTwoPane) {
            NewContentFragment newContentFragment = (NewContentFragment) getActivity().getFragmentManager().findFragmentById(R.id.news_content_frag_for_large);
            newContentFragment.refresh(news.getTitle(), news.getContent());
        } else {
            NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
        }

    }
}
