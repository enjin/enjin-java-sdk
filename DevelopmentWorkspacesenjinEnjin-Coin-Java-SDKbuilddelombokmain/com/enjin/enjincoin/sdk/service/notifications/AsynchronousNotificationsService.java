package com.enjin.enjincoin.sdk.service.notifications;

import java.util.concurrent.CompletableFuture;

public interface AsynchronousNotificationsService {

    void startAsync(CompletableFuture<Boolean> future);

    void restartAsync(CompletableFuture<Boolean> future);

}
