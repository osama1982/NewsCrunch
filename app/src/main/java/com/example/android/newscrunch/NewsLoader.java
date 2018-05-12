package com.example.android.newscrunch;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<NewsItem>> {

    /**
     * Tag for log messages
     */
    private static final String LOG_TAG = NewsLoader.class.getName();

    String newsResourceUrl;

    /*
    Call loader custom constructor NewsLoader, pass the context to super class
    AsyncTaskLoader and store the passed url to be used
    in the loadInBackground method
    */
    public NewsLoader(Context context, String url) {
        super(context);
        newsResourceUrl = url;
    }

    //Force loading the when the loader starts
    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /*
    Start data fetching the background process and return the populated list
    to the overridden onLoadFinished method in NewsCrunchActivity
    */
    @Override
    public List<NewsItem> loadInBackground() {
        if (newsResourceUrl == null) {
            return null;
        }
        List<NewsItem> result = QueryUtils.fetchNewsItemsData(newsResourceUrl);
        return result;
    }
}
