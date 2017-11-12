package com.enjin.coin.sdk.vo.identity;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

@Value.Immutable
@Gson.TypeAdapters
public abstract class DeleteIdentityResponseVO {

    @Nullable
    @SerializedName("result")
    public abstract Boolean getResult();

    @Override
    public String toString() {
        return "DeleteIdentityResponseVO [result=" + getResult() + "]";
    }

}

