package com.enjin.coin.sdk.service.events;

import java.util.concurrent.CompletableFuture;

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
    CompletableFuture<GetEventResponseVO[]> getEventAsync(GetEventRequestVO request);
}
