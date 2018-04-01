package org.jarling.models.directDebits;

import org.jarling.models.common.Direction;
import org.jarling.models.transactions.TransactionSource;
import org.jarling.models.transactions.TransactionType;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * Model class representing an direct debit transaction returned by the Transaction Direct Debit API.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class DirectDebitTransaction {

    private String id;
    private String title;
    private TransactionType type;
    private String currency;
    private TransactionSource source;
    private Direction direction;
    private String narrative;
    private Date created;
    private BigDecimal amount;
    private BigDecimal balance;
    private String mandateId;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public TransactionType getType() {
        return type;
    }

    public String getCurrency() {
        return currency;
    }

    public TransactionSource getSource() {
        return source;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getNarrative() {
        return narrative;
    }

    public Date getCreated() {
        return created;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getMandateId() {
        return mandateId;
    }

    @Override
    public String toString() {
        return "DirectDebitTransaction{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", currency='" + currency + '\'' +
                ", source=" + source +
                ", direction=" + direction +
                ", narrative='" + narrative + '\'' +
                ", created=" + created +
                ", amount=" + amount +
                ", balance=" + balance +
                ", mandateId='" + mandateId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectDebitTransaction that = (DirectDebitTransaction) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (type != that.type) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (source != that.source) return false;
        if (direction != that.direction) return false;
        if (narrative != null ? !narrative.equals(that.narrative) : that.narrative != null) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;
        return mandateId != null ? mandateId.equals(that.mandateId) : that.mandateId == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        result = 31 * result + (narrative != null ? narrative.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (mandateId != null ? mandateId.hashCode() : 0);
        return result;
    }
}
