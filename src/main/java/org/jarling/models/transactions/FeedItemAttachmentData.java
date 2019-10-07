package org.jarling.models.transactions;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class FeedItemAttachmentData {
    private final String contentType;
    private final byte[] data;
}
