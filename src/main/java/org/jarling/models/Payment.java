package org.jarling.models;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * Model class representing a payment returned by the Payment API.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class Payment {

    private BigDecimal amount;
    private Date cancelledAt;
    private String currency;
    private Date endDate;
    private Date lastDate;
    private String mandateId;
    private Date nextDate;
    private String paymentOrderId;
    private PaymentType paymentType;
    private String receivingContactAccountId;
    private String recipientName;
    private Boolean immediate;
    private RecurrenceRule recurrenceRule;
    private String reference;
    private Date startDate;

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getCancelledAt() {
        return cancelledAt;
    }

    public String getCurrency() {
        return currency;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public String getMandateId() {
        return mandateId;
    }

    public Date getNextDate() {
        return nextDate;
    }

    public String getPaymentOrderId() {
        return paymentOrderId;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public String getReceivingContactAccountId() {
        return receivingContactAccountId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public Boolean getImmediate() {
        return immediate;
    }

    public RecurrenceRule getRecurrenceRule() {
        return recurrenceRule;
    }

    public String getReference() {
        return reference;
    }

    public Date getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "amount=" + amount +
                ", cancelledAt=" + cancelledAt +
                ", currency='" + currency + '\'' +
                ", endDate=" + endDate +
                ", lastDate=" + lastDate +
                ", mandateId='" + mandateId + '\'' +
                ", nextDate=" + nextDate +
                ", paymentOrderId='" + paymentOrderId + '\'' +
                ", paymentType=" + paymentType +
                ", receivingContactAccountId='" + receivingContactAccountId + '\'' +
                ", recipientName='" + recipientName + '\'' +
                ", immediate=" + immediate +
                ", recurrenceRule=" + recurrenceRule +
                ", reference='" + reference + '\'' +
                ", startDate=" + startDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (amount != null ? !amount.equals(payment.amount) : payment.amount != null) return false;
        if (cancelledAt != null ? !cancelledAt.equals(payment.cancelledAt) : payment.cancelledAt != null) return false;
        if (currency != null ? !currency.equals(payment.currency) : payment.currency != null) return false;
        if (endDate != null ? !endDate.equals(payment.endDate) : payment.endDate != null) return false;
        if (lastDate != null ? !lastDate.equals(payment.lastDate) : payment.lastDate != null) return false;
        if (mandateId != null ? !mandateId.equals(payment.mandateId) : payment.mandateId != null) return false;
        if (nextDate != null ? !nextDate.equals(payment.nextDate) : payment.nextDate != null) return false;
        if (paymentOrderId != null ? !paymentOrderId.equals(payment.paymentOrderId) : payment.paymentOrderId != null)
            return false;
        if (paymentType != payment.paymentType) return false;
        if (receivingContactAccountId != null ? !receivingContactAccountId.equals(payment.receivingContactAccountId) : payment.receivingContactAccountId != null)
            return false;
        if (recipientName != null ? !recipientName.equals(payment.recipientName) : payment.recipientName != null)
            return false;
        if (immediate != null ? !immediate.equals(payment.immediate) : payment.immediate != null) return false;
        if (recurrenceRule != null ? !recurrenceRule.equals(payment.recurrenceRule) : payment.recurrenceRule != null)
            return false;
        if (reference != null ? !reference.equals(payment.reference) : payment.reference != null) return false;
        return startDate != null ? startDate.equals(payment.startDate) : payment.startDate == null;

    }

    @Override
    public int hashCode() {
        int result = amount != null ? amount.hashCode() : 0;
        result = 31 * result + (cancelledAt != null ? cancelledAt.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (lastDate != null ? lastDate.hashCode() : 0);
        result = 31 * result + (mandateId != null ? mandateId.hashCode() : 0);
        result = 31 * result + (nextDate != null ? nextDate.hashCode() : 0);
        result = 31 * result + (paymentOrderId != null ? paymentOrderId.hashCode() : 0);
        result = 31 * result + (paymentType != null ? paymentType.hashCode() : 0);
        result = 31 * result + (receivingContactAccountId != null ? receivingContactAccountId.hashCode() : 0);
        result = 31 * result + (recipientName != null ? recipientName.hashCode() : 0);
        result = 31 * result + (immediate != null ? immediate.hashCode() : 0);
        result = 31 * result + (recurrenceRule != null ? recurrenceRule.hashCode() : 0);
        result = 31 * result + (reference != null ? reference.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        return result;
    }
}