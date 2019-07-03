package org.jarling.v2.transactionfeed;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.models.transactions.FeedItemAttachmentData;
import org.jarling.v2.BaseTest;
import org.jarling.v2.models.accounts.Account;
import org.jarling.v2.models.transactionfeed.FeedItem;
import org.jarling.v2.models.transactionfeed.FeedItemAttachment;
import org.jarling.v2.models.transactionfeed.SpendingCategory;
import org.junit.Test;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assumptions.assumeThat;
import static org.jarling.v2.JarlingAssertions.assertThat;

public class TransactionFeedTest extends BaseTest {
    @Test
    public void testUpdateSpendingCategory() {
        try {
            Account account = starling.getAccounts().get(0);
            UUID accountUid = account.getAccountUid();
            UUID categoryUid = account.getDefaultCategory();
            FeedItem feedItem = starling.getFeedItems(accountUid, categoryUid, getDefaultDate()).get(0);

            SpendingCategory spendingCategory = feedItem.getSpendingCategory();
            SpendingCategory newSpendingCategory = spendingCategory == SpendingCategory.BILLS_AND_SERVICES
                ? SpendingCategory.CHARITY
                : SpendingCategory.BILLS_AND_SERVICES;

            starling.updateSpendingCategory(accountUid, categoryUid, feedItem.getFeedItemUid(), newSpendingCategory);

            FeedItem updatedFeedItem = starling.getFeedItem(accountUid, categoryUid, feedItem.getFeedItemUid());

            assertThat(updatedFeedItem.getSpendingCategory()).isEqualTo(newSpendingCategory);
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
            List<FeedItem> feedItems = starling.getFeedItems(accountUid, categoryUid, getDefaultDate());

            FeedItem feedItem = starling.getFeedItem(accountUid, categoryUid, feedItems.get(0).getFeedItemUid());

            assertThat(feedItem).isValid();
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testGetFeedItems_changesSince() {
        try {
            Account account = starling.getAccounts().get(0);
            UUID accountUid = account.getAccountUid();
            UUID categoryUid = account.getDefaultCategory();

            List<FeedItem> feedItems = starling.getFeedItems(accountUid, categoryUid, getDefaultDate());

            feedItems.forEach(item -> assertThat(item).isValid());

            Instant dateSince = feedItems.get(feedItems.size() / 2 - 1).getTransactionTime();

            List<FeedItem> filteredFeedItems = starling.getFeedItems(accountUid, categoryUid, dateSince);

            assertThat(filteredFeedItems.stream()
                .filter(item -> item.getUpdatedAt().isBefore(dateSince))
            ).isEmpty();
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testGetFeedItems_transactionsBetween() {
        try {
            Account account = starling.getAccounts().get(0);
            UUID accountUid = account.getAccountUid();
            UUID categoryUid = account.getDefaultCategory();

            List<FeedItem> feedItems = starling.getFeedItems(
                accountUid,
                categoryUid,
                getDefaultDate()
            );

            feedItems.forEach(item -> assertThat(item).isValid());

            Instant dateSince = feedItems.get(feedItems.size() / 2 - 1).getTransactionTime();
            Instant dateUntil = feedItems.get(0).getTransactionTime();

            List<FeedItem> filteredFeedItems = starling.getFeedItems(accountUid, categoryUid, dateSince, dateUntil);

            assertThat(
                filteredFeedItems.stream()
                    .filter(item -> item.getTransactionTime().isBefore(dateSince))
            ).isEmpty();

            assertThat(
                filteredFeedItems.stream()
                    .filter(item -> item.getTransactionTime().isAfter(dateUntil))
            ).isEmpty();
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
            FeedItem feedItem = starling.getFeedItems(accountUid, categoryUid, getDefaultDate()).get(0);

            List<FeedItemAttachment> attachments = starling.getFeedItemAttachments(accountUid, categoryUid, feedItem.getFeedItemUid());

            attachments.forEach(attachment -> assertThat(attachment).isValid());
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
            List<FeedItem> feedItems = starling.getFeedItems(accountUid, categoryUid, getDefaultDate());
            List<FeedItemAttachment> attachments = feedItems.stream()
                .flatMap(feedItem -> {
                    try {
                        return starling.getFeedItemAttachments(
                            accountUid,
                            categoryUid,
                            feedItem.getFeedItemUid()
                        ).stream();
                    } catch (StarlingBankRequestException e) {
                        e.printStackTrace();
                        return Stream.empty();
                    }
                })
                .collect(Collectors.toList());
            assumeThat(attachments).isNotEmpty();

            FeedItemAttachment attachment = attachments.get(0);

            FeedItemAttachmentData data = starling.getFeedItemAttachment(accountUid, categoryUid, attachment.getFeedItemUid(), attachment.getFeedItemAttachmentUid());

            assertThat(data)
                .isValid()
                .hasContentType(attachment.getAttachmentType());
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
            FeedItem feedItem = starling.getFeedItems(accountUid, categoryUid, getDefaultDate()).get(0);

            String userNote = feedItem.getUserNote();
            String newUserNote = "Additional text. " + userNote;

            starling.updateUserNote(accountUid, categoryUid, feedItem.getFeedItemUid(), newUserNote);

            FeedItem updatedFeedItem = starling.getFeedItem(accountUid, categoryUid, feedItem.getFeedItemUid());

            assertThat(updatedFeedItem.getUserNote()).isEqualTo(newUserNote);
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    private static Instant getDefaultDate() {
        return Instant.parse("2019-01-01T00:00:00.00Z");
    }
}
