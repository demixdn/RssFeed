package com.example.rssfeed.data;

import com.example.rssdata.executor.JobExecutor;
import com.example.rssdata.model.dao.RssItemDAO;
import com.example.rssdata.repository.RssDataLoader;
import com.example.rssdata.repository.RssDataRepository;
import com.example.rssfeed.data.model.ModelMapper;
import com.example.rssfeed.data.model.RssItem;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func0;
import rx.schedulers.Schedulers;

/**
 * Created by Aleksandr on 12.08.2016 in RssFeed.
 */
public class DataManager {
    private static DataManager instance = new DataManager();

    public static DataManager getInstance() {
        return instance;
    }

    private RssDataRepository dataRepository;

    public RssDataRepository getDataRepository() {
        return dataRepository;
    }

    private DataManager() {
        dataRepository = new RssDataLoader();
    }

    public Observable<List<RssItemDAO>> getRssFeed(){
        return dataRepository.getRssList()
                .subscribeOn(Schedulers.from(JobExecutor.getInstance()))
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<List<RssItem>> listRssFrom(final List<RssItemDAO> source){
        return Observable.defer(new Func0<Observable<List<RssItem>>>() {
            @Override
            public Observable<List<RssItem>> call() {
                return Observable.just(ModelMapper.transformFrom(source));
            }
        });
    }
}
