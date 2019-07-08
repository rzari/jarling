package org.jarling.v2.transactionfeed;

import org.assertj.core.api.AbstractAssert;
import org.jarling.v2.models.transactionfeed.FeedItemAttachment;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class FeedItemAttachmentAssert extends AbstractAssert<FeedItemAttachmentAssert, FeedItemAttachment> {
    public FeedItemAttachmentAssert(FeedItemAttachment actual) {
        super(actual, FeedItemAttachmentAssert.class);
    }


    public FeedItemAttachmentAssert isValid() {
        isNotNull();
        assertThat(actual.getFeedItemAttachmentUid()).isNotNull();
        assertThat(actual.getFeedItemUid()).isNotNull();
        assertThat(actual.getAttachmentType()).isMimeType();

        return this;
    }
}
