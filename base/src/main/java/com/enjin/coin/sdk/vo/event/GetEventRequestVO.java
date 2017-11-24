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
     * Method to get the auth.
     *
     * @return Optional
     */
    @SerializedName("auth")
    public abstract Optional<String> getAuth();

    /**
     * Method to get the eventId.
     *
     * @return Optional
     */
    @SerializedName("event_id")
    public abstract Optional<String> getEventId();

    /**
     * Method to get the identityMap.
     *
     * @return Optional
     */
    @SerializedName("identity")
    public abstract Optional<Map<String, Object>> getIdentity();

    /**
     * Method to get the afterEventId.
     *
     * @return Optional
     */
    @SerializedName("after_event_id")
    public abstract Optional<String> getAfterEventId();

    /**
     * Method to get the limit.
     *
     * @return Optional
     */
    @SerializedName("limit")
    public abstract Optional<String> getLimit();

    /**
     * Class toString method.
     */
    @Override
    public String toString() {
        return "GetEventRequestVO [auth=" + getAuth().orElse(null) + ", eventId=" + getEventId().orElse(null) + "]";
    }

}
