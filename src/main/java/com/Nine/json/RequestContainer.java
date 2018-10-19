
package com.Nine.json;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
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
    "payload",
    "skip",
    "take",
    "totalRecords"
})
public class RequestContainer implements Serializable
{

    @JsonProperty("payload")
    @Valid
    private List<Payload> payload = null;
    @JsonProperty("skip")
    private Integer skip;
    @JsonProperty("take")
    private Integer take;
    @JsonProperty("totalRecords")
    private Integer totalRecords;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6992888552820485550L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RequestContainer() {
    }

    /**
     * 
     * @param take
     * @param payload
     * @param totalRecords
     * @param skip
     */
    public RequestContainer(List<Payload> payload, Integer skip, Integer take, Integer totalRecords) {
        super();
        this.payload = payload;
        this.skip = skip;
        this.take = take;
        this.totalRecords = totalRecords;
    }

    @JsonProperty("payload")
    public List<Payload> getPayload() {
        return payload;
    }

    @JsonProperty("payload")
    public void setPayload(List<Payload> payload) {
        this.payload = payload;
    }

    public RequestContainer withPayload(List<Payload> payload) {
        this.payload = payload;
        return this;
    }

    @JsonProperty("skip")
    public Integer getSkip() {
        return skip;
    }

    @JsonProperty("skip")
    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    public RequestContainer withSkip(Integer skip) {
        this.skip = skip;
        return this;
    }

    @JsonProperty("take")
    public Integer getTake() {
        return take;
    }

    @JsonProperty("take")
    public void setTake(Integer take) {
        this.take = take;
    }

    public RequestContainer withTake(Integer take) {
        this.take = take;
        return this;
    }

    @JsonProperty("totalRecords")
    public Integer getTotalRecords() {
        return totalRecords;
    }

    @JsonProperty("totalRecords")
    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public RequestContainer withTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
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

    public RequestContainer withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(take).append(payload).append(totalRecords).append(skip).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RequestContainer) == false) {
            return false;
        }
        RequestContainer rhs = ((RequestContainer) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(take, rhs.take).append(payload, rhs.payload).append(totalRecords, rhs.totalRecords).append(skip, rhs.skip).isEquals();
    }

}
