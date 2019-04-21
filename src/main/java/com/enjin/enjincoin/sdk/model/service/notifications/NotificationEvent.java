package com.enjin.enjincoin.sdk.model.service.notifications;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * <p> Bean used when a notification event is triggered.</p>
 */
@ToString
@Getter
@Builder
public class NotificationEvent {

    private NotificationType type;

    private String channel;

    private String sourceData;

}
