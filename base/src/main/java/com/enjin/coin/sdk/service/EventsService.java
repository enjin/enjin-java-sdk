package com.enjin.coin.sdk.service;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.enjin.coin.sdk.util.Constants;
import com.enjin.coin.sdk.util.ValidationUtils;
import com.enjin.coin.sdk.vo.event.GetEventRequestVO;
import com.enjin.coin.sdk.vo.event.GetEventResponseVO;
import com.enjin.coin.sdk.vo.event.ListEventsRequestVO;
import com.enjin.coin.sdk.vo.event.ListEventsResponseVO;

public class EventsService extends BaseService{

	private static final Logger LOGGER = Logger.getLogger(EventsService.class.getName());
	
	/**
	 * Class constructor
	 */
	public EventsService() {
		
	}

	/**
	 * Class constructor
	 * @param trustedPlatformUrl
	 */
	public EventsService(String trustedPlatformUrl) {
		super(trustedPlatformUrl);
	}
	
	/**
	 * Class constructor
	 * @param inTestMode
	 */
	public EventsService(boolean inTestMode) {
		super(inTestMode);
	}
	
	/**
	 * Class constructor
	 * @param trustedPlatformUrl
	 * @param inTestMode
	 */
	public EventsService(String trustedPlatformUrl, boolean inTestMode) {
		super(trustedPlatformUrl, inTestMode);
	}
	
	
	/**
	 * Method to get an event
	 * @param getEventRequestVO
	 * @return
	 */
	public GetEventResponseVO getEvent(GetEventRequestVO getEventRequestVO) {
		GetEventResponseVO getEventResponseVO = null;

		if (getEventRequestVO == null || ValidationUtils.isEmpty(getEventRequestVO.getAuth()) || ValidationUtils.isEmpty(getEventRequestVO.getEventId())) {
			LOGGER.warning("getEventRequestVO is null, auth or eventId passed in are null or empty");
			return getEventResponseVO;
		}		

		Map<String,Object> params = new HashMap<String,Object>();
		params.put("auth",  getEventRequestVO.getAuth());
		params.put("event_id",  getEventRequestVO.getEventId());

		// Construct new request
		String method = Constants.METHOD_EVENTS_GET;

		getEventResponseVO = (GetEventResponseVO) jsonRpcUtils.sendJsonRpcRequest(getEventsUrl(), GetEventResponseVO.class, method, params);

		return getEventResponseVO;
	}
	
	/**
	 * Method to list the events
	 * @param listEventsRequestVO
	 * @return
	 */
	public ListEventsResponseVO listEvents(ListEventsRequestVO listEventsRequestVO) {
		ListEventsResponseVO listEventsResponseVO = null;

		if (listEventsRequestVO == null || ValidationUtils.isEmpty(listEventsRequestVO.getAuth()) || ValidationUtils.isEmpty(listEventsRequestVO.getAppId()) || ValidationUtils.isEmpty(listEventsRequestVO.getAfterEventId()) || ValidationUtils.isEmpty(listEventsRequestVO.getLimit())) {
			LOGGER.warning("listEventsRequestVO is null, auth, appId, afterEventId or limit passed in are null or empty");
			return listEventsResponseVO;
		}
		
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("auth",  listEventsRequestVO.getAuth());
		params.put("app_id",  listEventsRequestVO.getAppId());
		params.put("after_Event_id", listEventsRequestVO.getAfterEventId());
		params.put("limit", listEventsRequestVO.getLimit());

		// Construct new request
		String method = Constants.METHOD_EVENTS_LIST;

		GetEventResponseVO[] getEventResponseVOArray = (GetEventResponseVO[]) jsonRpcUtils.sendJsonRpcRequest(getEventsUrl(), GetEventResponseVO[].class, method, params);
		if (ValidationUtils.isEmpty(getEventResponseVOArray)) {
			LOGGER.warning("No Events returned");
			return listEventsResponseVO;
		}
		listEventsResponseVO = new ListEventsResponseVO();
		listEventsResponseVO.setGetEventsResponseVOArray(getEventResponseVOArray);
		
		return listEventsResponseVO;
	}
}
