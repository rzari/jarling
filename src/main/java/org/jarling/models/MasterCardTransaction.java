package org.jarling.models;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * Model class representing a mastercard transaction returned by the Transaction Mastercard API.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class MasterCardTransaction {

    private String id;
    private String currency;
    private BigDecimal amount;
    private Direction direction;
    private Date created;
    private String narrative;
    private TransactionSource source;
    private MasterCardTransactionMethod mastercardTransactionMethod;
    private TransactionStatus status;
    private BigDecimal sourceAmount;
    private String sourceCurrency;
    private String merchantId;
    private String merchantLocationId;

    public String getId() {
        return id;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Direction getDirection() {
        return direction;
    }

    public Date getCreated() {
        return created;
    }

    public String getNarrative() {
        return narrative;
    }

    public TransactionSource getSource() {
        return source;
    }

    public MasterCardTransactionMethod getMastercardTransactionMethod() {
        return mastercardTransactionMethod;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public BigDecimal getSourceAmount() {
        return sourceAmount;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getMerchantLocationId() {
        return merchantLocationId;
    }

    @Override
    public String toString() {
        return "MasterCardTransaction{" +
                "id='" + id + '\'' +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                ", direction=" + direction +
                ", created=" + created +
                ", narrative='" + narrative + '\'' +
                ", source=" + source +
                ", mastercardTransactionMethod=" + mastercardTransactionMethod +
                ", status=" + status +
                ", sourceAmount=" + sourceAmount +
                ", sourceCurrency='" + sourceCurrency + '\'' +
                ", merchantId='" + merchantId + '\'' +
                ", merchantLocationId='" + merchantLocationId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MasterCardTransaction that = (MasterCardTransaction) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (direction != that.direction) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (narrative != null ? !narrative.equals(that.narrative) : that.narrative != null) return false;
        if (source != that.source) return false;
        if (mastercardTransactionMethod != that.mastercardTransactionMethod) return false;
        if (status != that.status) return false;
        if (sourceAmount != null ? !sourceAmount.equals(that.sourceAmount) : that.sourceAmount != null) return false;
        if (sourceCurrency != null ? !sourceCurrency.equals(that.sourceCurrency) : that.sourceCurrency != null)
            return false;
        if (merchantId != null ? !merchantId.equals(that.merchantId) : that.merchantId != null) return false;
        return merchantLocationId != null ? merchantLocationId.equals(that.merchantLocationId) : that.merchantLocationId == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (narrative != null ? narrative.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (mastercardTransactionMethod != null ? mastercardTransactionMethod.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (sourceAmount != null ? sourceAmount.hashCode() : 0);
        result = 31 * result + (sourceCurrency != null ? sourceCurrency.hashCode() : 0);
        result = 31 * result + (merchantId != null ? merchantId.hashCode() : 0);
        result = 31 * result + (merchantLocationId != null ? merchantLocationId.hashCode() : 0);
        return result;
    }
}
