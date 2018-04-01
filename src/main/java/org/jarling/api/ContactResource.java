package org.jarling.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.models.contacts.Contact;
import org.jarling.models.contacts.ContactAccount;

import java.util.List;

/**
 *
 * Interface representing resource to manage the contacts known by a customer and the accounts the contact has, to which transfers can be made.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public interface ContactResource {

    /**
     * <p>Get contact</p>
     * Returns a contact for the specified contact ID
     * @param id Unique identifier of the contact
     * @return Contact
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Contact API - Starling Bank Developer Docs</a>
     */
    Contact getContact(String id) throws StarlingBankRequestException;

    /**
     * <p>Get contacts</p>
     * Returns a list of contacts for a customer
     * @return A list of contacts
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Contact API - Starling Bank Developer Docs</a>
     */
    List<Contact> listContacts() throws StarlingBankRequestException;

    /**
     * <p>Create contact and account</p>
     * Creates a new contact for a customer. If the contact you are trying to create already exists, the response will return the UUID of the existing contact rather than creating a duplicate.
     * @param name Name of the contact
     * @param sortCode The contact's sort code
     * @param accountNumber The contact's account number
     * @return Contact
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Contact API - Starling Bank Developer Docs</a>
     */
    Contact createContact(String name, String sortCode, String accountNumber) throws StarlingBankRequestException;

    /**
     * <p>Delete contact</p>
     * Deletes the contact with the specified identifier.
     * @param id Unique identifier of the contact to be deleted
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Contact API - Starling Bank Developer Docs</a>
     */
    void deleteContact(String id) throws StarlingBankRequestException;

    /**
     * <p>Get contact account</p>
     * Returns a contact's account containing information to which payments can be made.
     * @param contactId Unique identifier of the contact
     * @param contactAccountId Unique identifier of the account at the contact
     * @return ContactAccount
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Contact API - Starling Bank Developer Docs</a>
     */
    ContactAccount getContactAccount(String contactId, String contactAccountId) throws StarlingBankRequestException;

    /**
     * <p>Get contact accounts</p>
     * Returns a list a contact's accounts containing information to which payments can be made.
     * @param contactId Unique identifier of the contact
     * @return A list of accounts for the contact
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Contact API - Starling Bank Developer Docs</a>
     */
    List<ContactAccount> listContactAccounts(String contactId) throws StarlingBankRequestException;
}
