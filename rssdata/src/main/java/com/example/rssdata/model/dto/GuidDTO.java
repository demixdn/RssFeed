package com.example.rssdata.model.dto;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

/**
 * Created by Aleksandr on 11.08.2016 in RssFeed.
 */
public class GuidDTO {

    @Attribute(name = "isPermaLink", required = false)
    private boolean isPermaLink;

    @Text
    private float value;

    public GuidDTO() {
    }

    public boolean isPermaLink() {
        return isPermaLink;
    }

    public void setPermaLink(boolean permaLink) {
        isPermaLink = permaLink;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GuidDTO{");
        sb.append("isPermaLink=").append(isPermaLink);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
