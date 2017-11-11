package com.enjin.coin.sdk.vo.identity;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class UpdateIdentityResponseVO {

    @SerializedName("identity")
    private Map<String, Object> identityMap;

    public Map<String, Object> getIdentityMap() {
        return identityMap;
    }

    @Override
    public String toString() {
        return "UpdateIdentityResponseVO [identityMap=" + identityMap + "]";
    }


}
