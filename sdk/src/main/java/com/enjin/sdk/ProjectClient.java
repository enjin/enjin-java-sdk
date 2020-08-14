package com.enjin.sdk;

import com.enjin.sdk.schemas.project.ProjectSchema;
import lombok.NonNull;

/**
 * TODO
 */
public final class ProjectClient extends ProjectSchema {

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
        super(new TrustedPlatformMiddleware(baseUrl, debug));
    }

}
