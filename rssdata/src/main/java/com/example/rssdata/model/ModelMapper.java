package com.example.rssdata.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import com.example.rssdata.model.dao.ChannelDAO;
import com.example.rssdata.model.dao.RssItemDAO;
import com.example.rssdata.model.dto.ChannelDTO;
import com.example.rssdata.model.dto.RssItemDTO;
import com.example.rssdata.utils.TimeParserUtil;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Aleksandr on 11.08.2016 in RssFeed.
 * Mapper class used to transform {@link ChannelDTO} into an {@link ChannelDAO}
 * and {@link RssItemDTO} into an {@link RssItemDAO}
 */
public class ModelMapper {

    /**
     * Transform a {@link ChannelDTO} into an {@link ChannelDAO}
     * @param source Object to be transformed.
     * @return  {@link ChannelDAO} from {@link ChannelDTO}.
     */
    @NonNull
    public static ChannelDAO transformFrom(@NonNull ChannelDTO source){
        ChannelDAO result = new ChannelDAO();
        result.setTitle(source.getTitle());
        result.setLanguage(source.getLanguage());
        if (source.getImage() != null)
            result.setImageUrl(source.getImage().getUrl());
        try {
            if (TextUtils.isEmpty(source.getLastBuildDate()) || TextUtils.isEmpty(source.getLanguage()))
                throw new ParseException("go to catch", 0);
            result.setBuildTime(TimeParserUtil.rssTimeWithZoneFrom(source.getLastBuildDate(), source.getLanguage()));
        } catch (ParseException ignor) {
            Log.e("Exception", "Time parse exception in channel transformation");
            result.setBuildTime(System.currentTimeMillis());
        }
        return result;
    }

    /**
     * Transform a {@link RssItemDTO} into an {@link RssItemDAO}
     * @param source Object to be transformed.
     * @param lang Param for internal func
     * @return {@link RssItemDAO}
     */
    @NonNull
    public static RssItemDAO transformFrom(@NonNull RssItemDTO source, @Nullable String lang){
        RssItemDAO result = new RssItemDAO();
        result.setTitle(source.getTitle());
        result.setAuthor(source.getAuthor());
        result.setCategory(source.getCategory());
        result.setDescription(source.getDescription());
        result.setLink(source.getLink());
        try {
            if (TextUtils.isEmpty(source.getPubDate()) || TextUtils.isEmpty(lang))
                throw new ParseException("go to catch", 0);
            result.setPubTime(TimeParserUtil.rssTimeWithZoneFrom(source.getPubDate(), lang));
        } catch (ParseException ignor) {
            Log.e("Exception", "Time parse exception in rss item transformation");
            result.setPubTime(System.currentTimeMillis());
        }
        return result;
    }

    /**
     * Transform {@link ChannelDTO} into a List of {@link RssItemDAO}
     * @param channel Object to be transformed
     * @return List of {@link RssItemDAO} if valid {@link ChannelDTO} otherwise empty list.
     */
    @NonNull
    public static List<RssItemDAO> transformListFrom(@Nullable ChannelDTO channel){
        List<RssItemDAO> results = Collections.emptyList();
        if(channel != null) {
            results = new ArrayList<>();
            String lang = channel.getLanguage();
            List<RssItemDTO> source = channel.getItems();
            if(source != null && source.size() > 0)
                for (RssItemDTO source_item : source) {
                    RssItemDAO res_item = transformFrom(source_item, lang);
                    results.add(res_item);
                }
        }
        return results;
    }
}
