package io.enjincoin.sdk.client.vo.notifications;

import io.enjincoin.sdk.client.annotations.immutables.Nullable;
import io.enjincoin.sdk.client.enums.NotificationType;
import org.immutables.value.Value;

/**
 * <p> Bean used when a notification event is triggered.</p>
 */
@Value.Immutable
public abstract class NotificationEvent {

    /**
     * Method to get the notification type.
     * @return NotificationType
     */
    @Nullable
    public abstract NotificationType getNotificationType();

    /**
     * Method to get the channel.
     * @return String
     */
    @Nullable
    public abstract String getChannel();

    /**
     * Method to return the sourceData.
     * @return String
     */
    @Nullable
    public abstract String getSourceData();


}
