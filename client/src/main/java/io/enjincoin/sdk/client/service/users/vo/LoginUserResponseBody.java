package io.enjincoin.sdk.client.service.users.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Create User Response class.</p>
 */
public class LoginUserResponseBody {

    @SerializedName("identity")
    private UserResponseBody identity;

    @SerializedName("token")
    private String token;


    /**
     * Class constructor.
     * @param identity
     * @param token
     */
    public LoginUserResponseBody(UserResponseBody identity, String token) {
        super();
        this.identity = identity;
        this.token = token;
    }

    /**
     * @return the identity
     */
    public UserResponseBody getIdentity() {
        return identity;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CreateUserResponseBody [identity=" + identity + ", token=" + token + "]";
    }


}
