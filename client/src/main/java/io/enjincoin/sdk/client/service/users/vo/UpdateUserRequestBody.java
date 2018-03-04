package io.enjincoin.sdk.client.service.users.vo;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Update User Request  class.</p>
 */
public class UpdateUserRequestBody {


    @SerializedName("name")
    private Optional<String> name;

    @SerializedName("email")
    private Optional<String> email;

    @SerializedName("password")
    private Optional<String> password;

    /**
     * Class constructor.
     * @param name
     * @param email
     * @param password
     */
    public UpdateUserRequestBody(String name, String email, String password) {
        super();
        this.name = Optional.of(name);
        this.email = Optional.of(email);
        this.password = Optional.of(password);
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
        return "UpdateUserRequestBody [name=" + name + ", email=" + email + ", password=" + password + "]";
    }
}
