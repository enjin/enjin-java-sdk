package io.enjincoin.sdk.client.vo.notifications;

import io.enjincoin.sdk.client.enums.NotificationType;

/**
 * <p> Bean used when a notification event is triggered.</p>
 */
public class NotificationEvent {

    private NotificationType notificationType;

    private String channel;

    private String sourceData;

    public NotificationEvent(NotificationType notificationType, String channel, String sourceData) {
        this.notificationType = notificationType;
        this.channel = channel;
        this.sourceData = sourceData;
    }

    /**
     * Method to get the notification type.
     *
     * @return NotificationType
     */
    public NotificationType getNotificationType() {
        return this.notificationType;
    }

    /**
     * Method to get the channel.
     *
     * @return String
     */
    public String getChannel() {
        return this.channel;
    }

    /**
     * Method to return the sourceData.
     *
     * @return String
     */
    public String getSourceData() {
        return this.sourceData;
    }


}
