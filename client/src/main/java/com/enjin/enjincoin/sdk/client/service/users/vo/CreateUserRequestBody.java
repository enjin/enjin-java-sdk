package com.enjin.enjincoin.sdk.client.service.users.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Create User Request  class.</p>
 */
public class CreateUserRequestBody {

    @SerializedName("app_id")
    private Integer appId;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    /**
     * Class constructor.
     * @param appId
     * @param name
     * @param email
     * @param password
     */
    public CreateUserRequestBody(Integer appId, String name, String email, String password) {
        super();
        this.appId = appId;
        this.name = name;
        this.email = email;
        this.password = password;
    }


    /**
     * @return the appId
     */
    public Integer getAppId() {
        return this.appId;
    }


    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }


    /**
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }


    /**
     * @return the password
     */
    public String getPassword() {
        return this.password;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CreateUserRequestBody [appId=" + this.appId + ", name=" + this.name + ", email=" + this.email + ", password=" + this.password + "]";
    }
}
