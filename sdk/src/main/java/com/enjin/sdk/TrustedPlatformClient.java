package com.enjin.sdk;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.AccessToken;
import com.enjin.sdk.services.app.AppsService;
import com.enjin.sdk.services.balance.BalancesService;
import com.enjin.sdk.services.identity.IdentitiesService;
import com.enjin.sdk.services.platform.PlatformService;
import com.enjin.sdk.services.request.RequestsService;
import com.enjin.sdk.services.token.TokensService;
import com.enjin.sdk.services.user.UsersService;
import com.enjin.sdk.services.wallet.WalletService;

import java.io.Closeable;

/**
 * Interface for clients on the Trusted Platform.
 */
public interface TrustedPlatformClient extends Closeable {

    /**
     * Returns the application service.
     *
     * @return the app service
     */
    AppsService getAppService();

    /**
     * Returns the balance service.
     *
     * @return the balance service
     */
    BalancesService getBalanceService();

    /**
     * Returns the identity service.
     *
     * @return the identity service
     */
    IdentitiesService getIdentityService();

    /**
     * Returns the platform service.
     *
     * @return the platform service
     */
    PlatformService getPlatformService();

    /**
     * Returns the request service.
     *
     * @return the request service
     */
    RequestsService getRequestService();

    /**
     * Returns the token service.
     *
     * @return the token service
     */
    TokensService getTokenService();

    /**
     * Returns the user service.
     *
     * @return the user service
     */
    UsersService getUserService();

    /**
     * Returns the wallet service.
     *
     * @return the wallet service.
     */
    WalletService getWalletService();

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
