package com.enjin.coin.sdk.vo.event;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

@Value.Immutable
@Gson.TypeAdapters
public abstract class ListEventsRequestVO {

    @Nullable
    @SerializedName("auth")
    public abstract String getAuth();

    @Nullable
    @SerializedName("app_id")
    public abstract String getAppId();

    @Nullable
    @SerializedName("after_event_id")
    public abstract String getAfterEventId();

    @Nullable
    @SerializedName("limit")
    public abstract String getLimit();

    @Override
    public String toString() {
        return "ListEventsRequestVO [auth=" + getAuth() + ", appId=" + getAppId() + ", afterEventId=" + getAfterEventId() + ", limit="
                + getLimit() + "]";
    }

}
