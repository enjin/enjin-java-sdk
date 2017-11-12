package com.enjin.coin.sdk.vo.identity;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Map;

@Value.Immutable
@Gson.TypeAdapters
public abstract class UpdateIdentityResponseVO {

    @Nullable
    @SerializedName("identity")
    public abstract Map<String, Object> getIdentityMap();

    @Override
    public String toString() {
        return "UpdateIdentityResponseVO [identityMap=" + getIdentityMap() + "]";
    }

}
