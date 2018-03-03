package io.enjincoin.sdk.client.vo.token;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Create Token Response class.
 * </p>
 */
public class CreateTokenRequestVO {

    @SerializedName("token_id")
    private Optional<Integer> tokenId;

    @SerializedName("app_id")
    private Optional<Integer> appId;

    /**
     * Class constructor.
     * @param tokenId
     * @param appId
     */
    public CreateTokenRequestVO(Optional<Integer> tokenId, Optional<Integer> appId) {
        super();
        this.tokenId = tokenId;
        this.appId = appId;
    }

    /**
     * @return the tokenId
     */
    public Optional<Integer> getTokenId() {
        return tokenId;
    }

    /**
     * @return the appId
     */
    public Optional<Integer> getAppId() {
        return appId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CreateTokenRequestVO [tokenId=" + tokenId + ", appId=" + appId + "]";
    }
}
