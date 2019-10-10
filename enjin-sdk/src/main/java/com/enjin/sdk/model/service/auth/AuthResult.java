package com.enjin.sdk.model.service.auth;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.ToString;

/**
 * The response body of an oauth authentication request to the Trusted Platform.
 *
 * @author Evan Lindsay
 */
@Getter
@ToString
public class AuthResult {

    /**
     * The type of the access token.
     *
     * @return the access token type.
     */
    @SerializedName("token_type")
    private String tokenType;

    /**
     * How long until the access token expires.
     *
     * @return the time in seconds until the access token expires.
     */
    @SerializedName("expires_in")
    private Long expiresIn;

    /**
     * The access token.
     *
     * @return the access token.
     */
    @SerializedName("access_token")
    private String accessToken;

}
