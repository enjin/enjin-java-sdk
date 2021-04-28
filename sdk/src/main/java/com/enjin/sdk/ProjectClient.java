package com.enjin.sdk;

import com.enjin.sdk.schemas.project.ProjectSchema;
import com.enjin.sdk.utils.Logger;
import com.enjin.sdk.utils.LoggerProvider;
import lombok.NonNull;
import okhttp3.OkHttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Client for using the project schema.
 *
 * @see EnjinHosts
 */
public final class ProjectClient extends ProjectSchema implements IClient {

    /**
     * Constructs a client with the targeted URL and default settings.
     *
     * @param baseUrl the base URL
     */
    public ProjectClient(@NonNull String baseUrl) {
        this(baseUrl, false);
    }

    /**
     * Constructs a client with the targeted URL, debugging state, and default logger provider.
     *
     * @param baseUrl the base URL
     * @param debug whether debugging is enabled
     */
    public ProjectClient(@NonNull String baseUrl, boolean debug) {
        this(baseUrl, debug, new LoggerProvider(new Logger()));
    }

    /**
     * Constructs a client with the targeted settings.
     *
     * @param baseUrl the base URL
     * @param debug whether debugging is enabled
     * @param loggerProvider the logger provider to be used
     */
    public ProjectClient(@NonNull String baseUrl, boolean debug, @NonNull LoggerProvider loggerProvider) {
        super(new TrustedPlatformMiddleware(baseUrl, debug), loggerProvider);
    }

    @Override
    public void auth(String token) {
        middleware.getTrustedPlatformInterceptor().setToken(token);
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
    public boolean isAuthenticated() {
        return middleware.getTrustedPlatformInterceptor().isAuthenticated();
    }

    @Override
    public boolean isClosed() {
        return middleware.getHttpClient()
                         .dispatcher()
                         .executorService()
                         .isShutdown();
    }

}
