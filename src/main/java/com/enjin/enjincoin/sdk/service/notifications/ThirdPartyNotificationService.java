package com.enjin.enjincoin.sdk.service.notifications;

import java.math.BigInteger;
import java.util.List;

/**
 * An interface that defines required methods for a 3rd party service such as Pusher.
 *
 * @author Evan Lindsay
 */
public interface ThirdPartyNotificationService {

    /**
     * Initializes the 3rd party service.
     *
     * @return true if init success, else false.
     */
    boolean init();

    /**
     * Shuts down the 3rd party service.
     */
    void shutdown();

    /**
     * Sets the list of notification listeners.
     *
     * @param notificationListeners the listeners.
     */
    void setNotificationListeners(List<NotificationListenerRegistration> notificationListeners);

    /**
     * Opens a channel for the specified identity id, allowing listeners
     * to receive link events for that identity.
     *
     * @param identityId the identity id.
     */
    void listenForLink(BigInteger identityId);

    /**
     * Closes a channel for the specified identity id, preventing listeners
     * from receiving link events for that identity.
     *
     * @param identityId the identity id.
     */
    void stopListeningForLink(BigInteger identityId);

    /**
     * Returns whether or not a channel is open for the specified identity id.
     *
     * @param identityId the identity id.
     *
     * @return true if listening, else false.
     */
    boolean isListeningForLink(BigInteger identityId);
}
