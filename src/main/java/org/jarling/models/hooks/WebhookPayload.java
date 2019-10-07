package org.jarling.models.hooks;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class WebhookPayload<T> {
    private Date timestamp;
    private UUID accountHolderUid;
    private UUID webhookNotificationUid;
    private WebhookType webhookType;

    private T content;
}
