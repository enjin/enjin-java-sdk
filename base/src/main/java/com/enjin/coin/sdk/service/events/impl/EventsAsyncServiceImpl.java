package com.enjin.coin.sdk.service.events.impl;

import java.util.concurrent.CompletableFuture;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.events.EventsAsyncService;
import com.enjin.coin.sdk.vo.event.GetEventRequestVO;
import com.enjin.coin.sdk.vo.event.GetEventResponseVO;

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
