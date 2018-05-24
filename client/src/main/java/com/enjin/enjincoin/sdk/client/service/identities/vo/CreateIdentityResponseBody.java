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
        return this.id;
    }

    /**
     * @return the ethereumAddress
     */
    public String getEthereumAddress() {
        return this.ethereumAddress;
    }

    /**
     * @return the linkingCode
     */
    public String getLinkingCode() {
        return this.linkingCode;
    }

    /**
     * @return the updatedAt
     */
    public String getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * @return the createdAt
     */
    public String getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public String toString() {
        return "CreateIdentityResponseBody{" +
                "id=" + this.id +
                ", ethereumAddress=" + this.ethereumAddress +
                ", linkingCode=" + this.linkingCode +
                ", updatedAt=" + this.updatedAt +
                ", createdAt='" + this.createdAt + '\'' +
                '}';
    }
}
