package com.enjin.coin.sdk.vo.notifications;

import java.util.EventObject;

import com.enjin.coin.sdk.enums.NotificationType;

/**
 * <p> Bean used when a notification event is triggered</p>
 *
 */
public class NotificationEvent extends EventObject {

    /**
     * Notification type received.
     */
    private NotificationType notificationType;

    /**
     * Channel event came from
     */
    private String channel;
    /**
     *
     */
    private static final long serialVersionUID = 6714115003936048276L;

    /**
     * Class constructor.
     * @param arg0
     */
    public NotificationEvent(String source, String channel, NotificationType notificationType) {
        super(source);
        this.notificationType = notificationType;
        this.channel = channel;
    }

    /**
     * Method to get the notification type
     * @return NotificationType
     */
    public NotificationType getNotificationType() {
        return notificationType;
    }

    public String getChannel() {
        return channel;
    }
}
