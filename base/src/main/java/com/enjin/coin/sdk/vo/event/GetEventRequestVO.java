package com.enjin.coin.sdk.vo.event;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@Gson.TypeAdapters(emptyAsNulls = true)
public abstract class GetEventRequestVO {

    @SerializedName("auth")
    public abstract Optional<String> getAuth();

    @SerializedName("event_id")
    public abstract Optional<String> getEventId();

    @Override
    public String toString() {
        return "GetEventRequestVO [auth=" + getAuth().orElse(null) + ", eventId=" + getEventId().orElse(null) + "]";
    }

}
