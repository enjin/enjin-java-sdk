package com.enjin.sdk;

import lombok.NonNull;
import okhttp3.HttpUrl;

/**
 * TODO
 */
public final class ProjectClient extends TrustedPlatformClient {

    /**
     * TODO
     * @param baseUrl
     * @param debug
     */
    ProjectClient(@NonNull HttpUrl baseUrl, boolean debug) {
        super(baseUrl, debug);
    }

}
