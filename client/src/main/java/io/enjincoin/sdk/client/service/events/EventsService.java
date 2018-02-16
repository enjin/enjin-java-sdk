package io.enjincoin.sdk.client.service.events;

import io.enjincoin.sdk.client.vo.event.GetEventRequestVO;
import io.enjincoin.sdk.client.vo.event.GetEventResponseVO;

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
    GetEventResponseVO[] getEvent(GetEventRequestVO request);
}
