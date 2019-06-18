package org.jarling.models.hooks;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class WebhookPayload<T> {
    private Date timestamp;
    private UUID accountHolderUid;
    private UUID webhookNotificationUid;
    private WebhookType webhookType;

    private T content;
}
