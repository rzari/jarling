package org.jarling.v2;

import org.jarling.StarlingBankApiVersion;
import org.jarling.StarlingBankEnvironment;
import org.jarling.StarlingBase;
import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.http.HttpParameter;
import org.jarling.http.HttpResponse;
import org.jarling.models.transactions.FeedItemAttachmentData;
import org.jarling.v2.api.*;
import org.jarling.v2.models.accountholder.AccountHolder;
import org.jarling.v2.models.accountholder.AccountHolderName;
import org.jarling.v2.models.accounts.Account;
import org.jarling.v2.models.accounts.AccountIdentifiers;
import org.jarling.v2.models.accounts.Balance;
import org.jarling.v2.models.accounts.ConfirmationOfFunds;
import org.jarling.v2.models.addresses.Address;
import org.jarling.v2.models.addresses.AddressUpdateRequest;
import org.jarling.v2.models.addresses.Addresses;
import org.jarling.v2.models.apiuseridentity.Identity;
import org.jarling.v2.models.businesses.Business;
import org.jarling.v2.models.individuals.Individual;
import org.jarling.v2.models.jointaccounts.JointAccount;
import org.jarling.v2.models.kyc.KycResult;
import org.jarling.v2.models.transactionfeed.FeedItem;
import org.jarling.v2.models.transactionfeed.FeedItemAttachment;
import org.jarling.v2.models.transactionfeed.SpendingCategory;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * API class responsible for creating services to access Starling Bank resources
 */
public final class Starling extends StarlingBase implements StarlingBank {

    public Starling(StarlingBankEnvironment environment, String accessToken) {
        super(StarlingBankApiVersion.V2, environment, accessToken);
    }

    @Override
    public AccountHolderResource accountHolder() {
        return this;
    }

