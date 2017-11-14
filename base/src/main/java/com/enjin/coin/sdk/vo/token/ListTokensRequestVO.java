package com.enjin.coin.sdk.vo.token;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@Gson.TypeAdapters
public abstract class ListTokensRequestVO {

    @SerializedName("app_id")
    public abstract Optional<String> getAppId();

    @SerializedName("after_token_id")
    public abstract Optional<String> getAfterTokenId();

    @SerializedName("limit")
    public abstract Optional<String> getLimit();

    @Override
    public String toString() {
        return "ListTokensRequestVO [appId=" + getAppId().orElse(null) + ", afterTokenId=" + getAfterTokenId().orElse(null)
                + ", limit=" + getLimit().orElse(null) + "]";
    }

}
