
package com.easilydo.sift.model.gen;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

import com.easilydo.sift.model.Sift;

/**
 * LodgingReservation
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "arrivalLocation",
    "arrivalTime",
    "broker",
    "departLocation",
    "departureTime",
    "reservationFor",
    "reservationId",
    "reservationStatus",
    "reservedTicket",
    "checkinTime",
    "checkoutTime"
})
public class LodgingReservation extends Sift {

    /**
     * Place
     * <p>
     * 
     * 
     */
    @JsonProperty("arrivalLocation")
    private Place arrivalLocation;
    @JsonProperty("arrivalTime")
    private Date arrivalTime;
    /**
     * Organization
     * <p>
     * 
     * 
     */
    @JsonProperty("broker")
    private Organization broker;
    /**
     * Place
     * <p>
     * 
     * 
     */
    @JsonProperty("departLocation")
    private Place departLocation;
    @JsonProperty("departureTime")
    private Date departureTime;
    /**
     * LodgingBusiness
     * <p>
     * 
     * 
     */
    @JsonProperty("reservationFor")
    private LodgingBusiness reservationFor;
    @JsonProperty("reservationId")
    private String reservationId;
    /**
     * ReservationStatus
     * <p>
     * 
     * 
     */
    @JsonProperty("reservationStatus")
    private ReservationStatus reservationStatus;
    @JsonProperty("reservedTicket")
    private List<Ticket> reservedTicket = new ArrayList<Ticket>();
    @JsonProperty("checkinTime")
    private Date checkinTime;
    @JsonProperty("checkoutTime")
    private Date checkoutTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Place
     * <p>
     * 
     * 
     * @return
     *     The arrivalLocation
     */
    @JsonProperty("arrivalLocation")
    public Place getArrivalLocation() {
        return arrivalLocation;
    }

    /**
     * Place
     * <p>
     * 
     * 
     * @param arrivalLocation
     *     The arrivalLocation
     */
    @JsonProperty("arrivalLocation")
    public void setArrivalLocation(Place arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
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
     * Organization
     * <p>
     * 
     * 
     * @return
     *     The broker
     */
    @JsonProperty("broker")
    public Organization getBroker() {
        return broker;
    }

    /**
     * Organization
     * <p>
     * 
     * 
     * @param broker
     *     The broker
     */
    @JsonProperty("broker")
    public void setBroker(Organization broker) {
        this.broker = broker;
    }

    /**
     * Place
     * <p>
     * 
     * 
     * @return
     *     The departLocation
     */
    @JsonProperty("departLocation")
    public Place getDepartLocation() {
        return departLocation;
    }

    /**
     * Place
     * <p>
     * 
     * 
     * @param departLocation
     *     The departLocation
     */
    @JsonProperty("departLocation")
    public void setDepartLocation(Place departLocation) {
        this.departLocation = departLocation;
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
     * LodgingBusiness
     * <p>
     * 
     * 
     * @return
     *     The reservationFor
     */
    @JsonProperty("reservationFor")
    public LodgingBusiness getReservationFor() {
        return reservationFor;
    }

    /**
     * LodgingBusiness
     * <p>
     * 
     * 
     * @param reservationFor
     *     The reservationFor
     */
    @JsonProperty("reservationFor")
    public void setReservationFor(LodgingBusiness reservationFor) {
        this.reservationFor = reservationFor;
    }

    /**
     * 
     * @return
     *     The reservationId
     */
    @JsonProperty("reservationId")
    public String getReservationId() {
        return reservationId;
    }

    /**
     * 
     * @param reservationId
     *     The reservationId
     */
    @JsonProperty("reservationId")
    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    /**
     * ReservationStatus
     * <p>
     * 
     * 
     * @return
     *     The reservationStatus
     */
    @JsonProperty("reservationStatus")
    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    /**
     * ReservationStatus
     * <p>
     * 
     * 
     * @param reservationStatus
     *     The reservationStatus
     */
    @JsonProperty("reservationStatus")
    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    /**
     * 
     * @return
     *     The reservedTicket
     */
    @JsonProperty("reservedTicket")
    public List<Ticket> getReservedTicket() {
        return reservedTicket;
    }

    /**
     * 
     * @param reservedTicket
     *     The reservedTicket
     */
    @JsonProperty("reservedTicket")
    public void setReservedTicket(List<Ticket> reservedTicket) {
        this.reservedTicket = reservedTicket;
    }

    /**
     * 
     * @return
     *     The checkinTime
     */
    @JsonProperty("checkinTime")
    public Date getCheckinTime() {
        return checkinTime;
    }

    /**
     * 
     * @param checkinTime
     *     The checkinTime
     */
    @JsonProperty("checkinTime")
    public void setCheckinTime(Date checkinTime) {
        this.checkinTime = checkinTime;
    }

    /**
     * 
     * @return
     *     The checkoutTime
     */
    @JsonProperty("checkoutTime")
    public Date getCheckoutTime() {
        return checkoutTime;
    }

    /**
     * 
     * @param checkoutTime
     *     The checkoutTime
     */
    @JsonProperty("checkoutTime")
    public void setCheckoutTime(Date checkoutTime) {
        this.checkoutTime = checkoutTime;
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
        return new HashCodeBuilder().append(arrivalLocation).append(arrivalTime).append(broker).append(departLocation).append(departureTime).append(reservationFor).append(reservationId).append(reservationStatus).append(reservedTicket).append(checkinTime).append(checkoutTime).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LodgingReservation) == false) {
            return false;
        }
        LodgingReservation rhs = ((LodgingReservation) other);
        return new EqualsBuilder().append(arrivalLocation, rhs.arrivalLocation).append(arrivalTime, rhs.arrivalTime).append(broker, rhs.broker).append(departLocation, rhs.departLocation).append(departureTime, rhs.departureTime).append(reservationFor, rhs.reservationFor).append(reservationId, rhs.reservationId).append(reservationStatus, rhs.reservationStatus).append(reservedTicket, rhs.reservedTicket).append(checkinTime, rhs.checkinTime).append(checkoutTime, rhs.checkoutTime).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
