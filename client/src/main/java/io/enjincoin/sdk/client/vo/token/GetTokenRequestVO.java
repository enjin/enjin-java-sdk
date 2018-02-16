package io.enjincoin.sdk.client.vo.token;

import com.google.gson.annotations.SerializedName;
import org.immutables.gson.Gson;
import org.immutables.value.Value;

import java.util.Optional;

/**
 * <p>
 * Get Token Request class.
 * </p>
 */
@Value.Immutable
@Gson.TypeAdapters
public abstract class GetTokenRequestVO {

    /**
     * Method to get the tokenId.
     *
     * @return Optional
     */
    @SerializedName("app_id")
    public abstract Optional<String> getAppId();

    /**
     * Method to get the after_token_id.
     *
     * @return Optional
     */
    @SerializedName("after_token_id")
    public abstract Optional<String> getAfterTokenId();

    /**
     * Method to get the limit.
     *
     * @return Optional
     */
    @SerializedName("limit")
    public abstract Optional<String> getLimit();

    /**
     * Class toString method.
     */
    @Override
    public String toString() {
        return "GetTokenRequestVO [appId=" + getAppId().orElse(null) + ", afterTokenId=" + getAfterTokenId().orElse(null) + ", limit=" + getLimit().orElse(null)
                + "]";
    }

}
