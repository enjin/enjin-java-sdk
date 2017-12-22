package com.enjin.coin.sdk.service.events.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.BaseService;
import com.enjin.coin.sdk.service.events.EventsService;
import com.enjin.coin.sdk.util.Constants;
import com.enjin.coin.sdk.util.MapUtils;
import com.enjin.coin.sdk.util.ObjectUtils;
import com.enjin.coin.sdk.util.StringUtils;
import com.enjin.coin.sdk.vo.event.GetEventRequestVO;
import com.enjin.coin.sdk.vo.event.GetEventResponseVO;

/**
 * <p>
 * Synchronous implementation of EventsService.
 * </p>
 */
public class EventsServiceImpl extends BaseService implements EventsService {

    /**
     * Logger used by this class.
     */
    private static final Logger LOGGER = Logger.getLogger(EventsServiceImpl.class.getName());

    /**
     * Class constructor.
     *
     * @param config - the config to use
     */
    public EventsServiceImpl(final Config config) {
        super(config);
    }

    @Override
    public final GetEventResponseVO[] getEvent(final GetEventRequestVO getEventRequestVO) {
        GetEventResponseVO[] response = null;

        if (ObjectUtils.isNull(getEventRequestVO)) {
            LOGGER.warning("Events.get request is null.");
            return response;
        }

        Map<String, Object> params = new HashMap<>();

        if (StringUtils.isNotEmpty(getEventRequestVO.getAuth())) {
            getEventRequestVO.getAuth().ifPresent(auth -> params.put("auth", auth));
        }
        if (StringUtils.isNotEmpty(getEventRequestVO.getAppId())) {
            getEventRequestVO.getAppId().ifPresent(appId -> params.put("app_id", appId));
        }
        if (MapUtils.isNotEmpty(getEventRequestVO.getIdentityMap())) {
            getEventRequestVO.getIdentityMap().ifPresent(identity -> params.put("identity", identity));
        }
        if (StringUtils.isNotEmpty(getEventRequestVO.getAfterEventId())) {
            getEventRequestVO.getAfterEventId().ifPresent(afterEventId -> params.put("after_event_id", afterEventId));
        }
        if (StringUtils.isNotEmpty(getEventRequestVO.getLimit())) {
            getEventRequestVO.getLimit().ifPresent(limit -> params.put("limit", limit));
        }

        // Construct new request
        String method = Constants.METHOD_EVENTS_GET;
        response = (GetEventResponseVO[]) getJsonRpcUtils().sendJsonRpcRequest(getEventsUrl(), GetEventResponseVO[].class, method, params);
        return response;
    }

}
