package com.enjin.coin.sdk.vo.event;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Map;

@Value.Immutable
@Gson.TypeAdapters
public abstract class GetEventDataBalancesVO {

    @SerializedName("identity")
    public abstract Map<String, Object> getIdentityMap();

    @SerializedName("from")
    public abstract Map<String, Object> getFromMap();

    @SerializedName("pending")
    public abstract Map<String, Object> getPendingMap();

    @SerializedName("confirmed")
    public abstract Map<String, Object> getConfirmedMap();
}
