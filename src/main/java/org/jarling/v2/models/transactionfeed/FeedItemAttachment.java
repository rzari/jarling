package org.jarling.v2.models.transactionfeed;

import lombok.Data;

import java.util.UUID;

@Data
public class FeedItemAttachment {
    private UUID feedItemUid;
    private UUID feedItemAttachmentUid;
    private String attachmentType;
    private String userComment;
}
