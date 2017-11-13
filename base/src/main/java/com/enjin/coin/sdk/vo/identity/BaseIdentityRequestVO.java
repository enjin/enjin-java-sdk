package com.enjin.coin.sdk.vo.identity;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;

import java.util.Map;
import java.util.Optional;

@Gson.TypeAdapters
public abstract class BaseIdentityRequestVO {

    @SerializedName("auth")
    public abstract Optional<String> getAuth();

    @SerializedName("identity")
    public abstract Optional<Map<String, Object>> getIdentity();

    @Override
    public String toString() {
        return "BaseIdentityRequestVO [auth=" + getAuth().orElse(null) + ", identity="
                + getIdentity().orElse(null) + "]";
    }

}
