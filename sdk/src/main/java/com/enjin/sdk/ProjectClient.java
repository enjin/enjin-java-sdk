package com.enjin.sdk;

import com.enjin.sdk.schemas.project.ProjectSchema;
import lombok.NonNull;

/**
 * Client for using the project schema.
 *
 * @see EnjinHosts
 */
public final class ProjectClient extends ProjectSchema {

    public static final String SCHEMA = "app"; // TODO: Remove this field

    /**
     * Constructs a client with the targeted URL.
     *
     * @param baseUrl the base URL
     */
    public ProjectClient(@NonNull String baseUrl) {
        this(baseUrl, false);
    }

    /**
     * Constructs a client with the targeted URL and debugging state.
     *
     * @param baseUrl the base URL
     * @param debug whether debugging is enabled
     */
    public ProjectClient(@NonNull String baseUrl, boolean debug) {
        super(new TrustedPlatformMiddleware(baseUrl, debug));
    }

}
