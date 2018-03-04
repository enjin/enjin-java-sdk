package io.enjincoin.sdk.client.service.legacy.events;

import io.enjincoin.sdk.client.vo.event.GetEventRequestVO;
import io.enjincoin.sdk.client.vo.event.GetEventResponseVO;

/**
 * Events service interface.
 */
public interface SynchronousEventsService {

    /**
     * Method to get an event.
     *
     * @param request - get event request vo
     *
     * @return - GetEventResponseVO
     */
    GetEventResponseVO[] getEventsSync(GetEventRequestVO request);
}
