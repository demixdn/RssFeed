package com.example.rssdata.net;

import com.example.rssdata.model.dto.RssDTO;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Aleksandr on 11.08.2016 in RssFeed.
 *  Interface that represents a rss feed api.
 */
public interface RssFeedAPI {

    @GET("cmlink/rss-topstories")
    Observable<RssDTO> getChannelTop();
}
