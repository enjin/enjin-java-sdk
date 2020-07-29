package com.enjin.sdk;

import com.enjin.sdk.schemas.SchemaImpl;
import com.enjin.sdk.schemas.shared.SharedSchema;

import lombok.Getter;
import lombok.NonNull;
import okhttp3.HttpUrl;

/**
 * TODO
 */
public abstract class TrustedPlatformClient {

    /**
     * The URL for the main Enjin Cloud.
     */
    public static final HttpUrl MAIN_NET = HttpUrl.get("https://cloud.enjin.io/");
    /**
     * The URL for the kovan Enjin Cloud.
     */
    public static final HttpUrl KOVAN = HttpUrl.get("https://kovan.cloud.enjin.io/");

    //TODO: Group descriptor.
    @Getter
    private final TrustedPlatformMiddleware middleware;
    @Getter
    private final SharedSchema schema;

    /**
     * TODO
     * @param baseUrl
     * @param debug
     */
    TrustedPlatformClient(@NonNull HttpUrl baseUrl, boolean debug) {
        this.middleware = new TrustedPlatformMiddleware(baseUrl, debug);
        this.schema = new SchemaImpl(this.middleware);
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
