package com.enjin.sdk;

import com.enjin.sdk.schemas.player.PlayerSchema;
import lombok.NonNull;

/**
 * Client for using the player schema.
 */
public final class PlayerClient extends PlayerSchema {

    /**
     * Constructs a client with the targeted URL.
     *
     * @param baseUrl the base URL
     */
    public PlayerClient(@NonNull String baseUrl) {
        this(baseUrl, false);
    }

    /**
     * Constructs a client with the targeted URL and debugging state.
     *
     * @param baseUrl the base URL
     * @param debug whether debugging is enabled
     */
    public PlayerClient(@NonNull String baseUrl, boolean debug) {
        super(new TrustedPlatformMiddleware(baseUrl, debug));
    }

}
