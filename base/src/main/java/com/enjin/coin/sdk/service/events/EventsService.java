package com.enjin.coin.sdk.service.events;

import com.enjin.coin.sdk.vo.event.GetEventRequestVO;
import com.enjin.coin.sdk.vo.event.GetEventResponseVO;
import com.enjin.coin.sdk.vo.event.ListEventsRequestVO;
import com.enjin.coin.sdk.vo.event.ListEventsResponseVO;

public interface EventsService {

    /**
     * Method to get an event
     *
     * @param getEventRequestVO - get event request vo
     * @return - GetEventResponseVO
     */
    GetEventResponseVO getEvent(GetEventRequestVO getEventRequestVO);

    /**
     * Method to list the events
     *
     * @param listEventsRequestVO - list events request vo
     * @return - ListEventsResponseVO
     */
    ListEventsResponseVO listEvents(ListEventsRequestVO listEventsRequestVO);

}
