package com.enjin.sdk.models.user;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

/**
 * A users access token that is returned when logging a user in.
 *
 * @author Evan Lindsay
 * @see User
 * @see OAuthUser
 */
@Getter
@ToString
public class AccessToken {

    /**
     * -- GETTER --
     * Returns the application id the token is for.
     *
     * @return the app id.
     */
    private Integer appId;

    /**
     * -- GETTER --
     * Returns the access token.
     *
     * @return the access token.
     */
    @SerializedName("accessToken")
    private String token;

    /**
     * -- GETTER --
     * Returns the refresh token.
     *
     * @return the refresh token.
     */
    private String refreshToken;

}
