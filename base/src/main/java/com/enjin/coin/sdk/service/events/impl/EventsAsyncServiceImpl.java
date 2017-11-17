package com.enjin.coin.sdk.service.events.impl;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.events.EventsAsyncService;
import com.enjin.coin.sdk.vo.event.GetEventRequestVO;
import com.enjin.coin.sdk.vo.event.GetEventResponseVO;
import com.enjin.coin.sdk.vo.event.ListEventsRequestVO;
import com.enjin.coin.sdk.vo.event.ListEventsResponseVO;

import java.util.concurrent.Future;

/**
 * <p>Asynchronous implementation of EventsService.</p>
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
    public Future<GetEventResponseVO> getEventAsync(final GetEventRequestVO request) {
        return getExecutorService().submit(() -> getEvent(request));
    }

    @Override
    public Future<ListEventsResponseVO> listEventsAsync(final ListEventsRequestVO request) {
        return getExecutorService().submit(() -> listEvents(request));
    }

}
