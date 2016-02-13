
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

import com.easilydo.sift.model.Domain;
import com.easilydo.sift.model.Sift;


/**
 * Invoice
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "confirmationNumber",
    "paymentStatus",
    "totalPaymentDue"
})
public class Invoice extends Sift {

    @JsonProperty("confirmationNumber")
    private String confirmationNumber;
    @JsonProperty("paymentStatus")
    private String paymentStatus;
    /**
     * PriceSpecification
     * <p>
     * 
     * 
     */
    @JsonProperty("totalPaymentDue")
    private PriceSpecification totalPaymentDue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Domain getDomain() {
        return Domain.BILL;
    }

    /**
     * 
     * @return
     *     The confirmationNumber
     */
    @JsonProperty("confirmationNumber")
    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    /**
     * 
     * @param confirmationNumber
     *     The confirmationNumber
     */
    @JsonProperty("confirmationNumber")
    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    /**
     * 
     * @return
     *     The paymentStatus
     */
    @JsonProperty("paymentStatus")
    public String getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * 
     * @param paymentStatus
     *     The paymentStatus
     */
    @JsonProperty("paymentStatus")
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    /**
     * PriceSpecification
     * <p>
     * 
     * 
     * @return
     *     The totalPaymentDue
     */
    @JsonProperty("totalPaymentDue")
    public PriceSpecification getTotalPaymentDue() {
        return totalPaymentDue;
    }

    /**
     * PriceSpecification
     * <p>
     * 
     * 
     * @param totalPaymentDue
     *     The totalPaymentDue
     */
    @JsonProperty("totalPaymentDue")
    public void setTotalPaymentDue(PriceSpecification totalPaymentDue) {
        this.totalPaymentDue = totalPaymentDue;
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
        return new HashCodeBuilder().append(confirmationNumber).append(paymentStatus).append(totalPaymentDue).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Invoice) == false) {
            return false;
        }
        Invoice rhs = ((Invoice) other);
        return new EqualsBuilder().append(confirmationNumber, rhs.confirmationNumber).append(paymentStatus, rhs.paymentStatus).append(totalPaymentDue, rhs.totalPaymentDue).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
