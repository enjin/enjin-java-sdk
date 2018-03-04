package io.enjincoin.sdk.client.service.identities.vo;

import com.google.gson.annotations.SerializedName;

import java.util.Optional;

/**
 * <p>Create Identity Response class.
 * </p>
 */
public class CreateIdentityResponseBody {

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

    /**
     * Class constructor.
     *
     * @param id
     * @param ethereumAddress
     * @param updatedAt
     * @param createdAt
     */
    public CreateIdentityResponseBody(Optional<Integer> id, Optional<String> ethereumAddress, Optional<String> linkingCode, Optional<String> updatedAt, String createdAt) {
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
