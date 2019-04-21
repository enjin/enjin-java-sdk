package com.enjin.enjincoin.sdk.service.notifications;

import java.math.BigInteger;
import java.util.List;

/**
 * <p>Interface for any third party notification systems such as pusher.</p>
 */
public interface ThirdPartyNotificationService {

    /**
     * Method to initialize the notification service.
     *
     * @return boolean
     */
    boolean init();

    /**
     * Method to shut down the notification service.
     */
    void shutdown();

    /**
     * Method to set the notification listeners.
     *
     * @param notificationListeners the new list of listeners to set
     */
    void setNotificationListeners(List<NotificationListenerRegistration> notificationListeners);

    void listenForLink(BigInteger identityId);

    void stopListeningForLink(BigInteger identityId);

    boolean isListeningForLink(BigInteger identityId);
}
