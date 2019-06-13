package org.jarling.v2.models.transactionfeed;

import lombok.Data;

import java.util.UUID;

@Data
public class FeedItemAttachment {
    private final UUID feedItemUid;
    private final UUID feedItemAttachmentUid;
    private final String attachmentType;
    private final String userComment;
}
