package com.enjin.coin.sdk.vo.event;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class GetEventDataBalancesVO {

    @SerializedName("identity")
    private Map<String, Object> identityMap;

    @SerializedName("from")
    private Map<String, Object> fromMap;

    @SerializedName("pending")
    private Map<String, Object> pendingMap;

    @SerializedName("confirmed")
    private Map<String, Object> confirmedMap;

    public Map<String, Object> getIdentityMap() {
        return identityMap;
    }

    public Map<String, Object> getFromMap() {
        return fromMap;
    }
    public Map<String, Object> getPendingMap() {
        return pendingMap;
    }

    public Map<String, Object> getConfirmedMap() {
        return confirmedMap;
    }
}
