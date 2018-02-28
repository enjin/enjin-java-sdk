package io.enjincoin.sdk.client.service.events.impl;

import com.enjin.java_commons.MapUtils;
import com.enjin.java_commons.ObjectUtils;
import com.enjin.java_commons.OptionalUtils;
import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.BaseService;
import io.enjincoin.sdk.client.service.events.EventsService;
import io.enjincoin.sdk.client.util.Constants;
import io.enjincoin.sdk.client.vo.event.GetEventRequestVO;
import io.enjincoin.sdk.client.vo.event.GetEventResponseVO;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

/**
 * <p>
 * Asynchronous implementation of SynchronousEventsService.
 * </p>
 */
public final class EventsServiceImpl extends BaseService implements EventsService {

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
    public CompletableFuture<GetEventResponseVO[]> getEventsAsync(final GetEventRequestVO request) {
        return CompletableFuture.supplyAsync(() -> this.getEventsSync(request), this.getExecutorService());
    }

    @Override
    public final GetEventResponseVO[] getEventsSync(final GetEventRequestVO getEventRequestVO) {
        GetEventResponseVO[] response = null;

        if (ObjectUtils.isNull(getEventRequestVO)) {
            LOGGER.warning("Events.get request is null.");
            return response;
        }

        Map<String, Object> params = new HashMap<>();

        if (OptionalUtils.isStringPresent(getEventRequestVO.getEventId())) {
            getEventRequestVO.getEventId().ifPresent(eventId -> params.put("event_id", eventId));
        }
        if (OptionalUtils.isStringPresent(getEventRequestVO.getAppId())) {
            getEventRequestVO.getAppId().ifPresent(appId -> params.put("app_id", appId));
        }
        if (OptionalUtils.isMapPresent(getEventRequestVO.getIdentityMap())) {
            getEventRequestVO.getIdentityMap().ifPresent(identity -> params.put("identity", identity));
        }
        if (OptionalUtils.isStringPresent(getEventRequestVO.getAfterEventId())) {
            getEventRequestVO.getAfterEventId().ifPresent(afterEventId -> params.put("after_event_id", afterEventId));
        }
        if (OptionalUtils.isStringPresent(getEventRequestVO.getBeforeEventId())) {
            getEventRequestVO.getBeforeEventId().ifPresent(beforeEventId -> params.put("before_event_id", beforeEventId));
        }
        if (OptionalUtils.isStringPresent(getEventRequestVO.getLimit())) {
            getEventRequestVO.getLimit().ifPresent(limit -> params.put("limit", limit));
        }

        // Construct new request
        String method = Constants.METHOD_EVENTS_GET;
        response = (GetEventResponseVO[]) this.getJsonRpcUtils().sendJsonRpcRequest(this.getEventsUrl(), GetEventResponseVO[].class, method, params);
        return response;
    }

}
