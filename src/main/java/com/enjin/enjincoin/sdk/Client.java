package com.enjin.enjincoin.sdk;

import com.enjin.enjincoin.sdk.model.service.auth.AuthResult;
import com.enjin.enjincoin.sdk.service.ethereum.EthereumService;
import com.enjin.enjincoin.sdk.service.identities.IdentitiesService;
import com.enjin.enjincoin.sdk.service.notifications.NotificationsService;
import com.enjin.enjincoin.sdk.service.platform.PlatformService;
import com.enjin.enjincoin.sdk.service.requests.RequestsService;
import com.enjin.enjincoin.sdk.service.tokens.TokensService;
import com.enjin.enjincoin.sdk.service.users.UsersService;
import com.enjin.enjincoin.sdk.http.HttpResponse;

import java.io.Closeable;
import java.io.IOException;

/**
 * Client interface for communicating with the Trusted Platform. Provides access
 * to the various service interfaces to perform common Trusted Platform requests.
 *
 * <p>By default the notification service is lazy loaded and will only initialize upon
 * calling {@link #getNotificationsService()} the first time.
 *
 * <p>A {@link Client} can be acquired by calling {@link Clients#createClient(String, int, boolean)}.
 *
 * @author Evan Lindsay
 * @see Clients
 * @see EthereumService
 * @see IdentitiesService
 * @see UsersService
 * @see RequestsService
 * @see TokensService
 * @see PlatformService
 * @see NotificationsService
 */
public interface Client extends Closeable {

    /**
     * Returns the result of authenticating with the Trusted Platform using an App secret.
     *
     * <p>The secret of an app can be retrieved by logging into a developer account
     * and executing the following query:
     *
     * <pre>
     *     query GetAppSecret($appId: Int!) {
     *         EnjinApps(id: $appId) {
     *             secret
     *         }
     *     }
     * </pre>
     *
     * @param secret the app secret
     * @return the result of the auth request
     * @throws IOException if a problem occurred while communicating with the server.
     */
    HttpResponse<AuthResult> auth(String secret) throws IOException;

    /**
     * The app id the client is configured for.
     *
     * @return the app id
     */
    Integer getAppId();

    /**
     * The EthereumService to be used for ethereum requests.
     *
     * @return the ethereum service
     */
    EthereumService getEthereumService();

    /**
     * The IdentitiesService to be used for identity requests.
     *
     * @return the identities service
     */
    IdentitiesService getIdentitiesService();

    /**
     * The UsersService to be used for user requests.
     *
     * @return the users service
     */
    UsersService getUsersService();

    /**
     * The RequestsService to be used for Trusted Platform request requests.
     *
     * @return the requests service
     */
    RequestsService getRequestsService();

    /**
     * The TokensService to be used for token requests.
     *
     * @return the tokens service
     */
    TokensService getTokensService();

    /**
     * The PlatformService to be used for platform requests.
     *
     * @return the platform service
     */
    PlatformService getPlatformService();

    /**
     * The service class for Trusted Platform notifications.
     *
     * Implementation Note: Pusher is the only supported notification service in the Java SDK for
     * the time being.
     *
     * @return the notifications service
     */
    NotificationsService getNotificationsService();
}
