package org.jarling.v2.models.transactionfeed;

import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class FeedItemAttachment {
    private UUID feedItemUid;
    private UUID feedItemAttachmentUid;
    private String attachmentType;
    private String userComment;
}
