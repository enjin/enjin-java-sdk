package com.enjin.sdk;

import com.enjin.sdk.schemas.Schema;

import lombok.Getter;
import lombok.NonNull;

/**
 * TODO
 */
public abstract class TrustedPlatformClient {

    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    @Getter
    private final TrustedPlatformMiddleware middleware;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    @Getter
    protected final Schema schema;

    /**
     * TODO
     * @param baseUrl
     * @param debug
     * @param schema
     */
    protected TrustedPlatformClient(@NonNull String baseUrl, boolean debug, String schema) {
        this.middleware = new TrustedPlatformMiddleware(baseUrl, debug, schema);
        this.schema = new Schema(this.middleware);
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public static String version() {
        return "@version@";
    }

}
