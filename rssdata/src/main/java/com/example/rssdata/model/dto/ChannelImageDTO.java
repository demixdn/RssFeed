package com.example.rssdata.model.dto;

import org.simpleframework.xml.Element;

/**
 * Created by Aleksandr on 11.08.2016 in RssFeed.
 */
public class ChannelImageDTO {
    @Element(name = "title")
    private String title;

    @Element(name = "link")
    private String link;

    @Element(name = "url")
    private String url;

    public ChannelImageDTO() {
    }

    public ChannelImageDTO(String title, String link, String url) {
        this.title = title;
        this.link = link;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ChannelImageDTO{");
        sb.append("title='").append(title).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
