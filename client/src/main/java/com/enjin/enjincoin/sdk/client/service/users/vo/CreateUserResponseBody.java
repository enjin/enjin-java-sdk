package com.enjin.enjincoin.sdk.client.service.users.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Create User Response class.</p>
 */
public class CreateUserResponseBody {

    @SerializedName("users")
    private UserResponseBody user;

    @SerializedName("token")
    private String token;


    /**
     * Class constructor.
     * @param user
     * @param token
     */
    public CreateUserResponseBody(UserResponseBody user, String token) {
        super();
        this.user = user;
        this.token = token;
    }

    /**
     * @return the users
     */
    public UserResponseBody getUser() {
        return this.user;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return this.token;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CreateUserResponseBody [users=" + this.user + ", token=" + this.token + "]";
    }


}
