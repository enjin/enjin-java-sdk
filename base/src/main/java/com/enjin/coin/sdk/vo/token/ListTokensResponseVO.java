package com.enjin.coin.sdk.vo.token;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Arrays;
import java.util.Optional;

@Value.Immutable
@Gson.TypeAdapters
public abstract class ListTokensResponseVO {

    @SerializedName("getTokenResponseVOArray")
    public abstract Optional<GetTokenResponseVO[]> getGetTokensResponseVOArray();

    @Override
    public String toString() {
        return "ListTokensResponseVO [getTokensResponseVOArray=" + Arrays.toString(getGetTokensResponseVOArray().orElse(null)) + "]";
    }

}
