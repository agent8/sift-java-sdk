
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
import com.easilydo.sift.model.ShipmentStatus;

/**
 * Order
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "acceptedOffer",
    "broker",
    "description",
    "discount",
    "orderDate",
    "orderNumber",
    "partOfInvoice",
    "seller",
    "orderStatus",
    "x-paymentScheduled",
    "x-price",
    "x-priceCurrency",
    "x-purchaseType",
    "x-refund",
    "x-shipping",
    "x-subTotal",
    "x-tax"
})
public class Order extends Sift {

    @JsonProperty("acceptedOffer")
    private List<Offer> acceptedOffer = new ArrayList<Offer>();
    /**
     * Organization
     * <p>
     * 
     * 
     */
    @JsonProperty("broker")
    private Organization broker;
    @JsonProperty("description")
    private String description;
    @JsonProperty("discount")
    private String discount;
    @JsonProperty("orderDate")
    private Date orderDate;
    @JsonProperty("orderNumber")
    private String orderNumber;
    /**
     * Invoice
     * <p>
     * 
     * 
     */
    @JsonProperty("partOfInvoice")
    private Invoice partOfInvoice;
    /**
     * Organization
     * <p>
     * 
     * 
     */
    @JsonProperty("seller")
    private Organization seller;
    @JsonProperty("orderStatus")
    private ShipmentStatus orderStatus;
    @JsonProperty("x-paymentScheduled")
    private String paymentScheduled;
    @JsonProperty("x-price")
    private String price;
    @JsonProperty("x-priceCurrency")
    private String priceCurrency;
    @JsonProperty("x-purchaseType")
    private String purchaseType;
    @JsonProperty("x-refund")
    private Boolean refund;
    @JsonProperty("x-shipping")
    private String shipping;
    @JsonProperty("x-subTotal")
    private String subTotal;
    @JsonProperty("x-tax")
    private String tax;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The acceptedOffer
     */
    @JsonProperty("acceptedOffer")
    public List<Offer> getAcceptedOffer() {
        return acceptedOffer;
    }

    /**
     * 
     * @param acceptedOffer
     *     The acceptedOffer
     */
    @JsonProperty("acceptedOffer")
    public void setAcceptedOffer(List<Offer> acceptedOffer) {
        this.acceptedOffer = acceptedOffer;
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
     *     The discount
     */
    @JsonProperty("discount")
    public String getDiscount() {
        return discount;
    }

    /**
     * 
     * @param discount
     *     The discount
     */
    @JsonProperty("discount")
    public void setDiscount(String discount) {
        this.discount = discount;
    }

    /**
     * 
     * @return
     *     The orderDate
     */
    @JsonProperty("orderDate")
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * 
     * @param orderDate
     *     The orderDate
     */
    @JsonProperty("orderDate")
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * 
     * @return
     *     The orderNumber
     */
    @JsonProperty("orderNumber")
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 
     * @param orderNumber
     *     The orderNumber
     */
    @JsonProperty("orderNumber")
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Invoice
     * <p>
     * 
     * 
     * @return
     *     The partOfInvoice
     */
    @JsonProperty("partOfInvoice")
    public Invoice getPartOfInvoice() {
        return partOfInvoice;
    }

    /**
     * Invoice
     * <p>
     * 
     * 
     * @param partOfInvoice
     *     The partOfInvoice
     */
    @JsonProperty("partOfInvoice")
    public void setPartOfInvoice(Invoice partOfInvoice) {
        this.partOfInvoice = partOfInvoice;
    }

    /**
     * Organization
     * <p>
     * 
     * 
     * @return
     *     The seller
     */
    @JsonProperty("seller")
    public Organization getSeller() {
        return seller;
    }

    /**
     * Organization
     * <p>
     * 
     * 
     * @param seller
     *     The seller
     */
    @JsonProperty("seller")
    public void setSeller(Organization seller) {
        this.seller = seller;
    }

    /**
     * ShipmentStatus
     * <p>
     * 
     * 
     * @return
     *     The orderStatus
     */
    @JsonProperty("orderStatus")
    public ShipmentStatus getOrderStatus() {
        return orderStatus;
    }

    /**
     * ShipmentStatus
     * <p>
     * 
     * 
     * @param orderStatus
     *     The orderStatus
     */
    @JsonProperty("orderStatus")
    public void setOrderStatus(ShipmentStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 
     * @return
     *     The paymentScheduled
     */
    @JsonProperty("x-paymentScheduled")
    public String getPaymentScheduled() {
        return paymentScheduled;
    }

    /**
     * 
     * @param paymentScheduled
     *     The paymentScheduled
     */
    @JsonProperty("x-paymentScheduled")
    public void setPaymentScheduled(String paymentScheduled) {
        this.paymentScheduled = paymentScheduled;
    }

    /**
     * 
     * @return
     *     The price
     */
    @JsonProperty("x-price")
    public String getPrice() {
        return price;
    }

    /**
     * 
     * @param price
     *     The price
     */
    @JsonProperty("x-price")
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * 
     * @return
     *     The priceCurrency
     */
    @JsonProperty("x-priceCurrency")
    public String getPriceCurrency() {
        return priceCurrency;
    }

    /**
     * 
     * @param priceCurrency
     *     The priceCurrency
     */
    @JsonProperty("x-priceCurrency")
    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    /**
     * 
     * @return
     *     The purchaseType
     */
    @JsonProperty("x-purchaseType")
    public String getPurchaseType() {
        return purchaseType;
    }

    /**
     * 
     * @param purchaseType
     *     The purchaseType
     */
    @JsonProperty("x-purchaseType")
    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }

    /**
     * 
     * @return
     *     The refund
     */
    @JsonProperty("x-refund")
    public Boolean getRefund() {
        return refund;
    }

    /**
     * 
     * @param refund
     *     The refund
     */
    @JsonProperty("x-refund")
    public void setRefund(Boolean refund) {
        this.refund = refund;
    }

    /**
     * 
     * @return
     *     The shipping
     */
    @JsonProperty("x-shipping")
    public String getShipping() {
        return shipping;
    }

    /**
     * 
     * @param shipping
     *     The shipping
     */
    @JsonProperty("x-shipping")
    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    /**
     * 
     * @return
     *     The subTotal
     */
    @JsonProperty("x-subTotal")
    public String getSubTotal() {
        return subTotal;
    }

    /**
     * 
     * @param subTotal
     *     The subTotal
     */
    @JsonProperty("x-subTotal")
    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * 
     * @return
     *     The tax
     */
    @JsonProperty("x-tax")
    public String getTax() {
        return tax;
    }

    /**
     * 
     * @param tax
     *     The tax
     */
    @JsonProperty("x-tax")
    public void setTax(String tax) {
        this.tax = tax;
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
        return new HashCodeBuilder().append(acceptedOffer).append(broker).append(description).append(discount).append(orderDate).append(orderNumber).append(partOfInvoice).append(seller).append(orderStatus).append(paymentScheduled).append(price).append(priceCurrency).append(purchaseType).append(refund).append(shipping).append(subTotal).append(tax).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Order) == false) {
            return false;
        }
        Order rhs = ((Order) other);
        return new EqualsBuilder().append(acceptedOffer, rhs.acceptedOffer).append(broker, rhs.broker).append(description, rhs.description).append(discount, rhs.discount).append(orderDate, rhs.orderDate).append(orderNumber, rhs.orderNumber).append(partOfInvoice, rhs.partOfInvoice).append(seller, rhs.seller).append(orderStatus, rhs.orderStatus).append(paymentScheduled, rhs.paymentScheduled).append(price, rhs.price).append(priceCurrency, rhs.priceCurrency).append(purchaseType, rhs.purchaseType).append(refund, rhs.refund).append(shipping, rhs.shipping).append(subTotal, rhs.subTotal).append(tax, rhs.tax).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
