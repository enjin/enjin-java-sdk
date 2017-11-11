package com.enjin.coin.sdk.vo.identity;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class UpdateIdentityResponseVO {

    @SerializedName("identity")
    private Map<String, Object> identityMap;

    public Map<String, Object> getIdentityMap() {
        return identityMap;
    }

    public void setIdentityMap(Map<String, Object> identityMap) {
        this.identityMap = identityMap;
    }
}
