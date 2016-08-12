package com.example.rssdata.model.dto;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Aleksandr on 12.08.2016 in RssFeed.
 */
@Root(name = "rss")
public class RssDTO {
    @Attribute(name = "xmlns:cbc", required = false)
    private String cbc;

    @Attribute(name = "version", required = false)
    private float version;

    @Element(name = "channel")
    private ChannelDTO channelDTO;

    public RssDTO() {
    }

    public String getCbc() {
        return cbc;
    }

    public void setCbc(String cbc) {
        this.cbc = cbc;
    }

    public float getVersion() {
        return version;
    }

    public void setVersion(float version) {
        this.version = version;
    }

    public ChannelDTO getChannelDTO() {
        return channelDTO;
    }

    public void setChannelDTO(ChannelDTO channelDTO) {
        this.channelDTO = channelDTO;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RssDTO{");
        sb.append("cbc='").append(cbc).append('\'');
        sb.append(", version=").append(version);
        sb.append(", channelDTO=").append(channelDTO);
        sb.append('}');
        return sb.toString();
    }
}
