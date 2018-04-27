package com.enjin.enjincoin.sdk.client.service.identities.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Create Identity Response class.
 * </p>
 */
public class CreateIdentityResponseBody {

    @SerializedName("id")
    private Integer id;

    @SerializedName("ethereum_address")
    private String ethereumAddress;

    @SerializedName("linking_code")
    private String linkingCode;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("created_at")
    private String createdAt;

    /**
     * Class constructor.
     *
     * @param id
     * @param ethereumAddress
     * @param updatedAt
     * @param createdAt
     */
    public CreateIdentityResponseBody(Integer id, String ethereumAddress, String linkingCode, String updatedAt, String createdAt) {
        super();
        this.id = id;
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
     * @return the linkingCode
     */
    public String getLinkingCode() {
        return linkingCode;
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

    @Override
    public String toString() {
        return "CreateIdentityResponseBody{" +
                "id=" + id +
                ", ethereumAddress=" + ethereumAddress +
                ", linkingCode=" + linkingCode +
                ", updatedAt=" + updatedAt +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
