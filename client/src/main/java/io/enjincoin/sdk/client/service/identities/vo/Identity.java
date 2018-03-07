package io.enjincoin.sdk.client.service.identities.vo;

import java.util.Arrays;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Get Identity Response class.
 * </p>
 */
public class Identity {


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

    @SerializedName("user")
    private String user;

    @SerializedName("fields")
    private IdentityField[] fields;

    public Identity(Integer id, String ethereumAddress, String linkingCode, String updatedAt, String createdAt, String user,
                    IdentityField[] fields) {
        super();
        this.id = id;
        this.ethereumAddress = ethereumAddress;
        this.linkingCode = linkingCode;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.user = user;
        this.fields = fields;
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

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @return the fields
     */
    public IdentityField[] getFields() {
        return fields;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Identity [id=" + id + ", ethereumAddress=" + ethereumAddress + ", linkingCode=" + linkingCode + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + ", user=" + user
                + ", fields=" + Arrays.toString(fields) + "]";
    }
}
