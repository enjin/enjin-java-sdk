package io.enjincoin.sdk.client.service.notifications;

import java.util.concurrent.CompletableFuture;

public interface AsynchronousNotificationsService {

    void startAsync(CompletableFuture<Boolean> future);

    void restartAsync(CompletableFuture<Boolean> future);

}
