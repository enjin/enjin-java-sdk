package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.Objects;

/**
 * Models a successful auth object.
 */
@Getter
public class AccessToken {

    /**
     * -- Getter --
     * @return the token for the auth
     */
    @SerializedName("accessToken")
    private String token;

    /**
     * -- Getter --
     * @return the number of seconds until the auth expires
     */
    private long expiresIn;

    @Override
    public String toString() {
        return Objects.toString(this);
    }

}
