package com.enjin.coin.sdk.vo.event;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@Gson.TypeAdapters(emptyAsNulls = true)
public abstract class GetEventResponseVO {

    @SerializedName("data")
    public abstract Optional<GetEventDataVO> getData();

    @SerializedName("event_id")
    public abstract Optional<String> getEventId();

    @SerializedName("event_type")
    public abstract Optional<String> getEventType();

    @SerializedName("timestamp")
    public abstract Optional<String> getTimestamp();

    @SerializedName("app_id")
    public abstract Optional<String> getAppId();

    @Override
    public String toString() {
        return "GetEventResponseVO [eventId=" + getEventId().orElse(null) + ", eventType=" + getEventType().orElse(null)
                + ", timestamp=" + getTimestamp().orElse(null) + ", appId=" + getAppId().orElse(null) + "]";
    }

}
