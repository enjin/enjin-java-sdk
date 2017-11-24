package com.enjin.coin.sdk.vo.event;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

/**
 * <p>
 * Get Event Response class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters(emptyAsNulls = true)
public abstract class GetEventResponseVO {

    /**
     * Method to get the event details responseVOArray.
     * @return Optional
     */
    @SerializedName("result")
    public abstract Optional<GetEventDetailsResponseVO[]> eventDetailsResponseVOArray();

}
