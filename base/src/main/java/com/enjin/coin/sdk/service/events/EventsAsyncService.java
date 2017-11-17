package com.enjin.coin.sdk.service.events;

import com.enjin.coin.sdk.vo.event.GetEventRequestVO;
import com.enjin.coin.sdk.vo.event.GetEventResponseVO;
import com.enjin.coin.sdk.vo.event.ListEventsRequestVO;
import com.enjin.coin.sdk.vo.event.ListEventsResponseVO;

import java.util.concurrent.Future;

/**
 * Asynchronous Events service interface.
 */
public interface EventsAsyncService extends EventsService {

    /**
     * Method to get an event.
     *
     * @param request - get event request vo
     * @return - GetEventResponseVO
     */
    Future<GetEventResponseVO> getEventAsync(GetEventRequestVO request);

    /**
     * Method to list the events.
     *
     * @param request - list events request vo
     * @return - ListEventsResponseVO
     */
    Future<ListEventsResponseVO> listEventsAsync(ListEventsRequestVO request);

}
