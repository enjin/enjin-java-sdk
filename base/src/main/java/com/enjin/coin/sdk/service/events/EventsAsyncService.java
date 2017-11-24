package com.enjin.coin.sdk.service.events;

import java.util.concurrent.Future;

import com.enjin.coin.sdk.vo.event.GetEventRequestVO;
import com.enjin.coin.sdk.vo.event.GetEventResponseVO;

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
}
