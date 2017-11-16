package com.enjin.coin.sdk.service.events;

import com.enjin.coin.sdk.vo.event.GetEventRequestVO;
import com.enjin.coin.sdk.vo.event.GetEventResponseVO;
import com.enjin.coin.sdk.vo.event.ListEventsRequestVO;
import com.enjin.coin.sdk.vo.event.ListEventsResponseVO;

import java.util.concurrent.Future;

public interface EventServiceAsync extends EventService {

    /**
     * Method to get an event
     *
     * @param getEventRequestVO - get event request vo
     * @return - GetEventResponseVO
     */
    Future<GetEventResponseVO> getEventAsync(GetEventRequestVO getEventRequestVO);

    /**
     * Method to list the events
     *
     * @param listEventsRequestVO - list events request vo
     * @return - ListEventsResponseVO
     */
    Future<ListEventsResponseVO> listEventsAsync(ListEventsRequestVO listEventsRequestVO);

}
