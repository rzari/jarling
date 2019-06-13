package org.jarling.v2.models.transactionfeed;

import lombok.Data;

import java.util.List;

@Data
public class FeedItemAttachments {
    private final List<FeedItemAttachment> feedItemAttachments;
}
