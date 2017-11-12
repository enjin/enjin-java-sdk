package com.enjin.coin.sdk.vo.token;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

@Value.Immutable
@Gson.TypeAdapters
public abstract class GetTokenRequestVO {

    @Nullable
    @SerializedName("token_id")
    public abstract String getTokenId();

    @Override
    public String toString() {
        return "GetTokenRequestVO [tokenId=" + getTokenId() + "]";
    }

}
