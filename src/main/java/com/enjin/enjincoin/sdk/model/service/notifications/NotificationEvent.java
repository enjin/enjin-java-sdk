package com.enjin.enjincoin.sdk.model.service.notifications;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Represents a trusted platform event.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.service.notifications.NotificationsService
 * @see NotificationType
 */
@ToString
@Getter
@Builder
public class NotificationEvent {

    /**
     * The type of notification.
     *
     * -- GETTER --
     * @return the type.
     * -- SETTER --
     * @param type the notification type.
     * @return the builder.
     */
    private NotificationType type;

    /**
     * The channel the notification was received.
     *
     * -- GETTER --
     * @return the channel.
     * -- SETTER --
     * @param channel the channel.
     * @return the builder.
     */
    private String channel;

    /**
     * The notification data.
     *
     * -- GETTER --
     * @return the data.
     * -- SETTER --
     * @param data the notification data.
     * @return the builder.
     */
    private String data;

}
