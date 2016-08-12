package com.example.rssfeed.data.model;

import android.support.annotation.NonNull;

import com.example.rssdata.BuildConfig;
import com.example.rssdata.model.dao.RssItemDAO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Aleksandr on 12.08.2016 in RssFeed.
 * Mapper class used to transform {@link RssItemDAO} into an {@link RssItem}
 */
public class ModelMapper {

    @NonNull
    public static RssItem transformFrom(@NonNull RssItemDAO source){
        RssItem item = new RssItem();
        item.setTitle(source.getTitle());
        item.setLink(source.getLink());
        item.setAuthor(source.getAuthor());
        item.setPubTime(dateStringFrom(source.getPubTime()));
        try {
            item.setImageUrl(imageUrlFrom(source.getDescription()));
            item.setImageHeight(imageHeightFrom(source.getDescription()));
            item.setImageWidth(imageWidthFrom(source.getDescription()));
        }catch (IllegalArgumentException ignor){
            if(BuildConfig.DEBUG)
                ignor.printStackTrace();
        }
        return item;
    }

    @NonNull
    public static List<RssItem> transformFrom(List<RssItemDAO> sources){
        List<RssItem> results = Collections.emptyList();
        if(sources != null && sources.size()>0){
            results = new ArrayList<>();
            for(RssItemDAO source : sources)
                results.add(transformFrom(source));
        }
        return results;
    }

    private static String dateStringFrom(long millis){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yy", Locale.getDefault());
        return simpleDateFormat.format(new Date(millis));
    }

    /**
     * It retrieves the URL of the first image from the HTML Text
     * @param description Source html text
     * @return String with image url if found, otherwise empty string
     */
    private static String imageUrlFrom(String description){
        Document document = Jsoup.parse(description);
        Element imageElement = document.getElementsByTag("img").first();
        return imageElement.attr("src");
    }

    /**
     * It retrieves the width of the first image from the HTML Text
     * @param description Source html text
     * @return width of the first image
     * @throws NumberFormatException if not found 'width' attribute
     */
    private static int imageWidthFrom(String description) throws NumberFormatException {
        Document document = Jsoup.parse(description);
        Element imageElement = document.getElementsByTag("img").first();
        return Integer.decode(imageElement.attr("width"));
    }

    /**
     * It retrieves the height of the first image from the HTML Text
     * @param description Source html text
     * @return height of the first image
     * @throws NumberFormatException if not found 'height' attribute
     */
    private static int imageHeightFrom(String description) throws NumberFormatException {
        Document document = Jsoup.parse(description);
        Element imageElement = document.getElementsByTag("img").first();
        return Integer.decode(imageElement.attr("height"));
    }
}
