package org.jarling.models.transactions;

import lombok.Data;

@Data
public class FeedItemAttachmentData {
    private final String contentType;
    private final byte[] data;
}
