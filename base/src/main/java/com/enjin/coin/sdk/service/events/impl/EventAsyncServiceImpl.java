package com.enjin.coin.sdk.service.events.impl;

import java.util.concurrent.Future;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.events.EventAsyncService;
import com.enjin.coin.sdk.vo.event.GetEventRequestVO;
import com.enjin.coin.sdk.vo.event.GetEventResponseVO;
import com.enjin.coin.sdk.vo.event.ListEventsRequestVO;
import com.enjin.coin.sdk.vo.event.ListEventsResponseVO;

/**
 * <p>
 * Contains services related to events
 * </p>
 *
 * @author damien
 */
public class EventAsyncServiceImpl extends EventServiceImpl implements EventAsyncService {

	/**
	 * Class constructor
	 *
	 * @param enjinConfig
	 *            - the enjinConfig to use
	 */
	public EventAsyncServiceImpl(Config enjinConfig) {
		super(enjinConfig);
	}

	/**
	 * Method to get a future event
	 *
	 * @param getEventRequestVO
	 *            - get event request vo
	 * @return - Future<GetEventResponseVO>
	 */
	public Future<GetEventResponseVO> getEventAsync(GetEventRequestVO getEventRequestVO) {
		return executorService.submit(() -> {
			return getEvent(getEventRequestVO);
		});
	}

	/**
	 * Method to list the events
	 *
	 * @param listEventsRequestVO
	 *            - list events request vo
	 * @return - Future<ListEventsResponseVO>
	 */
	public Future<ListEventsResponseVO> listEventsAsync(ListEventsRequestVO listEventsRequestVO) {
		return executorService.submit(() -> {
			return listEvents(listEventsRequestVO);
		});
	}

}
