package com.enjin.enjincoin.sdk.client.service.identity.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Link Identity Response class.
 * </p>
 */
public class LinkIdentityResponseBody {

    @SerializedName("id")
    private Integer id;

    @SerializedName("user_id")
    private Integer userId;

    @SerializedName("ethereum_address")
    private String ethereumAddress;

    @SerializedName("linking_code")
    private Integer linkingCode;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("created_at")
    private String createdAt;

    /**
     * Class constructor.
     *
     * @param id
     * @param userId
     * @param ethereumAddress
     * @param linkingCode
     * @param updatedAt
     * @param createdAt
     */
    public LinkIdentityResponseBody(Integer id, Integer userId, String ethereumAddress, Integer linkingCode, String updatedAt,
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
    public Integer getId() {
        return id;
    }

    /**
     * @return the ethereumAddress
     */
    public String getEthereumAddress() {
        return ethereumAddress;
    }

    /**
     * @return the updatedAt
     */
    public String getUpdatedAt() {
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
    public Integer getUserId() {
        return userId;
    }

    /**
     * @return the linkingCode
     */
    public Integer getLinkingCode() {
        return linkingCode;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "UpdateIdentityResponseVO [id=" + id + ", userId=" + userId + ", ethereumAddress=" + ethereumAddress + ", linkingCode=" + linkingCode + ", updatedAt=" + updatedAt
                + ", createdAt=" + createdAt + "]";
    }

}
