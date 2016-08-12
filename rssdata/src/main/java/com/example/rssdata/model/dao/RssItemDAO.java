package com.example.rssdata.model.dao;

/**
 * Created by Aleksandr on 11.08.2016 in RssFeed.
 */
public class RssItemDAO {

    private String title;
    private long pubTime;
    private String author;
    private String description;
    private String link;
    private String category;

    public RssItemDAO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPubTime() {
        return pubTime;
    }

    public void setPubTime(long pubTime) {
        this.pubTime = pubTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RssItemDAO that = (RssItemDAO) o;

        if (!title.equals(that.title)) return false;
        if (!author.equals(that.author)) return false;
        if (!link.equals(that.link)) return false;
        return category.equals(that.category);

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + link.hashCode();
        result = 31 * result + category.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RssItemDAO{");
        sb.append("title='").append(title).append('\'');
        sb.append(", pubTime=").append(pubTime);
        sb.append(", author='").append(author).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", link='").append(link).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
