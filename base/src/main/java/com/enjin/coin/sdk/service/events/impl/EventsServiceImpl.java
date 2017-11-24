package com.enjin.coin.sdk.service.events.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.BaseService;
import com.enjin.coin.sdk.service.events.EventsService;
import com.enjin.coin.sdk.util.Constants;
import com.enjin.coin.sdk.util.ObjectUtils;
import com.enjin.coin.sdk.util.StringUtils;
import com.enjin.coin.sdk.vo.event.GetEventRequestVO;
import com.enjin.coin.sdk.vo.event.GetEventResponseVO;

/**
 * <p>Synchronous implementation of EventsService.</p>
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
    public final GetEventResponseVO[] getEvent(final GetEventRequestVO request) {
        GetEventResponseVO[] response = null;
        
        if (ObjectUtils.isNull(request)) {
            LOGGER.warning("Events.get request is null.");
            return response;
        }
        
        if (StringUtils.isEmpty(request.getAuth()) || StringUtils.isEmpty(request.getEventId())) {
            LOGGER.warning("Events.get parameters may be empty or null.");
            return response;
        }
        
        Map<String, Object> params = new HashMap<>();
        params.put("auth", request.getAuth().get());
        params.put("event_id", request.getEventId().get());
        
        // Construct new request
        String method = Constants.METHOD_EVENTS_GET;
        response = (GetEventResponseVO[]) getJsonRpcUtils().sendJsonRpcRequest(getEventsUrl(), GetEventResponseVO[].class, method, params);
        return response;
    }

}
