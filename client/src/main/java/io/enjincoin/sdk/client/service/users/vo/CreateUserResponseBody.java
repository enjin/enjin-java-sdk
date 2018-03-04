package io.enjincoin.sdk.client.service.users.vo;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Create User Response class.</p>
 */
public class CreateUserResponseBody {

    @SerializedName("user")
    private Optional<UserResponseBody> user;

    @SerializedName("token")
    private Optional<String> token;


    /**
     * Class constructor.
     * @param user
     * @param token
     */
    public CreateUserResponseBody(UserResponseBody user, String token) {
        super();
        this.user = Optional.of(user);
        this.token = Optional.of(token);
    }

    /**
     * @return the user
     */
    public Optional<UserResponseBody> getUser() {
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
        return "CreateUserResponseBody [user=" + user + ", token=" + token + "]";
    }


}
