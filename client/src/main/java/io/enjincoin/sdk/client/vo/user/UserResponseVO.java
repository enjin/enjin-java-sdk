package io.enjincoin.sdk.client.vo.user;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>User Response class.</p>
 */
public class UserResponseVO {

    @SerializedName("id")
    private Optional<Integer> id;

    @SerializedName("name")
    private Optional<String> name;

    @SerializedName("email")
    private Optional<String> email;

    @SerializedName("updated_at")
    private Optional<String> updatedAt;

    @SerializedName("created_at")
    private Optional<String> createdAt;

    @SerializedName("identity")
    private Optional<String> identity;

    public UserResponseVO(Optional<Integer> id, Optional<String> name, Optional<String> email, Optional<String> updatedAt, Optional<String> createdAt, Optional<String> identity) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.identity = identity;
    }

    /**
     * @return the id
     */
    public Optional<Integer> getId() {
        return id;
    }

    /**
     * @return the name
     */
    public Optional<String> getName() {
        return name;
    }

    /**
     * @return the email
     */
    public Optional<String> getEmail() {
        return email;
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

    /**
     * @return the identity
     */
    public Optional<String> getIdentity() {
        return identity;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "UserResponseVO [id=" + id + ", name=" + name + ", email=" + email + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + ", identity=" + identity + "]";
    }


}
