package com.enjin.coin.sdk.vo.event;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

/**
 * <p>
 * List Events Request class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class ListEventsRequestVO {

    /**
     * Method to get the auth.
     * @return Optional
     */
    @SerializedName("auth")
    public abstract Optional<String> getAuth();

    /**
     * Method to get the appUd.
     * @return Optional
     */
    @SerializedName("app_id")
    public abstract Optional<String> getAppId();

    /**
     * Method to get the afterEventId.
     * @return Optional
     */
    @SerializedName("after_event_id")
    public abstract Optional<String> getAfterEventId();

    /**
     * Method to get the limit.
     * @return Optional
     */
    @SerializedName("limit")
    public abstract Optional<String> getLimit();

    /**
     * Class toString method.
     */
    @Override
    public String toString() {
        return "ListEventsRequestVO [auth=" + getAuth().orElse(null) + ", appId=" + getAppId().orElse(null) + ", afterEventId=" + getAfterEventId().orElse(null)
                + ", limit=" + getLimit().orElse(null) + "]";
    }

}
