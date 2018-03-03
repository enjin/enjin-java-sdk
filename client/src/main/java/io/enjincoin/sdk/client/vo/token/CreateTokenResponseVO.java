package io.enjincoin.sdk.client.vo.token;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Create Token Response class.
 * </p>
 */
public class CreateTokenResponseVO {

    @SerializedName("token_id")
    private Optional<Integer> tokenId;

    @SerializedName("app_id")
    private Optional<Integer> appId;


    @SerializedName("updated_at")
    private Optional<String> updatedAt;

    @SerializedName("created_at")
    private Optional<String> createdAt;

    /**
     * Class constructor.
     * @param tokenId
     * @param appId
     * @param updatedAt
     * @param createdAt
     */
    public CreateTokenResponseVO(Optional<Integer> tokenId, Optional<Integer> appId, Optional<String> updatedAt, Optional<String> createdAt) {
        super();
        this.tokenId = tokenId;
        this.appId = appId;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
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

    /**
     * @return the updatedAt
     */
    public Optional<String> getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @return the createdAt
     */
    public Optional<String> getCreatedAt() {
        return createdAt;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CreateTokenResponseVO [tokenId=" + tokenId + ", appId=" + appId + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + "]";
    }

}
