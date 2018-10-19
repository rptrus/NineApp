
package com.Nine.json;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "channel",
    "channelLogo",
    "date",
    "html",
    "url"
})
public class NextEpisode implements Serializable
{

    @JsonProperty("channel")
    private Object channel;
    @JsonProperty("channelLogo")
    private String channelLogo;
    @JsonProperty("date")
    private Object date;
    @JsonProperty("html")
    private String html;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7718874271751461871L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NextEpisode() {
    }

    /**
     * 
     * @param channelLogo
     * @param html
     * @param date
     * @param channel
     * @param url
     */
    public NextEpisode(Object channel, String channelLogo, Object date, String html, String url) {
        super();
        this.channel = channel;
        this.channelLogo = channelLogo;
        this.date = date;
        this.html = html;
        this.url = url;
    }

    @JsonProperty("channel")
    public Object getChannel() {
        return channel;
    }

    @JsonProperty("channel")
    public void setChannel(Object channel) {
        this.channel = channel;
    }

    public NextEpisode withChannel(Object channel) {
        this.channel = channel;
        return this;
    }

    @JsonProperty("channelLogo")
    public String getChannelLogo() {
        return channelLogo;
    }

    @JsonProperty("channelLogo")
    public void setChannelLogo(String channelLogo) {
        this.channelLogo = channelLogo;
    }

    public NextEpisode withChannelLogo(String channelLogo) {
        this.channelLogo = channelLogo;
        return this;
    }

    @JsonProperty("date")
    public Object getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(Object date) {
        this.date = date;
    }

    public NextEpisode withDate(Object date) {
        this.date = date;
        return this;
    }

    @JsonProperty("html")
    public String getHtml() {
        return html;
    }

    @JsonProperty("html")
    public void setHtml(String html) {
        this.html = html;
    }

    public NextEpisode withHtml(String html) {
        this.html = html;
        return this;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    public NextEpisode withUrl(String url) {
        this.url = url;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public NextEpisode withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(channelLogo).append(html).append(date).append(channel).append(url).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NextEpisode) == false) {
            return false;
        }
        NextEpisode rhs = ((NextEpisode) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(channelLogo, rhs.channelLogo).append(html, rhs.html).append(date, rhs.date).append(channel, rhs.channel).append(url, rhs.url).isEquals();
    }

}
