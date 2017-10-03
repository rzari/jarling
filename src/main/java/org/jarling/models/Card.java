package org.jarling.models;

import java.util.Date;

/**
 *
 * Model class representing a debit card returned by the Card API.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class Card {

    private Boolean activated;
    private Boolean activationRequested;
    private Date dispatchDate;
    private String id;
    private String nameOnCard;
    private CardType type;

    public Boolean getActivated() {
        return activated;
    }

    public Boolean getActivationRequested() {
        return activationRequested;
    }

    public Date getDispatchDate() {
        return dispatchDate;
    }

    public String getId() {
        return id;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public CardType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Card{" +
                "activated=" + activated +
                ", activationRequested=" + activationRequested +
                ", dispatchDate=" + dispatchDate +
                ", id='" + id + '\'' +
                ", nameOnCard='" + nameOnCard + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (activated != null ? !activated.equals(card.activated) : card.activated != null) return false;
        if (activationRequested != null ? !activationRequested.equals(card.activationRequested) : card.activationRequested != null)
            return false;
        if (dispatchDate != null ? !dispatchDate.equals(card.dispatchDate) : card.dispatchDate != null) return false;
        if (id != null ? !id.equals(card.id) : card.id != null) return false;
        if (nameOnCard != null ? !nameOnCard.equals(card.nameOnCard) : card.nameOnCard != null) return false;
        return type == card.type;

    }

    @Override
    public int hashCode() {
        int result = activated != null ? activated.hashCode() : 0;
        result = 31 * result + (activationRequested != null ? activationRequested.hashCode() : 0);
        result = 31 * result + (dispatchDate != null ? dispatchDate.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (nameOnCard != null ? nameOnCard.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
