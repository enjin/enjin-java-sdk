package com.enjin.coin.sdk.vo.event;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Map;

@Value.Immutable
@Gson.TypeAdapters
public abstract class GetEventDataBalancesVO {

    @Nullable
    @SerializedName("identity")
    public abstract Map<String, Object> getIdentityMap();

    @Nullable
    @SerializedName("from")
    public abstract Map<String, Object> getFromMap();

    @Nullable
    @SerializedName("pending")
    public abstract Map<String, Object> getPendingMap();

    @Nullable
    @SerializedName("confirmed")
    public abstract Map<String, Object> getConfirmedMap();

}
