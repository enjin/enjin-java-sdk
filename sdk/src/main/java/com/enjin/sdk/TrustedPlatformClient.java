package com.enjin.sdk;

import com.enjin.sdk.schemas.Schema;
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
    protected final SharedSchema schema;

    /**
     * TODO
     * @param baseUrl
     * @param debug
     * @param schema
     */
    TrustedPlatformClient(@NonNull HttpUrl baseUrl, boolean debug, String schema) {
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
