package org.jarling.v2.transactionfeed;

import org.assertj.core.api.AbstractAssert;
import org.jarling.v2.models.transactionfeed.FeedItem;

import static org.jarling.v2.JarlingAssertions.assertThat;


public class FeedItemAssert extends AbstractAssert<FeedItemAssert, FeedItem> {
    public FeedItemAssert(FeedItem actual) {
        super(actual, FeedItemAssert.class);
    }

    public FeedItemAssert isValid() {
        isNotNull();

        assertThat(actual.getFeedItemUid()).isNotNull();
        assertThat(actual.getCategoryUid()).isNotNull();
        assertThat(actual.getAmount()).isNotNull();
        assertThat(actual.getSourceAmount()).isNotNull();
        assertThat(actual.getDirection()).isNotNull();
        assertThat(actual.getUpdatedAt()).isNotNull();
        assertThat(actual.getTransactionTime()).isNotNull();
        assertThat(actual.getSource()).isNotNull();
        assertThat(actual.getCounterPartyType()).isNotNull();
        assertThat(actual.getCounterPartyName()).isNotEmpty();
        assertThat(actual.getReference()).isNotEmpty();
        assertThat(actual.getCountry()).isNotNull();
        assertThat(actual.getSpendingCategory()).isNotNull();

        return this;
    }
}
