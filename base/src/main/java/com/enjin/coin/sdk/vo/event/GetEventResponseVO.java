package com.enjin.coin.sdk.vo.event;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

@Value.Immutable
@Gson.TypeAdapters(emptyAsNulls = true)
public abstract class GetEventResponseVO {

    @Nullable
    @SerializedName("data")
    public abstract GetEventDataVO getData();

    @Nullable
    @SerializedName("event_id")
    public abstract String getEventId();

    @Nullable
    @SerializedName("event_type")
    public abstract String getEventType();

    @Nullable
    @SerializedName("timestamp")
    public abstract String getTimestamp();

    @Nullable
    @SerializedName("app_id")
    public abstract String getAppId();

    @Override
    public String toString() {
        return "GetEventResponseVO [eventId=" + getEventId() + ", eventType=" + getEventType() + ", timestamp=" + getTimestamp()
                + ", appId=" + getAppId() + "]";
    }

}
