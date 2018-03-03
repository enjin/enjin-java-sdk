package io.enjincoin.sdk.client.vo.user;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Create User Response class.</p>
 */
public class CreateUserResponseVO {

    @SerializedName("user")
    private Optional<UserResponseVO> user;

    @SerializedName("token")
    private Optional<String> token;


    /**
     * Class constructor.
     * @param user
     * @param token
     */
    public CreateUserResponseVO(Optional<UserResponseVO> user, Optional<String> token) {
        super();
        this.user = user;
        this.token = token;
    }

    /**
     * @return the user
     */
    public Optional<UserResponseVO> getUser() {
        return user;
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
        return "CreateUserResponseVO [user=" + user + ", token=" + token + "]";
    }


}
