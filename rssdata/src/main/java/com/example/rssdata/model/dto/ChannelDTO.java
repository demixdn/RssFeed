package com.example.rssdata.model.dto;

import android.support.annotation.Nullable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * Created by Aleksandr on 11.08.2016 in RssFeed.
 */
public class ChannelDTO {

    @Element(name = "title", data = true)
    private String title;

    @Element(name = "link")
    private String link;

    @Element(name = "description", data = true)
    private String description;

    @Element(name = "language")
    private String language;

    @Element(name = "lastBuildDate")
    private String lastBuildDate;

    @Element(name = "copyright", data = true)
    private String copyright;

    @Element(name = "docs", data = true)
    private String docs;

    @Element(name = "image")
    private ChannelImageDTO image;

    @ElementList(inline=true)
    private List<RssItemDTO> items;

    public ChannelDTO() {
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Nullable
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Nullable
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Nullable
    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    @Nullable
    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    @Nullable
    public String getDocs() {
        return docs;
    }

    public void setDocs(String docs) {
        this.docs = docs;
    }

    @Nullable
    public ChannelImageDTO getImage() {
        return image;
    }

    public void setImage(ChannelImageDTO image) {
        this.image = image;
    }

    @Nullable
    public List<RssItemDTO> getItems() {
        return items;
    }

    public void setItems(List<RssItemDTO> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ChannelDTO{");
        sb.append("title='").append(title).append('\'');
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
