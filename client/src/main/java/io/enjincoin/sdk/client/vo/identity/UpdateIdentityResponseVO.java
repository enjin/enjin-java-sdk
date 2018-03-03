package io.enjincoin.sdk.client.vo.identity;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Update Identity Response class.
 * </p>
 */
public class UpdateIdentityResponseVO {

    @SerializedName("id")
    private Optional<Integer> id;

    @SerializedName("user_id")
    private Optional<Integer> userId;

    @SerializedName("ethereum_address")
    private Optional<String> ethereumAddress;

    @SerializedName("linking_code")
    private Optional<Integer> linkingCode;

    @SerializedName("updated_at")
    private Optional<String> updatedAt;

    @SerializedName("created_at")
    private String createdAt;


    /**
     * Class constructor.
     * @param id
     * @param userId
     * @param ethereumAddress
     * @param linkingCode
     * @param updatedAt
     * @param createdAt
     */
    public UpdateIdentityResponseVO(Optional<Integer> id, Optional<Integer> userId, Optional<String> ethereumAddress, Optional<Integer> linkingCode, Optional<String> updatedAt,
            String createdAt) {
        super();
        this.id = id;
        this.userId = userId;
        this.ethereumAddress = ethereumAddress;
        this.linkingCode = linkingCode;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }


    /**
     * @return the id
     */
    public Optional<Integer> getId() {
        return id;
    }

    /**
     * @return the ethereumAddress
     */
    public Optional<String> getEthereumAddress() {
        return ethereumAddress;
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
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @return the userId
     */
    public Optional<Integer> getUserId() {
        return userId;
    }


    /**
     * @return the linkingCode
     */
    public Optional<Integer> getLinkingCode() {
        return linkingCode;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "UpdateIdentityResponseVO [id=" + id + ", userId=" + userId + ", ethereumAddress=" + ethereumAddress + ", linkingCode=" + linkingCode + ", updatedAt=" + updatedAt
                + ", createdAt=" + createdAt + "]";
    }

}
