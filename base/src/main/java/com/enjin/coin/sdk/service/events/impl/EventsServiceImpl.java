package com.enjin.coin.sdk.service.events.impl;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.BaseService;
import com.enjin.coin.sdk.service.events.EventsService;
import com.enjin.coin.sdk.util.ArrayUtils;
import com.enjin.coin.sdk.util.Constants;
import com.enjin.coin.sdk.util.ObjectUtils;
import com.enjin.coin.sdk.util.StringUtils;
import com.enjin.coin.sdk.vo.event.GetEventRequestVO;
import com.enjin.coin.sdk.vo.event.GetEventResponseVO;
import com.enjin.coin.sdk.vo.event.ImmutableListEventsResponseVO;
import com.enjin.coin.sdk.vo.event.ListEventsRequestVO;
import com.enjin.coin.sdk.vo.event.ListEventsResponseVO;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * <p>Synchronous implementation of EventsService</p>
 */
public class EventsServiceImpl extends BaseService implements EventsService {

    private static final Logger LOGGER = Logger.getLogger(EventsServiceImpl.class.getName());

    /**
     * Class constructor
     *
     * @param config - the config to use
     */
    public EventsServiceImpl(Config config) {
        super(config);
    }

    @Override
    public GetEventResponseVO getEvent(GetEventRequestVO request) {
        GetEventResponseVO getEventResponseVO = null;

        if (ObjectUtils.isNull(request) || StringUtils.isEmpty(request.getAuth())
                || StringUtils.isEmpty(request.getEventId())) {
            LOGGER.warning("getEventRequestVO is null, auth or eventId passed in are null or empty");
            return getEventResponseVO;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", request.getAuth().get());
        params.put("event_id", request.getEventId().get());

        // Construct new request
        String method = Constants.METHOD_EVENTS_GET;

        getEventResponseVO = (GetEventResponseVO) jsonRpcUtils.sendJsonRpcRequest(getEventsUrl(), GetEventResponseVO.class, method, params);

        return getEventResponseVO;
    }

    @Override
    public ListEventsResponseVO listEvents(ListEventsRequestVO request) {
        ListEventsResponseVO listEventsResponseVO = null;

        if (ObjectUtils.isNull(request) || StringUtils.isEmpty(request.getAuth())
                || StringUtils.isEmpty(request.getAppId())
                || StringUtils.isEmpty(request.getAfterEventId())
                || StringUtils.isEmpty(request.getLimit())) {
            LOGGER.warning("listEventsRequestVO is null, auth, appId, afterEventId or limit passed in are null or empty");
            return listEventsResponseVO;
        }

        Map<String, Object> params = new HashMap<>();
        params.put("auth", request.getAuth().get());
        params.put("app_id", request.getAppId().get());
        params.put("after_Event_id", request.getAfterEventId().get());
        params.put("limit", request.getLimit().get());

        // Construct new request
        String method = Constants.METHOD_EVENTS_LIST;

        GetEventResponseVO[] getEventResponseVOArray = (GetEventResponseVO[]) jsonRpcUtils.sendJsonRpcRequest(getEventsUrl(), GetEventResponseVO[].class, method, params);
        if (ArrayUtils.isEmpty(getEventResponseVOArray)) {
            LOGGER.warning("No Events returned");
            return listEventsResponseVO;
        }
        listEventsResponseVO = ImmutableListEventsResponseVO.builder()
                .setGetEventsResponseVOArray(getEventResponseVOArray)
                .build();

        return listEventsResponseVO;
    }

}
