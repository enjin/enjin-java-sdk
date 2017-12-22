package com.enjin.coin.sdk.vo.event;

import java.util.Map;
import java.util.Optional;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Get Event Request class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters(emptyAsNulls = true)
public abstract class GetEventRequestVO {

    /**
     * Method to get the eventId.
     *
     * @return Optional
     */
    @SerializedName("event_id")
    public abstract Optional<String> getEventId();

    /**
     * Method to get the appId.
     *
     * @return Optional
     */
    @SerializedName("app_id")
    public abstract Optional<String> getAppId();

    /**
     * Method to get the identityMap.
     *
     * @return Optional
     */
    @SerializedName("identity")
    public abstract Optional<Map<String, Object>> getIdentityMap();

    /**
     * Method to get the afterEventId.
     *
     * @return Optional
     */
    @SerializedName("after_event_id")
    public abstract Optional<String> getAfterEventId();

    /**
     * Method to get the beforeEventId.
     *
     * @return Optional
     */
    @SerializedName("before_event_id")
    public abstract Optional<String> getBeforeEventId();

    /**
     * Method to get the limit.
     *
     * @return Optional
     */
    @SerializedName("limit")
    public abstract Optional<String> getLimit();

    @Override
    public String toString() {
        return "GetEventRequestVO [getEventId()=" + getEventId() + ", getAppId()=" + getAppId()
                + ", getIdentityMap()=" + getIdentityMap() + ", getAfterEventId()=" + getAfterEventId()
                + ", getBeforeEventId()=" + getBeforeEventId() + ", getLimit()=" + getLimit() + "]";
    }

}
