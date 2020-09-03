package com.example.pav.notaboutlovenews;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class NewsItemLoader extends AsyncTaskLoader<List<NewsItem>> {

    private static final String LOG_TAG = NewsItemLoader.class.getName();
    private String mUrl;

    public NewsItemLoader(Context context, String url){
        super(context);
        mUrl = url;
    }

    protected void onStartLoading(){ forceLoad(); }

    @Override
    public List<NewsItem> loadInBackground() {
        if (mUrl == null){
            return null;
        }

        List<NewsItem> newsItems = QueryUtils.fetchNewsItemData(mUrl);
        return newsItems;
    }
}
