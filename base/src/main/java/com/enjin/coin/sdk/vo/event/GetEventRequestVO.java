package com.enjin.coin.sdk.vo.event;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

@Value.Immutable
@Gson.TypeAdapters(emptyAsNulls = true)
public abstract class GetEventRequestVO {

    @Nullable
    @SerializedName("auth")
    public abstract String getAuth();

    @Nullable
    @SerializedName("event_id")
    public abstract String getEventId();

    @Override
    public String toString() {
        return "GetEventRequestVO [auth=" + getAuth() + ", eventId=" + getEventId() + "]";
    }

}
