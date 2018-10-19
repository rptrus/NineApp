
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
    "country",
    "description",
    "drm",
    "episodeCount",
    "genre",
    "image",
    "language",
    "nextEpisode",
    "primaryColour",
    "seasons",
    "slug",
    "title",
    "tvChannel"
})
public class Payload implements Serializable
{

    @JsonProperty("country")
    private String country;
    @JsonProperty("description")
    private String description;
    @JsonProperty("drm")
    private Boolean drm;
    @JsonProperty("episodeCount")
    private Integer episodeCount;
    @JsonProperty("genre")
    private String genre;
    @JsonProperty("image")
    @Valid
    private Image image;
    @JsonProperty("language")
    private String language;
    @JsonProperty("nextEpisode")
    @Valid
    private NextEpisode nextEpisode;
    @JsonProperty("primaryColour")
    private String primaryColour;
    @JsonProperty("seasons")
    private Object seasons;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("title")
    private String title;
    @JsonProperty("tvChannel")
    private String tvChannel;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -7716822219902928152L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Payload() {
    }

    /**
     * 
     * @param genre
     * @param episodeCount
     * @param image
     * @param country
     * @param nextEpisode
     * @param title
     * @param tvChannel
     * @param drm
     * @param seasons
     * @param description
     * @param slug
     * @param language
     * @param primaryColour
     */
    public Payload(String country, String description, Boolean drm, Integer episodeCount, String genre, Image image, String language, NextEpisode nextEpisode, String primaryColour, Object seasons, String slug, String title, String tvChannel) {
        super();
        this.country = country;
        this.description = description;
        this.drm = drm;
        this.episodeCount = episodeCount;
        this.genre = genre;
        this.image = image;
        this.language = language;
        this.nextEpisode = nextEpisode;
        this.primaryColour = primaryColour;
        this.seasons = seasons;
        this.slug = slug;
        this.title = title;
        this.tvChannel = tvChannel;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    public Payload withCountry(String country) {
        this.country = country;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Payload withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("drm")
    public Boolean getDrm() {
        return drm;
    }

    @JsonProperty("drm")
    public void setDrm(Boolean drm) {
        this.drm = drm;
    }

    public Payload withDrm(Boolean drm) {
        this.drm = drm;
        return this;
    }

    @JsonProperty("episodeCount")
    public Integer getEpisodeCount() {
        return episodeCount;
    }

    @JsonProperty("episodeCount")
    public void setEpisodeCount(Integer episodeCount) {
        this.episodeCount = episodeCount;
    }

    public Payload withEpisodeCount(Integer episodeCount) {
        this.episodeCount = episodeCount;
        return this;
    }

    @JsonProperty("genre")
    public String getGenre() {
        return genre;
    }

    @JsonProperty("genre")
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Payload withGenre(String genre) {
        this.genre = genre;
        return this;
    }

    @JsonProperty("image")
    public Image getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
    }

    public Payload withImage(Image image) {
        this.image = image;
        return this;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    public Payload withLanguage(String language) {
        this.language = language;
        return this;
    }

    @JsonProperty("nextEpisode")
    public NextEpisode getNextEpisode() {
        return nextEpisode;
    }

    @JsonProperty("nextEpisode")
    public void setNextEpisode(NextEpisode nextEpisode) {
        this.nextEpisode = nextEpisode;
    }

    public Payload withNextEpisode(NextEpisode nextEpisode) {
        this.nextEpisode = nextEpisode;
        return this;
    }

    @JsonProperty("primaryColour")
    public String getPrimaryColour() {
        return primaryColour;
    }

    @JsonProperty("primaryColour")
    public void setPrimaryColour(String primaryColour) {
        this.primaryColour = primaryColour;
    }

    public Payload withPrimaryColour(String primaryColour) {
        this.primaryColour = primaryColour;
        return this;
    }

    @JsonProperty("seasons")
    public Object getSeasons() {
        return seasons;
    }

    @JsonProperty("seasons")
    public void setSeasons(Object seasons) {
        this.seasons = seasons;
    }

    public Payload withSeasons(Object seasons) {
        this.seasons = seasons;
        return this;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Payload withSlug(String slug) {
        this.slug = slug;
        return this;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Payload withTitle(String title) {
        this.title = title;
        return this;
    }

    @JsonProperty("tvChannel")
    public String getTvChannel() {
        return tvChannel;
    }

    @JsonProperty("tvChannel")
    public void setTvChannel(String tvChannel) {
        this.tvChannel = tvChannel;
    }

    public Payload withTvChannel(String tvChannel) {
        this.tvChannel = tvChannel;
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

    public Payload withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(genre).append(episodeCount).append(image).append(country).append(title).append(nextEpisode).append(tvChannel).append(drm).append(seasons).append(additionalProperties).append(description).append(slug).append(language).append(primaryColour).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Payload) == false) {
            return false;
        }
        Payload rhs = ((Payload) other);
        return new EqualsBuilder().append(genre, rhs.genre).append(episodeCount, rhs.episodeCount).append(image, rhs.image).append(country, rhs.country).append(title, rhs.title).append(nextEpisode, rhs.nextEpisode).append(tvChannel, rhs.tvChannel).append(drm, rhs.drm).append(seasons, rhs.seasons).append(additionalProperties, rhs.additionalProperties).append(description, rhs.description).append(slug, rhs.slug).append(language, rhs.language).append(primaryColour, rhs.primaryColour).isEquals();
    }

}
