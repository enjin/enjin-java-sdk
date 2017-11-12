package com.enjin.coin.sdk.vo.event;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Arrays;

@Value.Immutable
@Gson.TypeAdapters
public abstract class ListEventsResponseVO {

    @Nullable
    @SerializedName("getEventResponseVOArray")
    public abstract GetEventResponseVO[] getGetEventsResponseVOArray();

    @Override
    public String toString() {
        return "ListEventsResponseVO [getEventsResponseVOArray=" + Arrays.toString(getGetEventsResponseVOArray()) + "]";
    }

}
