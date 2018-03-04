package io.enjincoin.sdk.client.service.users.vo;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Create User Response class.</p>
 */
public class LoginUserResponseBody {

    @SerializedName("identity")
    private Optional<UserResponseBody> identity;

    @SerializedName("token")
    private Optional<String> token;


    /**
     * Class constructor.
     * @param identity
     * @param token
     */
    public LoginUserResponseBody(UserResponseBody identity, String token) {
        super();
        this.identity = Optional.of(identity);
        this.token = Optional.of(token);
    }

    /**
     * @return the identity
     */
    public Optional<UserResponseBody> getIdentity() {
        return identity;
    }

    /**
     * @return the token
     */
    public Optional<String> getToken() {
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
