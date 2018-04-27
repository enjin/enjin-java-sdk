package io.enjincoin.sdk.client.vo.notifications;

import io.enjincoin.sdk.client.enums.NotificationType;

/**
 * <p> Bean used when a notification event is triggered.</p>
 */
public abstract class NotificationEvent {

    /**
     * Method to get the notification type.
     *
     * @return NotificationType
     */
    public abstract NotificationType getNotificationType();

    /**
     * Method to get the channel.
     *
     * @return String
     */
    public abstract String getChannel();

    /**
     * Method to return the sourceData.
     *
     * @return String
     */
    public abstract String getSourceData();


}
