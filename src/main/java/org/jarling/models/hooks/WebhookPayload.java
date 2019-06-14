package org.jarling.models.hooks;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class WebhookPayload<T> {
    private final Date timestamp;
    private final UUID accountHolderUid;
    private final UUID webhookNotificationUid;
    private final WebhookType webhookType;

    private final T content;
}
