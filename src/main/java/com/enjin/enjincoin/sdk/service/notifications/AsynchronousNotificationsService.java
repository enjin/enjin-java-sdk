package com.enjin.enjincoin.sdk.service.notifications;

import java.util.concurrent.CompletableFuture;

/**
 * A notification service interface for asynchronous calls.
 *
 * @author Evan Lindsay
 */
public interface AsynchronousNotificationsService {

    /**
     * Starts the service. Accepts a future that will receive whether the
     * service has started successfully or not.
     *
     * @param future the future.
     */
    void startAsync(CompletableFuture<Boolean> future);

    /**
     * Restarts the service. Accepts a future that will receive whether the service
     * has restarted successfully or not.
     *
     * @param future the future.
     */
    void restartAsync(CompletableFuture<Boolean> future);

}
