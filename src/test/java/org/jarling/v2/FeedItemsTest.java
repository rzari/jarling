package org.jarling.v2;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.models.transactions.FeedItemAttachmentData;
import org.jarling.v2.models.accounts.Account;
import org.jarling.v2.models.transactionfeed.FeedItem;
import org.jarling.v2.models.transactionfeed.FeedItemAttachment;
import org.jarling.v2.models.transactionfeed.SpendingCategory;
import org.junit.Test;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeFalse;

public class FeedItemsTest extends BaseTest {
    @Test
    public void testUpdateSpendingCategory() {
        try {
            Account account = starling.getAccounts().get(0);
            UUID accountUid = account.getAccountUid();
            UUID categoryUid = account.getDefaultCategory();
            FeedItem feedItem = starling.getFeedItems(accountUid, categoryUid, Date.valueOf("2019-01-01")).get(0);

            SpendingCategory spendingCategory = feedItem.getSpendingCategory();
            SpendingCategory newSpendingCategory = spendingCategory == SpendingCategory.BILLS_AND_SERVICES
                ? SpendingCategory.CHARITY
                : SpendingCategory.BILLS_AND_SERVICES;

            starling.updateSpendingCategory(accountUid, categoryUid, feedItem.getFeedItemUid(), newSpendingCategory);

            FeedItem updatedFeedItem = starling.getFeedItem(accountUid, categoryUid, feedItem.getFeedItemUid());

            assertEquals(newSpendingCategory, updatedFeedItem.getSpendingCategory());
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testGetFeedItem() {
        try {
            Account account = starling.getAccounts().get(0);
            UUID accountUid = account.getAccountUid();
            UUID categoryUid = account.getDefaultCategory();
            List<FeedItem> feedItems = starling.getFeedItems(accountUid, categoryUid, Date.valueOf("2019-01-01"));

            FeedItem feedItem = starling.getFeedItem(accountUid, categoryUid, feedItems.get(0).getFeedItemUid());

            assertFeedItemValid(feedItem);
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testGetFeedItems() {
        try {
            Account account = starling.getAccounts().get(0);
            UUID accountUid = account.getAccountUid();
            UUID categoryUid = account.getDefaultCategory();

            List<FeedItem> feedItems = starling.getFeedItems(accountUid, categoryUid, Date.valueOf("2019-01-01"));

            assertFeedItemValid(feedItems.get(0));
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testGetFeedItemAttachments() {
        try {
            Account account = starling.getAccounts().get(0);
            UUID accountUid = account.getAccountUid();
            UUID categoryUid = account.getDefaultCategory();
            FeedItem feedItem = starling.getFeedItems(accountUid, categoryUid, Date.valueOf("2019-01-01")).get(0);

            starling.getFeedItemAttachments(accountUid, categoryUid, feedItem.getFeedItemUid());
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testGetFeedItemAttachment() {
        try {
            Account account = starling.getAccounts().get(0);
            UUID accountUid = account.getAccountUid();
            UUID categoryUid = account.getDefaultCategory();
            List<FeedItem> feedItems = starling.getFeedItems(accountUid, categoryUid, Date.valueOf("2019-01-01"));
            List<FeedItemAttachment> attachments = feedItems.stream()
                .map(feedItem -> {
                    try {
                        return starling.getFeedItemAttachments(accountUid, categoryUid, feedItem.getFeedItemUid());
                    } catch (StarlingBankRequestException e) {
                        e.printStackTrace();
                        return Collections.<FeedItemAttachment>emptyList();
                    }
                })
                .flatMap(List::stream)
                .collect(Collectors.toList());
            assumeFalse(attachments.isEmpty());

            FeedItemAttachment attachment = attachments.get(0);

            FeedItemAttachmentData data = starling.getFeedItemAttachment(accountUid, categoryUid, attachment.getFeedItemUid(), attachment.getFeedItemAttachmentUid());

            assertFalse(data.getContentType().isEmpty());
            assertNotEquals(0, data.getData().length);
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testUpdateUserNote() {
        try {
            Account account = starling.getAccounts().get(0);
            UUID accountUid = account.getAccountUid();
            UUID categoryUid = account.getDefaultCategory();
            FeedItem feedItem = starling.getFeedItems(accountUid, categoryUid, Date.valueOf("2019-01-01")).get(0);

            String userNote = feedItem.getUserNote();
            String newUserNote = "Additional text. " + userNote;

            starling.updateUserNote(accountUid, categoryUid, feedItem.getFeedItemUid(), newUserNote);

            FeedItem updatedFeedItem = starling.getFeedItem(accountUid, categoryUid, feedItem.getFeedItemUid());

            assertEquals(newUserNote, updatedFeedItem.getUserNote());
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    private static void assertFeedItemValid(FeedItem feedItem) {
        assertNotNull(feedItem.getFeedItemUid());
        assertNotNull(feedItem.getCategoryUid());
        assertNotNull(feedItem.getAmount());
        assertNotNull(feedItem.getSourceAmount());
        assertNotNull(feedItem.getDirection());
        assertNotNull(feedItem.getUpdatedAt());
        assertNotNull(feedItem.getTransactionTime());
        assertNotNull(feedItem.getSettlementTime());
        assertNotNull(feedItem.getSource());
        assertNotNull(feedItem.getCounterPartyType());
        assertFalse(feedItem.getCounterPartyName().isEmpty());
        assertFalse(feedItem.getReference().isEmpty());
        assertNotNull(feedItem.getCountry());
        assertNotNull(feedItem.getSpendingCategory());
    }
}
