package io.enjincoin.sdk.client.service.identities.vo;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Create Identity Response class.
 * </p>
 */
public class CreateIdentityResponseBody {

    @SerializedName("id")
    private Optional<Integer> id;

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
    public CreateIdentityResponseBody(Optional<Integer> id, Optional<String> linkingCode, Optional<String> updatedAt, String createdAt) {
        super();
        this.id = id;
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
                ", linkingCode=" + linkingCode +
                ", updatedAt=" + updatedAt +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
