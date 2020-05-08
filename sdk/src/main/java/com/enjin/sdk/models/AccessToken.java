package com.enjin.sdk.models;

import lombok.Getter;

/**
 * Models an access token.
 */
@Getter
public class AccessToken {

    /**
     * -- GETTER --
     * Returns the access token's identifier.
     *
     * @return the identifier
     */
    private String accessToken;

    /**
     * -- GETTER --
     * Returns the number of seconds the access token expires in.
     *
     * @return the number of seconds
     */
    private long expiresIn;

}
