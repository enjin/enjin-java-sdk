package io.enjincoin.sdk.client.vo.user;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Create User Response class.</p>
 */
public class LoginUserResponseVO {

    @SerializedName("identity")
    private Optional<UserResponseVO> identity;

    @SerializedName("token")
    private Optional<String> token;


    /**
     * Class constructor.
     * @param identity
     * @param token
     */
    public LoginUserResponseVO(Optional<UserResponseVO> identity, Optional<String> token) {
        super();
        this.identity = identity;
        this.token = token;
    }

    /**
     * @return the identity
     */
    public Optional<UserResponseVO> getIdentity() {
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
        return "CreateUserResponseVO [identity=" + identity + ", token=" + token + "]";
    }


}
