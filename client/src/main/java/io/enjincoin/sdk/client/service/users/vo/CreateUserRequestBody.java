package io.enjincoin.sdk.client.service.users.vo;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Create User Request  class.</p>
 */
public class CreateUserRequestBody {

    @SerializedName("app_id")
    private Optional<Integer> appId;

    @SerializedName("name")
    private Optional<String> name;

    @SerializedName("email")
    private Optional<String> email;

    @SerializedName("password")
    private Optional<String> password;

    /**
     * Class constructor.
     * @param appId
     * @param name
     * @param email
     * @param password
     */
    public CreateUserRequestBody(Integer appId, String name, String email, String password) {
        super();
        this.appId = Optional.of(appId);
        this.name = Optional.of(name);
        this.email = Optional.of(email);
        this.password = Optional.of(password);
    }


    /**
     * @return the appId
     */
    public Optional<Integer> getAppId() {
        return appId;
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
     * @return the password
     */
    public Optional<String> getPassword() {
        return password;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CreateUserRequestBody [appId=" + appId + ", name=" + name + ", email=" + email + ", password=" + password + "]";
    }
}
