package com.enjin.coin.sdk.service.events;

import com.enjin.coin.sdk.vo.event.GetEventRequestVO;
import com.enjin.coin.sdk.vo.event.GetEventResponseVO;

/**
 * Events service interface.
 */
public interface EventsService {

    /**
     * Method to get an event.
     *
     * @param request - get event request vo
     * @return - GetEventResponseVO
     */
    GetEventResponseVO getEvent(GetEventRequestVO request);
}
