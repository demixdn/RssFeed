package com.example.rssdata.model.dto;

import android.support.annotation.Nullable;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Aleksandr on 11.08.2016 in RssFeed.
 */
@Root(name = "item")
public class RssItemDTO {
    @Attribute(name = "type", required = false)
    private String type;

    @Attribute(name = "deptid", required = false)
    private float deptid;

    @Attribute(name = "syndicate", required = false)
    private boolean syndicate;

    @Element(name = "title", data = true)
    private String title;

    @Element(name = "link")
    private String link;

    @Element(name = "guid")
    private GuidDTO guid;

    @Element(name = "pubDate")
    private String pubDate;

    @Element(name = "author")
    private String author;

    @Element(name = "category")
    private String category;

    @Element(name = "description", data = true)
    private String description;

    public RssItemDTO() {
    }

    @Nullable
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getDeptid() {
        return deptid;
    }

    public void setDeptid(float deptid) {
        this.deptid = deptid;
    }

    public boolean isSyndicate() {
        return syndicate;
    }

    public void setSyndicate(boolean syndicate) {
        this.syndicate = syndicate;
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
    public GuidDTO getGuid() {
        return guid;
    }

    public void setGuid(GuidDTO guid) {
        this.guid = guid;
    }

    @Nullable
    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    @Nullable
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Nullable
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RssItemDTO that = (RssItemDTO) o;

        if (!title.equals(that.title)) return false;
        if (!link.equals(that.link)) return false;
        return author.equals(that.author);

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + link.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RssItemDTO{");
        sb.append("title='").append(title).append('\'');
        sb.append(", link='").append(link).append('\'');
        sb.append(", pubDate='").append(pubDate).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
