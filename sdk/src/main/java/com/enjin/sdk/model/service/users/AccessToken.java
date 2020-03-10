package com.enjin.sdk.model.service.users;

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
     * The app id the token is for.
     *
     * @return the app id.
     */
    private Integer appId;

    /**
     * The access token.
     *
     * @return the access token.
     */
    @SerializedName("accessToken")
    private String token;

    /**
     * The refresh token.
     *
     * @return the refresh token.
     */
    private String refreshToken;

}
