package com.example.rssdata.repository;

import com.example.rssdata.DataConst;
import com.example.rssdata.model.ModelMapper;
import com.example.rssdata.model.dao.RssItemDAO;
import com.example.rssdata.model.dto.RssDTO;
import com.example.rssdata.net.ApiModule;
import com.example.rssdata.net.RssFeedAPI;

import java.util.List;

import rx.Observable;

/**
 * Created by Aleksandr on 12.08.2016 in RssFeed.
 * {@link RssDataRepository} implementation based on network connections to the rss feed api.
 */
public class RssDataLoader implements RssDataRepository {

    private RssFeedAPI feedAPI;

    public RssDataLoader() {
        ApiModule apiModule = new ApiModule(DataConst.RSS_ENDPOINT);
        feedAPI = apiModule.provideApi();
    }

    @Override
    public Observable<List<RssItemDAO>> getRssList() {
        return feedAPI.getChannelTop().flatMap(this::transformListRx);
    }

    private Observable<List<RssItemDAO>> transformListRx(RssDTO rss){
        return Observable.defer(() -> Observable.just(ModelMapper.transformListFrom(rss.getChannelDTO())));
    }
}
