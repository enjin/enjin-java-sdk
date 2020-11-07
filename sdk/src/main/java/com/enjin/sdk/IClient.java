package com.enjin.sdk;

import java.io.Closeable;

/**
 * Interface for client implementation.
 */
public interface IClient extends Closeable {

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

    /**
     * Determines whether the client is closed.
     *
     * @return true if closed, false otherwise
     */
    boolean isClosed();

}
