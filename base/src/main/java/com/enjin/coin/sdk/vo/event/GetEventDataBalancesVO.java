package com.enjin.coin.sdk.vo.event;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Map;
import java.util.Optional;

@Value.Immutable
@Gson.TypeAdapters
public abstract class GetEventDataBalancesVO {

    @SerializedName("identity")
    public abstract Optional<Map<String, Object>> getIdentityMap();

    @SerializedName("from")
    public abstract Optional<Map<String, Object>> getFromMap();

    @SerializedName("pending")
    public abstract Optional<Map<String, Object>> getPendingMap();

    @SerializedName("confirmed")
    public abstract Optional<Map<String, Object>> getConfirmedMap();

}
