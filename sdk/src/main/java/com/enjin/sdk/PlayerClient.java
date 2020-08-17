package com.enjin.sdk;

import com.enjin.sdk.schemas.player.PlayerSchema;
import lombok.NonNull;

/**
 * TODO
 */
public final class PlayerClient extends PlayerSchema {

    /**
     * TODO
     * @param baseUrl
     */
    public PlayerClient(@NonNull String baseUrl) {
        this(baseUrl, false);
    }

    /**
     * TODO
     * @param baseUrl
     * @param debug
     */
    public PlayerClient(@NonNull String baseUrl, boolean debug) {
        super(new TrustedPlatformMiddleware(baseUrl, debug));
    }

}
