package com.enjin.sdk;

import com.enjin.sdk.schemas.Schema;
import lombok.NonNull;

/**
 * TODO
 */
public final class ProjectClient extends TrustedPlatformClient {

    /**
     * TODO
     */
    public static final String SCHEMA = "app";

    /**
     * TODO
     * @param baseUrl
     */
    public ProjectClient(@NonNull String baseUrl) {
        this(baseUrl, false);
    }

    /**
     * TODO
     * @param baseUrl
     * @param debug
     */
    public ProjectClient(@NonNull String baseUrl, boolean debug) {
        super(baseUrl, debug, SCHEMA);
    }

    @Override
    public Schema getSchema() {
        return schema;
    }

}
