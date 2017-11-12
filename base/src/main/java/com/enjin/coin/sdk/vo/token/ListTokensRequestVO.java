package com.enjin.coin.sdk.vo.token;

import com.enjin.coin.sdk.annotations.immutables.Nullable;
import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

@Value.Immutable
@Gson.TypeAdapters
public abstract class ListTokensRequestVO {

    @Nullable
    @SerializedName("app_id")
    public abstract String getAppId();

    @Nullable
    @SerializedName("after_token_id")
    public abstract String getAfterTokenId();

    @Nullable
    @SerializedName("limit")
    public abstract String getLimit();

    @Override
    public String toString() {
        return "ListTokensRequestVO [appId=" + getAppId() + ", afterTokenId=" + getAfterTokenId() + ", limit=" + getLimit() + "]";
    }

}
