package com.enjin.coin.sdk.vo.event;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Arrays;
import java.util.Optional;

@Value.Immutable
@Gson.TypeAdapters
public abstract class ListEventsResponseVO {

    @SerializedName("getEventResponseVOArray")
    public abstract Optional<GetEventResponseVO[]> getGetEventsResponseVOArray();

    @Override
    public String toString() {
        return "ListEventsResponseVO [getEventsResponseVOArray=" + Arrays.toString(getGetEventsResponseVOArray().orElse(null)) + "]";
    }

}
