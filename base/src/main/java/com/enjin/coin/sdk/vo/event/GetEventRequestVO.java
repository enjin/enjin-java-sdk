package com.enjin.coin.sdk.vo.event;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

/**
 * <p>Get Event Request class.</p>
 */
@Value.Immutable
@Gson.TypeAdapters(emptyAsNulls = true)
public abstract class GetEventRequestVO {

	/**
	 * Method to get the auth.
	 * @return Optional<String>
	 */
    @SerializedName("auth")
    public abstract Optional<String> getAuth();

	/**
	 * Method to get the eventId.
	 * @return Optional<String>
	 */
    @SerializedName("event_id")
    public abstract Optional<String> getEventId();

    /**
     * Class toString method.
     */
    @Override
    public String toString() {
        return "GetEventRequestVO [auth=" + getAuth().orElse(null) + ", eventId=" + getEventId().orElse(null) + "]";
    }

}
