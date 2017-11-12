package com.enjin.coin.sdk.vo.token;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Arrays;

@Value.Immutable
@Gson.TypeAdapters
public abstract class ListTokensResponseVO {

    @Nullable
    @SerializedName("getTokenResponseVOArray")
    public abstract GetTokenResponseVO[] getGetTokensResponseVOArray();

    @Override
    public String toString() {
        return "ListTokensResponseVO [getTokensResponseVOArray=" + Arrays.toString(getGetTokensResponseVOArray()) + "]";
    }

}
