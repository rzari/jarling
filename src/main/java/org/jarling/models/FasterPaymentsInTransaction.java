package org.jarling.models;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * Model class representing an incoming faster payments transaction returned by the Transaction Faster Payment In API.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class FasterPaymentsInTransaction {

    private String id;
    private String currency;
    private BigDecimal amount;
    private Direction direction;
    private Date created;
    private String narrative;
    private TransactionSource source;
    private String sendingContactAccountId;
    private String sendingContactId;

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

    public String getSendingContactAccountId() {
        return sendingContactAccountId;
    }

    public String getSendingContactId() {
        return sendingContactId;
    }

    @Override
    public String toString() {
        return "FasterPaymentsInTransaction{" +
                "id='" + id + '\'' +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                ", direction=" + direction +
                ", created=" + created +
                ", narrative='" + narrative + '\'' +
                ", source=" + source +
                ", sendingContactAccountId='" + sendingContactAccountId + '\'' +
                ", sendingContactId='" + sendingContactId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FasterPaymentsInTransaction that = (FasterPaymentsInTransaction) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (direction != that.direction) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (narrative != null ? !narrative.equals(that.narrative) : that.narrative != null) return false;
        if (source != that.source) return false;
        if (sendingContactAccountId != null ? !sendingContactAccountId.equals(that.sendingContactAccountId) : that.sendingContactAccountId != null)
            return false;
        return sendingContactId != null ? sendingContactId.equals(that.sendingContactId) : that.sendingContactId == null;

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
        result = 31 * result + (sendingContactAccountId != null ? sendingContactAccountId.hashCode() : 0);
        result = 31 * result + (sendingContactId != null ? sendingContactId.hashCode() : 0);
        return result;
    }
}
