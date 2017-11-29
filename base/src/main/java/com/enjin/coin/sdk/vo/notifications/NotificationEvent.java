package com.enjin.coin.sdk.vo.notifications;

import java.util.EventObject;

import com.enjin.coin.sdk.enums.NotificationType;

/**
 * <p> Bean used when a notification event is triggered.</p>
 *
 */
public class NotificationEvent extends EventObject {

    /**
     * Date from the event.
     */
    private String sourceData;
    /**
     * Notification type received.
     */
    private NotificationType notificationType;

    /**
     * Channel event came from.
     */
    private String channel;
    /**
     *
     */
    private static final long serialVersionUID = 6714115003936048276L;

    /**
     * Class constructor.
     * @param sourceData the sourceData received from the notification
     * @param channel the channel the notification was received from
     * @param notificationType the type of event we received
     */
    public NotificationEvent(final String sourceData, final String channel, final NotificationType notificationType) {
        super(sourceData);
        this.sourceData = sourceData;
        this.notificationType = notificationType;
        this.channel = channel;
    }

    /**
     * Method to get the notification type.
     * @return NotificationType
     */
    public NotificationType getNotificationType() {
        return notificationType;
    }

    /**
     * Method to get the channel.
     * @return String
     */
    public String getChannel() {
        return channel;
    }

    /**
     * Method to return the sourceData.
     * @return String
     */
    public String getSourceData() {
        return sourceData;
    }


}
