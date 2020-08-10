package com.enjin.sdk;

import com.enjin.sdk.schemas.player.PlayerSchema;
import lombok.NonNull;
import okhttp3.HttpUrl;

/**
 * TODO
 */
public final class PlayerClient extends TrustedPlatformClient {

    /**
     * TODO
     */
    public static final String SCHEMA = "player";

    /**
     * TODO
     * @param baseUrl
     */
    public PlayerClient(@NonNull HttpUrl baseUrl) {
        this(baseUrl, false);
    }

    /**
     * TODO
     * @param baseUrl
     * @param debug
     */
    public PlayerClient(@NonNull HttpUrl baseUrl, boolean debug) {
        super(baseUrl, debug, SCHEMA);
    }

    @Override
    public PlayerSchema getSchema() {
        return (PlayerSchema) schema;
    }

}
