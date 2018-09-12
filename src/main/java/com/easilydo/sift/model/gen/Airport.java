
package com.easilydo.sift.model.gen;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * Airport
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "iataCode",
    "name",
    "x-cityName",
    "x-destination",
    "x-rawName"
})
public class Airport {

    @JsonProperty("iataCode")
    private String iataCode;
    @JsonProperty("name")
    private String name;
    @JsonProperty("x-cityName")
    private String cityName;
    @JsonProperty("x-destination")
    private Boolean destination;
    @JsonProperty("x-rawName")
    private String rawName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The iataCode
     */
    @JsonProperty("iataCode")
    public String getIataCode() {
        return iataCode;
    }

    /**
     * 
     * @param iataCode
     *     The iataCode
     */
    @JsonProperty("iataCode")
    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The cityName
     */
    @JsonProperty("x-cityName")
    public String getCityName() {
        return cityName;
    }

    /**
     * 
     * @param cityName
     *     The cityName
     */
    @JsonProperty("x-cityName")
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * 
     * @return
     *     The destination
     */
    @JsonProperty("x-destination")
    public Boolean getDestination() {
        return destination;
    }

    /**
     * 
     * @param destination
     *     The destination
     */
    @JsonProperty("x-destination")
    public void setDestination(Boolean destination) {
        this.destination = destination;
    }

    /**
     * 
     * @return
     *     The rawName
     */
    @JsonProperty("x-rawName")
    public String getRawName() {
        return rawName;
    }

    /**
     * 
     * @param rawName
     *     The rawName
     */
    @JsonProperty("x-rawName")
    public void setRawName(String rawName) {
        this.rawName = rawName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(iataCode).append(name).append(cityName).append(destination).append(rawName).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Airport) == false) {
            return false;
        }
        Airport rhs = ((Airport) other);
        return new EqualsBuilder().append(iataCode, rhs.iataCode).append(name, rhs.name).append(cityName, rhs.cityName).append(destination, rhs.destination).append(rawName, rhs.rawName).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
