package io.enjincoin.sdk.client.vo.identity;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Create Identity Response class.
 * </p>
 */
public class CreateIdentityResponseVO {

    @SerializedName("id")
    private Optional<Integer> id;

    @SerializedName("ethereum_address")
    private Optional<String> ethereumAddress;

    @SerializedName("updated_at")
    private Optional<String> updatedAt;

    @SerializedName("created_at")
    private String createdAt;

    /**
     * Class cosntructor.
     * @param id
     * @param ethereumAddress
     * @param updatedAt
     * @param createdAt
     */
    public CreateIdentityResponseVO(Optional<Integer> id, Optional<String> ethereumAddress, Optional<String> updatedAt, String createdAt) {
        super();
        this.id = id;
        this.ethereumAddress = ethereumAddress;
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CreateIdentityResponseVO [id=" + id + ", ethereumAddress=" + ethereumAddress + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + "]";
    }

}
