package com.enjin.sdk;

import com.enjin.sdk.schemas.player.PlayerSchema;
import com.enjin.sdk.utils.LoggerProvider;
import lombok.NonNull;

import java.util.logging.Logger;

/**
 * Client for using the player schema.
 *
 * @see EnjinHosts
 */
public final class PlayerClient extends PlayerSchema {

    /**
     * Constructs a client with the targeted URL and default settings.
     *
     * @param baseUrl the base URL
     */
    public PlayerClient(@NonNull String baseUrl) {
        this(baseUrl, false);
    }

    /**
     * Constructs a client with the targeted URL, debugging state, and default logger provider.
     *
     * @param baseUrl the base URL
     * @param debug whether debugging is enabled
     */
    public PlayerClient(@NonNull String baseUrl, boolean debug) {
        this(baseUrl, debug, new LoggerProvider(Logger.getGlobal()));
    }

    /**
     * Constructs a client with the targeted settings.
     *
     * @param baseUrl the base URL
     * @param debug whether debugging is enabled
     * @param loggerProvider the logger provider to be used
     */
    public PlayerClient(@NonNull String baseUrl, boolean debug, @NonNull LoggerProvider loggerProvider) {
        super(new TrustedPlatformMiddleware(baseUrl, debug), loggerProvider);
    }

}
