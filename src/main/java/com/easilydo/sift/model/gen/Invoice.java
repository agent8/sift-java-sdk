
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
    "accountId",
    "description",
    "paymentDueDate",
    "totalPaymentDue",
    "url",
    "x-accountBalance",
    "confirmationNumber",
    "paymentStatus",
    "x-balanceDue",
    "x-paymentMade"
})
public class Invoice extends Sift {

    @JsonProperty("accountId")
    private String accountId;
    @JsonProperty("description")
    private String description;
    @JsonProperty("paymentDueDate")
    private Date paymentDueDate;
    /**
     * PriceSpecification
     * <p>
     * 
     * 
     */
    @JsonProperty("totalPaymentDue")
    private PriceSpecification totalPaymentDue;
    @JsonProperty("url")
    private String url;
    @JsonProperty("x-accountBalance")
    private String accountBalance;
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
    @JsonProperty("x-balanceDue")
    private PriceSpecification balanceDue;
    /**
     * PriceSpecification
     * <p>
     * 
     * 
     */
    @JsonProperty("x-paymentMade")
    private PriceSpecification paymentMade;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The accountId
     */
    @JsonProperty("accountId")
    public String getAccountId() {
        return accountId;
    }

    /**
     * 
     * @param accountId
     *     The accountId
     */
    @JsonProperty("accountId")
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

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
     *     The paymentDueDate
     */
    @JsonProperty("paymentDueDate")
    public Date getPaymentDueDate() {
        return paymentDueDate;
    }

    /**
     * 
     * @param paymentDueDate
     *     The paymentDueDate
     */
    @JsonProperty("paymentDueDate")
    public void setPaymentDueDate(Date paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
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

    /**
     * 
     * @return
     *     The url
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The accountBalance
     */
    @JsonProperty("x-accountBalance")
    public String getAccountBalance() {
        return accountBalance;
    }

    /**
     * 
     * @param accountBalance
     *     The accountBalance
     */
    @JsonProperty("x-accountBalance")
    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
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
     *     The balanceDue
     */
    @JsonProperty("x-balanceDue")
    public PriceSpecification getBalanceDue() {
        return balanceDue;
    }

    /**
     * PriceSpecification
     * <p>
     * 
     * 
     * @param balanceDue
     *     The balanceDue
     */
    @JsonProperty("x-balanceDue")
    public void setBalanceDue(PriceSpecification balanceDue) {
        this.balanceDue = balanceDue;
    }

    /**
     * PriceSpecification
     * <p>
     * 
     * 
     * @return
     *     The paymentMade
     */
    @JsonProperty("x-paymentMade")
    public PriceSpecification getPaymentMade() {
        return paymentMade;
    }

    /**
     * PriceSpecification
     * <p>
     * 
     * 
     * @param paymentMade
     *     The paymentMade
     */
    @JsonProperty("x-paymentMade")
    public void setPaymentMade(PriceSpecification paymentMade) {
        this.paymentMade = paymentMade;
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
        return new HashCodeBuilder().append(accountId).append(description).append(paymentDueDate).append(totalPaymentDue).append(url).append(accountBalance).append(confirmationNumber).append(paymentStatus).append(balanceDue).append(paymentMade).append(additionalProperties).toHashCode();
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
        return new EqualsBuilder().append(accountId, rhs.accountId).append(description, rhs.description).append(paymentDueDate, rhs.paymentDueDate).append(totalPaymentDue, rhs.totalPaymentDue).append(url, rhs.url).append(accountBalance, rhs.accountBalance).append(confirmationNumber, rhs.confirmationNumber).append(paymentStatus, rhs.paymentStatus).append(balanceDue, rhs.balanceDue).append(paymentMade, rhs.paymentMade).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
