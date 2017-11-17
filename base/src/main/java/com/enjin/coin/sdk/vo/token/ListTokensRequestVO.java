package com.enjin.coin.sdk.vo.token;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

/**
 * <p>
 * List Tokens Request class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class ListTokensRequestVO {

    /**
     * Method to get the appId.
     * @return Optional<String>
     */
    @SerializedName("app_id")
    public abstract Optional<String> getAppId();

    /**
     * Method to get the afterTokenId.
     * @return Optional<String>
     */
    @SerializedName("after_token_id")
    public abstract Optional<String> getAfterTokenId();

    /**
     * Method to get the limit.
     * @return Optional<String>
     */
    @SerializedName("limit")
    public abstract Optional<String> getLimit();

    /**
     * Class toString method.
     */
    @Override
    public String toString() {
        return "ListTokensRequestVO [appId=" + getAppId().orElse(null) + ", afterTokenId=" + getAfterTokenId().orElse(null) + ", limit="
                + getLimit().orElse(null) + "]";
    }

}
