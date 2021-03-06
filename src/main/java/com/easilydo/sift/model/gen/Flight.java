
package com.easilydo.sift.model.gen;

import java.util.Date;
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
 * Flight
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "aircraft",
    "arrivalAirport",
    "arrivalTerminal",
    "arrivalTime",
    "departureAirport",
    "departureTerminal",
    "departureTime",
    "flightNumber",
    "seller",
    "departureGate"
})
public class Flight {

    @JsonProperty("aircraft")
    private String aircraft;
    /**
     * Airport
     * <p>
     * 
     * 
     */
    @JsonProperty("arrivalAirport")
    private Airport arrivalAirport;
    @JsonProperty("arrivalTerminal")
    private String arrivalTerminal;
    @JsonProperty("arrivalTime")
    private Date arrivalTime;
    /**
     * Airport
     * <p>
     * 
     * 
     */
    @JsonProperty("departureAirport")
    private Airport departureAirport;
    @JsonProperty("departureTerminal")
    private String departureTerminal;
    @JsonProperty("departureTime")
    private Date departureTime;
    @JsonProperty("flightNumber")
    private String flightNumber;
    /**
     * Airline
     * <p>
     * 
     * 
     */
    @JsonProperty("seller")
    private Airline seller;
    @JsonProperty("departureGate")
    private String departureGate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The aircraft
     */
    @JsonProperty("aircraft")
    public String getAircraft() {
        return aircraft;
    }

    /**
     * 
     * @param aircraft
     *     The aircraft
     */
    @JsonProperty("aircraft")
    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    /**
     * Airport
     * <p>
     * 
     * 
     * @return
     *     The arrivalAirport
     */
    @JsonProperty("arrivalAirport")
    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    /**
     * Airport
     * <p>
     * 
     * 
     * @param arrivalAirport
     *     The arrivalAirport
     */
    @JsonProperty("arrivalAirport")
    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    /**
     * 
     * @return
     *     The arrivalTerminal
     */
    @JsonProperty("arrivalTerminal")
    public String getArrivalTerminal() {
        return arrivalTerminal;
    }

    /**
     * 
     * @param arrivalTerminal
     *     The arrivalTerminal
     */
    @JsonProperty("arrivalTerminal")
    public void setArrivalTerminal(String arrivalTerminal) {
        this.arrivalTerminal = arrivalTerminal;
    }

    /**
     * 
     * @return
     *     The arrivalTime
     */
    @JsonProperty("arrivalTime")
    public Date getArrivalTime() {
        return arrivalTime;
    }

    /**
     * 
     * @param arrivalTime
     *     The arrivalTime
     */
    @JsonProperty("arrivalTime")
    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * Airport
     * <p>
     * 
     * 
     * @return
     *     The departureAirport
     */
    @JsonProperty("departureAirport")
    public Airport getDepartureAirport() {
        return departureAirport;
    }

    /**
     * Airport
     * <p>
     * 
     * 
     * @param departureAirport
     *     The departureAirport
     */
    @JsonProperty("departureAirport")
    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    /**
     * 
     * @return
     *     The departureTerminal
     */
    @JsonProperty("departureTerminal")
    public String getDepartureTerminal() {
        return departureTerminal;
    }

    /**
     * 
     * @param departureTerminal
     *     The departureTerminal
     */
    @JsonProperty("departureTerminal")
    public void setDepartureTerminal(String departureTerminal) {
        this.departureTerminal = departureTerminal;
    }

    /**
     * 
     * @return
     *     The departureTime
     */
    @JsonProperty("departureTime")
    public Date getDepartureTime() {
        return departureTime;
    }

    /**
     * 
     * @param departureTime
     *     The departureTime
     */
    @JsonProperty("departureTime")
    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * 
     * @return
     *     The flightNumber
     */
    @JsonProperty("flightNumber")
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * 
     * @param flightNumber
     *     The flightNumber
     */
    @JsonProperty("flightNumber")
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     * Airline
     * <p>
     * 
     * 
     * @return
     *     The seller
     */
    @JsonProperty("seller")
    public Airline getSeller() {
        return seller;
    }

    /**
     * Airline
     * <p>
     * 
     * 
     * @param seller
     *     The seller
     */
    @JsonProperty("seller")
    public void setSeller(Airline seller) {
        this.seller = seller;
    }

    /**
     * 
     * @return
     *     The departureGate
     */
    @JsonProperty("departureGate")
    public String getDepartureGate() {
        return departureGate;
    }

    /**
     * 
     * @param departureGate
     *     The departureGate
     */
    @JsonProperty("departureGate")
    public void setDepartureGate(String departureGate) {
        this.departureGate = departureGate;
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
        return new HashCodeBuilder().append(aircraft).append(arrivalAirport).append(arrivalTerminal).append(arrivalTime).append(departureAirport).append(departureTerminal).append(departureTime).append(flightNumber).append(seller).append(departureGate).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Flight) == false) {
            return false;
        }
        Flight rhs = ((Flight) other);
        return new EqualsBuilder().append(aircraft, rhs.aircraft).append(arrivalAirport, rhs.arrivalAirport).append(arrivalTerminal, rhs.arrivalTerminal).append(arrivalTime, rhs.arrivalTime).append(departureAirport, rhs.departureAirport).append(departureTerminal, rhs.departureTerminal).append(departureTime, rhs.departureTime).append(flightNumber, rhs.flightNumber).append(seller, rhs.seller).append(departureGate, rhs.departureGate).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
