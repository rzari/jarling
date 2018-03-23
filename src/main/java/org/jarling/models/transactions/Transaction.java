package org.jarling.models.transactions;

import org.jarling.models.common.Direction;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * Model class representing a transaction returned by the Transaction API.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class Transaction {

    private String id;
    private String currency;
    private BigDecimal amount;
    private Direction direction;
    private Date created;
    private String narrative;
    private TransactionSource source;
    private BigDecimal balance;

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

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                ", direction=" + direction +
                ", created=" + created +
                ", narrative='" + narrative + '\'' +
                ", source=" + source +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (direction != that.direction) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (narrative != null ? !narrative.equals(that.narrative) : that.narrative != null) return false;
        if (source != that.source) return false;
        return balance != null ? balance.equals(that.balance) : that.balance == null;

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
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        return result;
    }
}
