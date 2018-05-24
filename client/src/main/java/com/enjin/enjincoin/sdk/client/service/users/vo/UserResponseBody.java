package com.enjin.enjincoin.sdk.client.service.users.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>User Response class.</p>
 */
public class UserResponseBody {

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("identity")
    private String identity;

    public UserResponseBody(Integer id, String name, String email, String updatedAt, String createdAt, String identity) {
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
    public Integer getId() {
        return this.id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return this.email;
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

    /**
     * @return the identity
     */
    public String getIdentity() {
        return this.identity;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "UserResponseBody [id=" + this.id + ", name=" + this.name + ", email=" + this.email + ", updatedAt=" + this.updatedAt + ", createdAt=" + this.createdAt + ", identity=" + this.identity + "]";
    }


}