    @Override
    public AccountHolder getAccountHolder() throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/account-holder").asString(), AccountHolder.class);
    }

    @Override
    public AccountHolderName getAccountHolderName() throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/account-holder/name").asString(), AccountHolderName.class);
    }

    @Override
    public AddressesResource addresses() {
        return this;
    }

    @Override
    public Addresses getAddresses() throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/addresses").asString(), Addresses.class);
    }

    @Override
    public void updateAddress(AddressUpdateRequest addressUpdateRequest) throws StarlingBankRequestException {
        apiService.post("/addresses", null, null, gson.toJson(addressUpdateRequest));
    }

    @Override
    public ApiUserIdentityResource identity() {
        return this;
    }

    @Override
    public Individual getAuthorisingIndividual() throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/identity/individual").asString(), Individual.class);
    }

    @Override
    public Identity getTokenIdentity() throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/identity/token").asString(), Identity.class);
    }

    @Override
    public BusinessesResource businesses() {
        return this;
    }

    @Override
    public Business getBusiness() throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/account-holder/business").asString(), Business.class);
    }

    @Override
    public Address getRegisteredAddress() throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/account-holder/business/registered-address").asString(), Address.class);
    }

    @Override
    public Address getCorrespondenceAddress() throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/account-holder/business/correspondence-address").asString(), Address.class);
    }

    @Override
    public IndividualsResource individuals() {
        return this;
    }

    @Override
    public Individual getIndividual() throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/account-holder/individual").asString(), Individual.class);
    }

    @Override
    public void updateEmail(String email) throws StarlingBankRequestException {
        apiService.put("/account-holder/individual/email", null, null, simpleJsonWrapper("email", email));
    }

    @Override
    public JointAccountsResource jointAccounts() {
        return this;
    }

    @Override
    public JointAccount getJointAccount() throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/account-holder/joint").asString(), JointAccount.class);
    }

    @Override
    public KycResource kyc() {
        return this;
    }

    @Override
    public KycResult getKycResult() throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/kyc/result").asString(), KycResult.class);
    }

    @Override
    public AccountsResource accounts() {
        return this;
    }

    @Override
    public List<Account> getAccounts() throws StarlingBankRequestException {
        return fromJsonList(Account[].class, apiService.get("/accounts").asString(), "accounts");
    }

    @Override
    public AccountIdentifiers getAccountIdentifiers(UUID accountUid) throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/accounts/" + accountUid.toString() + "/identifiers").asString(), AccountIdentifiers.class);
    }

    @Override
    public Balance getAccountBalance(UUID accountUid) throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/accounts/" + accountUid.toString() + "/balance").asString(), Balance.class);
    }

    @Override
    public ConfirmationOfFunds getConfirmationOfFunds(UUID accountUid, BigInteger targetAmountInMinorUnits) throws StarlingBankRequestException {
        HttpParameter[] parameters = new HttpParameter[]{new HttpParameter("targetAmountInMinorUnits", targetAmountInMinorUnits.toString())};
        return gson.fromJson(apiService.get("/accounts/" + accountUid.toString() + "/confirmation-of-funds", parameters).asString(), ConfirmationOfFunds.class);
    }

    @Override
    public TransactionFeedResource transactionFeed() {
        return this;
    }

    @Override
    public void updateSpendingCategory(UUID accountUid, UUID categoryUid, UUID feedItemUid, SpendingCategory spendingCategory) throws StarlingBankRequestException {
        apiService.put(
            "/feed/account/" + accountUid.toString()
                + "/category/" + categoryUid.toString()
                + "/" + feedItemUid.toString()
                + "/spending-category",
            null,
            null,
            simpleJsonWrapper("spendingCategory", spendingCategory)
        );
    }

    @Override
    public FeedItem getFeedItem(UUID accountUid, UUID categoryUid, UUID feedItemUid) throws StarlingBankRequestException {
        return gson.fromJson(
            apiService.get(
                "/feed/account/" + accountUid.toString()
                    + "/category/" + categoryUid.toString()
                    + "/" + feedItemUid.toString()
            ).asString(),
            FeedItem.class
        );
    }

    @Override
    public List<FeedItem> getFeedItems(UUID accountUid, UUID categoryUid, Date changesSince) throws StarlingBankRequestException {
        HttpParameter changesSinceParameter = new HttpParameter("changesSince", formatDateIso8601(changesSince));
        HttpParameter[] parameters = new HttpParameter[]{changesSinceParameter};
        return fromJsonList(
            FeedItem[].class,
            apiService.get(
                "/feed/account/" + accountUid.toString()
                    + "/category/" + categoryUid.toString(),
                parameters
            ).asString(),
            "feedItems"
        );
    }

    @Override
    public List<FeedItemAttachment> getFeedItemAttachments(UUID accountUid, UUID categoryUid, UUID feedItemUid) throws StarlingBankRequestException {
        return fromJsonList(
            FeedItemAttachment[].class,
            apiService.get(
                "/feed/account/" + accountUid.toString()
                    + "/category/" + categoryUid.toString()
                    + "/" + feedItemUid.toString()
                    + "/attachments"
            ).asString(),
            "feedItemAttachments"
        );
    }

    @Override
    public FeedItemAttachmentData getFeedItemAttachment(UUID accountUid, UUID categoryUid, UUID feedItemUid, UUID feedItemAttachmentUid) throws StarlingBankRequestException {
        HttpResponse response = apiService.get(
            "/feed/account/" + accountUid.toString()
                + "/category/" + categoryUid.toString()
                + "/" + feedItemUid.toString()
                + "/attachments/" + feedItemAttachmentUid.toString()
        );

        return new FeedItemAttachmentData(response.getContentType(), response.asBytes());
    }

    @Override
    public void updateUserNote(UUID accountUid, UUID categoryUid, UUID feedItemUid, String userNote) throws StarlingBankRequestException {
        apiService.put(
            "/feed/account/" + accountUid.toString()
                + "/category/" + categoryUid.toString()
                + "/" + feedItemUid.toString()
                + "/user-note",
            null,
            null,
            simpleJsonWrapper("userNote", userNote)
        );
    }
}
