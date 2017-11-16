package com.enjin.coin.sdk.service.events;

import java.util.concurrent.Future;
import java.util.logging.Logger;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.util.StringUtils;
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
public class EventsAsyncService extends EventsService implements EventAsyncService {

	private static final Logger LOGGER = Logger.getLogger(EventsAsyncService.class.getName());

	/**
	 * Class constructor
	 *
	 * @param enjinConfig
	 *            - the enjinConfig to use
	 */
	public EventsAsyncService(Config enjinConfig) {
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
			GetEventResponseVO getEventResponseVO = null;

			try {
				getEventResponseVO = getEvent(getEventRequestVO);
			} catch (Exception ex) {
				LOGGER.warning(String.format("An Exception has occured. Exception: %s", StringUtils.exceptionToString(ex)));
			}

			return getEventResponseVO;
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
			ListEventsResponseVO listEventsResponseVO = null;

			try {
				listEventsResponseVO = listEvents(listEventsRequestVO);
			} catch (Exception ex) {
				LOGGER.warning(String.format("An Exception has occured. Exception: %s", StringUtils.exceptionToString(ex)));
			}

			return listEventsResponseVO;
		});
	}

}
