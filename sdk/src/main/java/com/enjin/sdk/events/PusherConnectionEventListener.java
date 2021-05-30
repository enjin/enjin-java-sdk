package com.enjin.sdk.events;

import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionState;
import com.pusher.client.connection.ConnectionStateChange;

import java.util.concurrent.CompletableFuture;

/**
 * Listens for connection events received by a Pusher client and contains futures for connecting and disconnecting. Used
 * internally.
 *
 * @see com.pusher.client.Pusher
 * @see PusherNotificationService
 */
class PusherConnectionEventListener implements ConnectionEventListener {

    // Futures
    private final CompletableFuture<Void> connectFutureFirst = new CompletableFuture<>();
    private final CompletableFuture<Void> disconnectFutureFirst = new CompletableFuture<>();
    private CompletableFuture<Void> connectFutureLast = connectFutureFirst;
    private CompletableFuture<Void> disconnectFutureLast = disconnectFutureFirst;

    // Mutexes
    private final Object connectedFutureMutex = new Object();
    private final Object disconnectedFutureMutex = new Object();

    @Override
    public void onConnectionStateChange(ConnectionStateChange change) {
        final ConnectionState previousState = change.getPreviousState();
        final ConnectionState currentState = change.getCurrentState();

        if (previousState == ConnectionState.CONNECTING && currentState == ConnectionState.CONNECTED)
            synchronized (connectedFutureMutex) {
                connectFutureFirst.complete(null); // Only completes if not already completed
            }
        else if (previousState == ConnectionState.DISCONNECTING && currentState == ConnectionState.DISCONNECTED)
            synchronized (disconnectedFutureMutex) {
                disconnectFutureFirst.complete(null); // Only completes if not already completed
            }
    }

    @Override
    public void onError(String message, String code, Exception e) {
        synchronized (connectedFutureMutex) {
            connectFutureFirst.completeExceptionally(e); // Only completes exceptionally if not already completed
        }
    }

    /**
     * Appends an action to the chain of futures for connecting.
     *
     * @param action the action to be appended
     * @return the future with the appended action
     */
    public CompletableFuture<Void> appendConnectAction(Runnable action) {
        synchronized (connectedFutureMutex) {
            connectFutureLast = connectFutureLast.thenRun(action);
            return connectFutureLast;
        }
    }

    /**
     * Appends an action to the chain of futures for disconnecting.
     *
     * @param action the action to be appended
     * @return the future with the appended action
     */
    public CompletableFuture<Void> appendDisconnectAction(Runnable action) {
        synchronized (disconnectedFutureMutex) {
            disconnectFutureLast = disconnectFutureLast.thenRun(action);
            return disconnectFutureLast;
        }
    }

    /**
     * Returns the future at the end of the chain used for connecting.
     *
     * @return the future
     */
    public CompletableFuture<Void> getConnectFuture() {
        synchronized (connectedFutureMutex) {
            return connectFutureLast;
        }
    }

    /**
     * Returns the future at the end of the chain used for disconnecting.
     *
     * @return the future
     */
    public CompletableFuture<Void> getDisconnectFuture() {
        synchronized (disconnectedFutureMutex) {
            return disconnectFutureLast;
        }
    }

}
