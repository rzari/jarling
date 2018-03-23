package org.jarling.models.transactions;

import org.jarling.models.common.Direction;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * Model class representing an outgoing faster payments transaction returned by the Transaction Faster Payment Out API.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class FasterPaymentsOutTransaction {

    private String id;
    private String currency;
    private BigDecimal amount;
    private Direction direction;
    private Date created;
    private String narrative;
    private TransactionSource source;
    private String receivingContactAccountId;
    private String receivingContactId;

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

    public String getReceivingContactAccountId() {
        return receivingContactAccountId;
    }

    public String getReceivingContactId() {
        return receivingContactId;
    }

    @Override
    public String toString() {
        return "FasterPaymentsOutTransaction{" +
                "id='" + id + '\'' +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                ", direction=" + direction +
                ", created=" + created +
                ", narrative='" + narrative + '\'' +
                ", source=" + source +
                ", receivingContactAccountId='" + receivingContactAccountId + '\'' +
                ", receivingContactId='" + receivingContactId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FasterPaymentsOutTransaction that = (FasterPaymentsOutTransaction) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (direction != that.direction) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (narrative != null ? !narrative.equals(that.narrative) : that.narrative != null) return false;
        if (source != that.source) return false;
        if (receivingContactAccountId != null ? !receivingContactAccountId.equals(that.receivingContactAccountId) : that.receivingContactAccountId != null)
            return false;
        return receivingContactId != null ? receivingContactId.equals(that.receivingContactId) : that.receivingContactId == null;

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
        result = 31 * result + (receivingContactAccountId != null ? receivingContactAccountId.hashCode() : 0);
        result = 31 * result + (receivingContactId != null ? receivingContactId.hashCode() : 0);
        return result;
    }
}
