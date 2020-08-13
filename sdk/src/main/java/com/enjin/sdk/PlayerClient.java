package com.enjin.sdk;

import com.enjin.sdk.schemas.Schema;
import lombok.NonNull;

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
    public PlayerClient(@NonNull String baseUrl) {
        this(baseUrl, false);
    }

    /**
     * TODO
     * @param baseUrl
     * @param debug
     */
    public PlayerClient(@NonNull String baseUrl, boolean debug) {
        super(baseUrl, debug, SCHEMA);
    }

    @Override
    public Schema getSchema() {
        return schema;
    }

}
