package io.enjincoin.sdk.client.service.events.impl;

import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.BaseService;
import io.enjincoin.sdk.client.service.events.EventsService;
import io.enjincoin.sdk.client.util.Constants;
import io.enjincoin.sdk.client.util.MapUtils;
import io.enjincoin.sdk.client.util.ObjectUtils;
import io.enjincoin.sdk.client.util.StringUtils;
import io.enjincoin.sdk.client.vo.event.GetEventRequestVO;
import io.enjincoin.sdk.client.vo.event.GetEventResponseVO;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

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

        if (StringUtils.isNotEmpty(getEventRequestVO.getEventId())) {
            getEventRequestVO.getEventId().ifPresent(eventId -> params.put("event_id", eventId));
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
        if (StringUtils.isNotEmpty(getEventRequestVO.getBeforeEventId())) {
            getEventRequestVO.getBeforeEventId().ifPresent(beforeEventId -> params.put("before_event_id", beforeEventId));
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
