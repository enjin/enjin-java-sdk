package io.enjincoin.sdk.client.service.events.impl;

import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.events.EventsAsyncService;
import io.enjincoin.sdk.client.vo.event.GetEventRequestVO;
import io.enjincoin.sdk.client.vo.event.GetEventResponseVO;

import java.util.concurrent.CompletableFuture;

/**
 * <p>
 * Asynchronous implementation of EventsService.
 * </p>
 */
public final class EventsAsyncServiceImpl extends EventsServiceImpl implements EventsAsyncService {

    /**
     * Class constructor.
     *
     * @param config - the config to use
     */
    public EventsAsyncServiceImpl(final Config config) {
        super(config);
    }

    @Override
    public CompletableFuture<GetEventResponseVO[]> getEventAsync(final GetEventRequestVO request) {
        return CompletableFuture.supplyAsync(() -> getEvent(request), getExecutorService());
    }

}
