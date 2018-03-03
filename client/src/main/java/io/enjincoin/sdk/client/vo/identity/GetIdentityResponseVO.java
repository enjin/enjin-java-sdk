package io.enjincoin.sdk.client.vo.identity;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Get Identity Response class.
 * </p>
 */
public class GetIdentityResponseVO {


    @SerializedName("id")
    private Optional<Integer> id;

    @SerializedName("ethereum_address")
    private Optional<String> ethereumAddress;

    @SerializedName("linking_code")
    private Optional<String> linkingCode;

    @SerializedName("updated_at")
    private Optional<String> updatedAt;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("user")
    private Optional<String> user;

    @SerializedName("fields")
    private Optional<FieldVO[]> fields;

    public GetIdentityResponseVO(Optional<Integer> id, Optional<String> ethereumAddress, Optional<String> linkingCode, Optional<String> updatedAt, String createdAt, Optional<String> user,
            Optional<FieldVO[]> fields) {
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
     * @return the linkingCode
     */
    public Optional<String> getLinkingCode() {
        return linkingCode;
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
     * @return the user
     */
    public Optional<String> getUser() {
        return user;
    }

    /**
     * @return the fields
     */
    public Optional<FieldVO[]> getFields() {
        return fields;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "GetIdentityResponseVO [id=" + id + ", ethereumAddress=" + ethereumAddress + ", linkingCode=" + linkingCode + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt
                + ", user=" + user + ", fields=" + fields + "]";
    }
}
