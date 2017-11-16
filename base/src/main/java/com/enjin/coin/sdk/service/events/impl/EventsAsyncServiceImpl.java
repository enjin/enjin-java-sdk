package com.enjin.coin.sdk.service.events.impl;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.events.EventsAsyncService;
import com.enjin.coin.sdk.vo.event.GetEventRequestVO;
import com.enjin.coin.sdk.vo.event.GetEventResponseVO;
import com.enjin.coin.sdk.vo.event.ListEventsRequestVO;
import com.enjin.coin.sdk.vo.event.ListEventsResponseVO;

import java.util.concurrent.Future;

/**
 * <p>Asynchronous implementation of EventsService</p>
 */
public class EventsAsyncServiceImpl extends EventsServiceImpl implements EventsAsyncService {

    /**
     * Class constructor
     *
     * @param enjinConfig - the enjinConfig to use
     */
    public EventsAsyncServiceImpl(Config enjinConfig) {
        super(enjinConfig);
    }

    @Override
    public Future<GetEventResponseVO> getEventAsync(GetEventRequestVO getEventRequestVO) {
        return executorService.submit(() -> getEvent(getEventRequestVO));
    }

    @Override
    public Future<ListEventsResponseVO> listEventsAsync(ListEventsRequestVO listEventsRequestVO) {
        return executorService.submit(() -> listEvents(listEventsRequestVO));
    }

}
