package io.enjincoin.sdk.client.vo.user;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Update User Request  class.</p>
 */
public class UpdateUserRequestVO {


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
    public UpdateUserRequestVO(Optional<String> name, Optional<String> email, Optional<String> password) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
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
        return "UpdateUserRequestVO [name=" + name + ", email=" + email + ", password=" + password + "]";
    }
}
