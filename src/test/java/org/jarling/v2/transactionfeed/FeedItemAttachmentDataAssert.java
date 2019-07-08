package org.jarling.v2.transactionfeed;

import org.assertj.core.api.AbstractAssert;
import org.jarling.models.transactions.FeedItemAttachmentData;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class FeedItemAttachmentDataAssert extends AbstractAssert<FeedItemAttachmentDataAssert, FeedItemAttachmentData> {
    public FeedItemAttachmentDataAssert(FeedItemAttachmentData actual) {
        super(actual, FeedItemAttachmentDataAssert.class);
    }

    public FeedItemAttachmentDataAssert isValid() {
        isNotNull();

        assertThat(actual.getContentType()).isMimeType();
        assertThat(actual.getData()).isNotEmpty();

        return this;
    }

    public FeedItemAttachmentDataAssert hasContentType(String contentType) {
        isNotNull();

        assertThat(actual.getContentType()).as("Content Type").isEqualTo(contentType);

        return this;
    }
}
