package org.jarling.v2.models.transactionfeed;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class FeedItemAttachments {
    private List<FeedItemAttachment> feedItemAttachments;
}
