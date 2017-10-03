package org.jarling.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.models.Merchant;
import org.jarling.models.MerchantLocation;

/**
 *
 * Interface representing resource to manage data from the merchants the customer has transacted with.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public interface MerchantResource {

    /**
     * <p>Get merchant</p>
     * Returns the merchant details
     * @param id Unique identifier of the merchant
     * @return Merchant
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Merchant API - Starling Bank Developer Docs</a>
     */
    Merchant getMerchant(String id) throws StarlingBankRequestException;

    /**
     * <p>Get merchant location</p>
     * Returns the details of a specific location of the merchant where a transaction took place
     * @param merchantId Unique identifier of the merchant the location belongs to
     * @param locationId Unique identifier of the location for the merchant
     * @return MerchantLocation
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Merchant API - Starling Bank Developer Docs</a>
     */
    MerchantLocation getMerchantLocation(String merchantId, String locationId) throws StarlingBankRequestException;
}
