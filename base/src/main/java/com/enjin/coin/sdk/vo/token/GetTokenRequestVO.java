package com.enjin.coin.sdk.vo.token;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@Gson.TypeAdapters
public abstract class GetTokenRequestVO {

    @SerializedName("token_id")
    public abstract Optional<String> getTokenId();

    @Override
    public String toString() {
        return "GetTokenRequestVO [tokenId=" + getTokenId().orElse(null) + "]";
    }

}
