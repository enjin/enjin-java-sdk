package com.enjin.sdk.events;

/**
 * Listener for receiving notifications about the connection state of the event service.
 *
 * @see NotificationsService
 */
public interface ConnectionEventListener {

    /**
     * Callback used when the service connects to the server.
     */
    default void onConnect() {
    }

    /**
     * Callback used when the service disconnects from the server.
     */
    default void onDisconnect() {
    }

    /**
     * Callback used when the service encounters an error with its connection to the server.
     *
     * @param e the exception
     */
    default void onError(Exception e) {
    }

}
