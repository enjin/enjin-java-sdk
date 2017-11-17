package com.enjin.coin.sdk.vo.event;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Arrays;
import java.util.Optional;

/**
 * <p>List Events Response class.</p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class ListEventsResponseVO {

	/**
	 * Get the events response array.
	 * @return Optional<GetEventResponseVO[]> 
	 */
    @SerializedName("getEventResponseVOArray")
    public abstract Optional<GetEventResponseVO[]> getGetEventsResponseVOArray();

    /**
     * Class toString method.
     */
    @Override
    public String toString() {
        return "ListEventsResponseVO [getEventsResponseVOArray=" + Arrays.toString(getGetEventsResponseVOArray().orElse(null)) + "]";
    }

}
