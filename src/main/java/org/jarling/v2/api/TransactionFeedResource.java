package org.jarling.v2.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.models.transactions.FeedItemAttachmentData;
import org.jarling.v2.models.transactionfeed.FeedItem;
import org.jarling.v2.models.transactionfeed.FeedItemAttachment;
import org.jarling.v2.models.transactionfeed.SpendingCategory;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface TransactionFeedResource {
    /**
     * Fetches a single feed item
     */
    FeedItem getFeedItem(UUID accountUid, UUID categoryUid, UUID feedItemUid) throws StarlingBankRequestException;

    /**
     * Gets the the customers feed items which have changed, or been created, since a given date
     */
    List<FeedItem> getFeedItems(UUID accountUid, UUID categoryUid, Instant changesSince) throws StarlingBankRequestException;

    /**
     * Gets the the customers feed items which were created between two timestamps
     */
    List<FeedItem> getFeedItems(UUID accountUid, UUID categoryUid, Instant minTransactionTimestamp, Instant maxTransactionTimestamp) throws StarlingBankRequestException;

    /**
     * Fetches the list of items attached to a feed item
     */
    List<FeedItemAttachment> getFeedItemAttachments(UUID accountUid, UUID categoryUid, UUID feedItemUid) throws StarlingBankRequestException;

    /**
     * Downloads the  feed item attachment
     */
    FeedItemAttachmentData getFeedItemAttachment(UUID accountUid, UUID categoryUid, UUID feedItemUid, UUID feedItemAttachmentUid) throws StarlingBankRequestException;

    /**
     * Changes the user-specified note attached to a transaction
     */
    void updateUserNote(UUID accountUid, UUID categoryUid, UUID feedItemUid, String userNote) throws StarlingBankRequestException;

    /**
     * Changes the spending category for a transaction
     */
    void updateSpendingCategory(UUID accountUid, UUID categoryUid, UUID feedItemUid, SpendingCategory spendingCategory) throws StarlingBankRequestException;

}

