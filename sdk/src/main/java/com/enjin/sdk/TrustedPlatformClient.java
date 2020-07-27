package com.enjin.sdk;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.AccessToken;
import com.enjin.sdk.schemas.shared.SharedSchema;
import okhttp3.HttpUrl;

import java.io.Closeable;

/**
 * Interface for clients on the Trusted Platform.
 */
public interface TrustedPlatformClient extends Closeable {

    /**
     * The URL for the main Enjin Cloud.
     */
    HttpUrl MAIN_NET = HttpUrl.get("https://cloud.enjin.io/");
    /**
     * The URL for the kovan Enjin Cloud.
     */
    HttpUrl KOVAN = HttpUrl.get("https://kovan.cloud.enjin.io/");

    /**
     * TODO
     * @return
     */
    TrustedPlatformMiddleware getMiddleware();

    /**
     * TODO
     * @return
     */
    SharedSchema getSchema();

    /**
     * Sets the application id.
     *
     * @param id the new app id
     */
    void setAppId(Integer id);

    /**
     * Returns the application's id.
     *
     * @return the app id
     */
    Integer getAppId();

    /**
     * Synchronously authenticates the trusted platform using the provided app id and secret.
     *
     * @param id     the app id
     * @param secret the app secret
     * @return       the response
     */
    HttpResponse<GraphQLResponse<AccessToken>> authAppSync(int id, String secret);

    /**
     * Asynchronously authenticates the trusted platform using the provided app id and secret and calls the callback
     * with the response result.
     *
     * @param id       the app id
     * @param secret   the app secret
     * @param callback the callback
     */
    void authAppAsync(int id, String secret, HttpCallback<GraphQLResponse<AccessToken>> callback);

    /**
     * Configures the client to use the specified access token instance.
     *
     * @param token the token instance
     */
    void auth(AccessToken token);

    /**
     * Configures the client to use the specified access token string.
     *
     * @param token the access token
     */
    void auth(String token);

    /**
     * Checks if the client is authenticated.
     *
     * @return true if the client is authenticated, else false
     */
    boolean isAuthenticated();

    /**
     * Checks if the client is closed.
     *
     * @return true if the dispatcher executor service is shutdown, else false
     */
    boolean isClosed();

    /**
     * Returns the version.
     *
     * @return the version
     */
    static String version() {
        return "@version@";
    }

}
