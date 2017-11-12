package com.enjin.coin.sdk.vo.identity;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;

import java.util.Map;

@Gson.TypeAdapters
public abstract class BaseIdentityRequestVO {

    @Nullable
    @SerializedName("auth")
    public abstract String getAuth();

    @Nullable
    @SerializedName("identity")
    public abstract Map<String, Object> getIdentity();

    @Override
    public String toString() {
        return "BaseIdentityRequestVO [auth=" + getAuth() + ", identity=" + getIdentity() + "]";
    }

}
