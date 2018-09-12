
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
 * LodgingBusiness
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "description",
    "name",
    "x-category",
    "x-days",
    "x-deck",
    "x-ship",
    "x-stateroom",
    "address",
    "telephone",
    "x-rewardsLevel",
    "x-roomType",
    "x-rooms"
})
public class LodgingBusiness {

    @JsonProperty("description")
    private String description;
    @JsonProperty("name")
    private String name;
    @JsonProperty("x-category")
    private String category;
    @JsonProperty("x-days")
    private String days;
    @JsonProperty("x-deck")
    private String deck;
    @JsonProperty("x-ship")
    private String ship;
    @JsonProperty("x-stateroom")
    private String stateroom;
    @JsonProperty("address")
    private String address;
    @JsonProperty("telephone")
    private String telephone;
    @JsonProperty("x-rewardsLevel")
    private String rewardsLevel;
    @JsonProperty("x-roomType")
    private String roomType;
    @JsonProperty("x-rooms")
    private String rooms;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
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
     *     The category
     */
    @JsonProperty("x-category")
    public String getCategory() {
        return category;
    }

    /**
     * 
     * @param category
     *     The category
     */
    @JsonProperty("x-category")
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 
     * @return
     *     The days
     */
    @JsonProperty("x-days")
    public String getDays() {
        return days;
    }

    /**
     * 
     * @param days
     *     The days
     */
    @JsonProperty("x-days")
    public void setDays(String days) {
        this.days = days;
    }

    /**
     * 
     * @return
     *     The deck
     */
    @JsonProperty("x-deck")
    public String getDeck() {
        return deck;
    }

    /**
     * 
     * @param deck
     *     The deck
     */
    @JsonProperty("x-deck")
    public void setDeck(String deck) {
        this.deck = deck;
    }

    /**
     * 
     * @return
     *     The ship
     */
    @JsonProperty("x-ship")
    public String getShip() {
        return ship;
    }

    /**
     * 
     * @param ship
     *     The ship
     */
    @JsonProperty("x-ship")
    public void setShip(String ship) {
        this.ship = ship;
    }

    /**
     * 
     * @return
     *     The stateroom
     */
    @JsonProperty("x-stateroom")
    public String getStateroom() {
        return stateroom;
    }

    /**
     * 
     * @param stateroom
     *     The stateroom
     */
    @JsonProperty("x-stateroom")
    public void setStateroom(String stateroom) {
        this.stateroom = stateroom;
    }

    /**
     * 
     * @return
     *     The address
     */
    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */
    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 
     * @return
     *     The telephone
     */
    @JsonProperty("telephone")
    public String getTelephone() {
        return telephone;
    }

    /**
     * 
     * @param telephone
     *     The telephone
     */
    @JsonProperty("telephone")
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 
     * @return
     *     The rewardsLevel
     */
    @JsonProperty("x-rewardsLevel")
    public String getRewardsLevel() {
        return rewardsLevel;
    }

    /**
     * 
     * @param rewardsLevel
     *     The rewardsLevel
     */
    @JsonProperty("x-rewardsLevel")
    public void setRewardsLevel(String rewardsLevel) {
        this.rewardsLevel = rewardsLevel;
    }

    /**
     * 
     * @return
     *     The roomType
     */
    @JsonProperty("x-roomType")
    public String getRoomType() {
        return roomType;
    }

    /**
     * 
     * @param roomType
     *     The roomType
     */
    @JsonProperty("x-roomType")
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    /**
     * 
     * @return
     *     The rooms
     */
    @JsonProperty("x-rooms")
    public String getRooms() {
        return rooms;
    }

    /**
     * 
     * @param rooms
     *     The rooms
     */
    @JsonProperty("x-rooms")
    public void setRooms(String rooms) {
        this.rooms = rooms;
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
        return new HashCodeBuilder().append(description).append(name).append(category).append(days).append(deck).append(ship).append(stateroom).append(address).append(telephone).append(rewardsLevel).append(roomType).append(rooms).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LodgingBusiness) == false) {
            return false;
        }
        LodgingBusiness rhs = ((LodgingBusiness) other);
        return new EqualsBuilder().append(description, rhs.description).append(name, rhs.name).append(category, rhs.category).append(days, rhs.days).append(deck, rhs.deck).append(ship, rhs.ship).append(stateroom, rhs.stateroom).append(address, rhs.address).append(telephone, rhs.telephone).append(rewardsLevel, rhs.rewardsLevel).append(roomType, rhs.roomType).append(rooms, rhs.rooms).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
