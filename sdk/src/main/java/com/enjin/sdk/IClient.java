package com.enjin.sdk;

/**
 * Interface for client implementation.
 */
public interface IClient {

    /**
     * Authenticates the client with the given token.
     *
     * @param token the auth token
     */
    void auth(String token);

    /**
     * Determines whether the client is authenticated.
     *
     * @return true if authenticated, false otherwise
     */
    boolean isAuthenticated();

}
