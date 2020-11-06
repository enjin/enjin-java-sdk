package com.enjin.sdk;

import com.enjin.sdk.schemas.project.ProjectSchema;
import com.enjin.sdk.utils.LoggerProvider;
import lombok.NonNull;

import java.util.logging.Logger;

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
        this(baseUrl, debug, new LoggerProvider(Logger.getGlobal()));
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
    public boolean isAuthenticated() {
        return middleware.getTrustedPlatformInterceptor().isAuthenticated();
    }

}
