package org.jarling.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.models.cards.Card;

/**
 *
 * Interface representing resource to manage a customer's Starling debit cards.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public interface CardResource {

    /**
     * <p>Get card</p>
     * Returns the customer's debit card information.
     * @return Card
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Card API - Starling Bank Developer Docs</a>
     */
    Card getCard() throws StarlingBankRequestException;
}
