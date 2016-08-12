package com.example.rssfeed.data.model;

/**
 * Created by Aleksandr on 12.08.2016 in RssFeed.
 */
public class RssItem {
    private String title;
    private String  pubTime;
    private String author;
    private String imageUrl;
    private int imageWidth;
    private int imageHeight;
    private String link;

    public RssItem() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RssItem rssItem = (RssItem) o;

        if (!title.equals(rssItem.title)) return false;
        if (!author.equals(rssItem.author)) return false;
        return link.equals(rssItem.link);

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + link.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RssItem{");
        sb.append("title='").append(title).append('\'');
        sb.append(", pubTime='").append(pubTime).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", imageUrl='").append(imageUrl).append('\'');
        sb.append(", link='").append(link).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
