package com.example.rssdata.repository;

import com.example.rssdata.model.dao.RssItemDAO;

import java.util.List;

import rx.Observable;

/**
 * Created by Aleksandr on 12.08.2016 in RssFeed.
 * Interface that represents a data repository from where data is retrieved.
 */
public interface RssDataRepository {

    /**
     * Get an {@link rx.Observable} which will emit a List of {@link RssItemDAO}.
     */
    Observable<List<RssItemDAO>> getRssList();
}
