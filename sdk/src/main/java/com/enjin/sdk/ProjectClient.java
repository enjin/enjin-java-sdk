package com.enjin.sdk;

import com.enjin.sdk.schemas.project.ProjectSchema;
import lombok.NonNull;
import okhttp3.HttpUrl;

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
     * @param debug
     */
    ProjectClient(@NonNull HttpUrl baseUrl, boolean debug) {
        super(baseUrl, debug, SCHEMA);
    }

    @Override
    public ProjectSchema getSchema() {
        return (ProjectSchema) schema;
    }

}
