package com.example.rssdata.model.dao;

/**
 * Created by Aleksandr on 11.08.2016 in RssFeed.
 */
public class ChannelDAO {

    private String title;
    private String language;
    private long buildTime;
    private String imageUrl;

    public ChannelDAO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public long getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(long buildTime) {
        this.buildTime = buildTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ChannelDAO{");
        sb.append("title='").append(title).append('\'');
        sb.append(", language='").append(language).append('\'');
        sb.append(", buildTime=").append(buildTime);
        sb.append(", imageUrl='").append(imageUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
