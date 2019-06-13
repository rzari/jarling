package org.jarling.v2.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.models.transactions.FeedItemAttachmentData;
import org.jarling.v2.models.transactionfeed.FeedItem;
import org.jarling.v2.models.transactionfeed.FeedItemAttachment;
import org.jarling.v2.models.transactionfeed.SpendingCategory;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface TransactionFeedResource {
    /**
     * Changes the spending category for a transaction
     *
     * @param accountUid       Account uid (required)
     * @param categoryUid      Category uid (required)
     * @param feedItemUid      Feed item uid (required)
     * @param spendingCategory Spending category (required)
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    void updateSpendingCategory(UUID accountUid, UUID categoryUid, UUID feedItemUid, SpendingCategory spendingCategory) throws StarlingBankRequestException;

    /**
     * Fetches a single feed item
     *
     * @param accountUid  Account uid (required)
     * @param categoryUid Category uid (required)
     * @param feedItemUid Feed item uid (required)
     * @return FeedItem
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    FeedItem getFeedItem(UUID accountUid, UUID categoryUid, UUID feedItemUid) throws StarlingBankRequestException;

    /**
     * Gets the the customers feed items which have changed, or been created, since a given date
     *
     * @param accountUid   Account uid (required)
     * @param categoryUid  Category uid (required)
     * @param changesSince Items which have changed since (required)
     * @return List<FeedItem>
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    List<FeedItem> getFeedItems(UUID accountUid, UUID categoryUid, Date changesSince) throws StarlingBankRequestException;

    /**
     * Fetches the list of items attached to a feed item
     *
     * @param accountUid  Account uid (required)
     * @param categoryUid Category uid (required)
     * @param feedItemUid Feed item uid (required)
     * @return FeedItemAttachments
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    List<FeedItemAttachment> getFeedItemAttachments(UUID accountUid, UUID categoryUid, UUID feedItemUid) throws StarlingBankRequestException;

    /**
     * Downloads the specified feed item attachment
     *
     * @param accountUid            Account uid (required)
     * @param categoryUid           Category uid (required)
     * @param feedItemUid           Feed item uid (required)
     * @param feedItemAttachmentUid Feed item attachment uid (required)
     * @return FeedItemAttachment
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    FeedItemAttachmentData getFeedItemAttachment(UUID accountUid, UUID categoryUid, UUID feedItemUid, UUID feedItemAttachmentUid) throws StarlingBankRequestException;

    /**
     * Changes the user-specified note attached to a transaction
     *
     * @param accountUid  Account uid (required)
     * @param categoryUid Category uid (required)
     * @param feedItemUid Feed item uid (required)
     * @param userNote    User Note (required)
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    void updateUserNote(UUID accountUid, UUID categoryUid, UUID feedItemUid, String userNote) throws StarlingBankRequestException;

}

