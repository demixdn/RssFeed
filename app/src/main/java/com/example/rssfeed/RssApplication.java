package com.example.rssfeed;

import android.app.Application;

import com.example.rssdata.repository.RssDataLoader;
import com.example.rssdata.repository.RssDataRepository;

/**
 * Created by Aleksandr on 12.08.2016 in RssFeed.
 */
public class RssApplication extends Application {

    private static RssApplication instance;

    public static RssApplication getInstance(){
        return instance;
    }

    private RssDataRepository dataRepository;

    public RssDataRepository getDataRepository() {
        return dataRepository;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        instance = this;
        dataRepository = new RssDataLoader();
    }
}
