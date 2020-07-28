package com.enjin.sdk;

import java.util.concurrent.ExecutorService;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.models.app.AuthApp;
import com.enjin.sdk.models.AccessToken;
import com.enjin.sdk.schemas.SchemaImpl;
import com.enjin.sdk.schemas.shared.SharedSchema;

import lombok.Getter;
import lombok.NonNull;
import okhttp3.OkHttpClient;

/**
 * TODO: Update.
 * Implementation class of the {@link TrustedPlatformClient}.
 *
 * @see TrustedPlatformClient
 * @see TrustedPlatformMiddlewareBuilder
 */
public abstract class TrustedPlatformClientImpl implements TrustedPlatformClient {

    // Keys
    private static final String CLIENT_CREDENTIALS = "client_credentials"; // TODO: Remove this if necessary.

    //TODO: Group descriptor.
    @Getter
    private final TrustedPlatformMiddleware middleware;
    @Getter
    private final SharedSchema schema;

    /**
     * TODO: Description.
     *
     * @param middleware the tp middleware
     */
    TrustedPlatformClientImpl(@NonNull TrustedPlatformMiddleware middleware) {
        this.middleware = middleware;
        this.schema = new SchemaImpl(this.middleware);
    }

    @Override
    public void setAppId(Integer id) {
        middleware.getTrustedPlatformInterceptor().setAppId(id);
    }

    @Override
    public Integer getAppId() {
        return middleware.getTrustedPlatformInterceptor().getAppId();
    }

    /**
     * Synchronously authenticates the trusted platform using the provided app id and secret.
     *
     * @param appId the app id
     * @param appSecret the app secret
     * @return the response
     */
    @Override
    public HttpResponse<GraphQLResponse<AccessToken>> authAppSync(int appId, String appSecret) {
        trustedPlatformInterceptor.clearAuth();
        HttpResponse<GraphQLResponse<AccessToken>> httpResponse = appService.authAppSync(new AuthApp().id(appId)
                                                                                                      .secret(appSecret));
        authApp(appId, httpResponse);
        return httpResponse;
    }

    /**
     * Asynchronously authenticates the trusted platform using the provided app id and secret and calls the callback
     * with the response result.
     *
     * @param appId the app id
     * @param appSecret the app secret
     * @param callback the callback
     */
    @Override
    public void authAppAsync(int appId,
                             String appSecret,
                             HttpCallback<GraphQLResponse<AccessToken>> callback) {
        trustedPlatformInterceptor.clearAuth();
        appService.authAppAsync(new AuthApp().id(appId).secret(appSecret),
                                response -> {
                                    authApp(appId, response);
                                    callback.onComplete(response);
                                });
    }

    @Override
    public void auth(AccessToken token) {
        auth(token.getAccessToken());
    }

    @Override
    public void auth(String token) {
        middleware.getTrustedPlatformInterceptor().auth(token);
    }

    @Override
    public boolean isAuthenticated() {
        return middleware.getTrustedPlatformInterceptor().isAuthenticated();
    }

    private void authApp(int appId, HttpResponse<GraphQLResponse<AccessToken>> response) {
        if (response.isSuccess() && response.body().isSuccess()) {
            AccessToken body = response.body().getData();
            auth(body.getAccessToken());
            setAppId(appId);
        }
    }

    @Override
    public void close() {
        OkHttpClient httpClient = middleware.getHttpClient();

        ExecutorService executorService = httpClient.dispatcher().executorService();
        if (!executorService.isShutdown()) {
            executorService.shutdown();
            httpClient.connectionPool().evictAll();
        }
    }

    @Override
    public boolean isClosed() {
        return middleware.getHttpClient()
                         .dispatcher()
                         .executorService()
                         .isShutdown();
    }
}
