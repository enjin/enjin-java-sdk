package com.enjin.enjincoin.sdk.client.service.users.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Update User Request  class.</p>
 */
public class UpdateUserRequestBody {


    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    /**
     * Class constructor.
     * @param name
     * @param email
     * @param password
     */
    public UpdateUserRequestBody(String name, String email, String password) {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }


    /**
     * @return the password
     */
    public String getPassword() {
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
