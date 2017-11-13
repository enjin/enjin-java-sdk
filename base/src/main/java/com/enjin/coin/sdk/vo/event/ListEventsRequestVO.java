package com.enjin.coin.sdk.vo.event;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@Gson.TypeAdapters
public abstract class ListEventsRequestVO {

    @SerializedName("auth")
    public abstract Optional<String> getAuth();

    @SerializedName("app_id")
    public abstract Optional<String> getAppId();

    @SerializedName("after_event_id")
    public abstract Optional<String> getAfterEventId();

    @SerializedName("limit")
    public abstract Optional<String> getLimit();

    @Override
    public String toString() {
        return "ListEventsRequestVO [auth=" + getAuth().orElse(null) + ", appId=" + getAppId().orElse(null) + ", afterEventId="
                + getAfterEventId().orElse(null) + ", limit=" + getLimit().orElse(null) + "]";
    }

}
