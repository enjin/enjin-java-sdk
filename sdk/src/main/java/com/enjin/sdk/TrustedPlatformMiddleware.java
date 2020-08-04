package com.enjin.sdk;

import com.enjin.sdk.graphql.GraphQLProcessor;
import com.enjin.sdk.graphql.GraphQLQueryRegistry;
import com.enjin.sdk.http.SessionCookieJar;
import com.enjin.sdk.http.TrustedPlatformInterceptor;
import lombok.AccessLevel;
import lombok.Getter;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import java.io.Closeable;
import java.util.concurrent.ExecutorService;

/**
 * TODO
 */
public class TrustedPlatformMiddleware implements Closeable {

    /**
     * -- Getter --
     * Returns the base URL.
     *
     * @return the base URL
     */
    @Getter
    private final HttpUrl baseUrl;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    @Getter
    private final String schema;

    // Http Client
    @Getter(AccessLevel.PACKAGE)
    private final TrustedPlatformInterceptor trustedPlatformInterceptor;
    /**
     * -- Getter --
     * Returns the HTTP client.
     *
     * @return the HTTP client
     */
    @Getter
    private final OkHttpClient httpClient;

    /**
     * -- Getter --
     * Returns the graphQL query registry.
     *
     * @return the query registry
     */
    @Getter
    private final GraphQLQueryRegistry queryRegistry;

    private TrustedPlatformMiddleware() {
        throw new IllegalStateException(/* TODO: Exception message. */);
    }

    /**
     * TODO
     * @param baseUrl
     * @param debug
     * @param schema
     */
    public TrustedPlatformMiddleware(HttpUrl baseUrl, boolean debug, String schema) {
        // Cookie Jar
        SessionCookieJar cookieJar = new SessionCookieJar();

        this.baseUrl = baseUrl;
        this.schema = schema;
        this.trustedPlatformInterceptor = new TrustedPlatformInterceptor();
        this.httpClient = debug
                ? new OkHttpClient.Builder()
                                  .cookieJar(cookieJar)
                                  .addInterceptor(this.trustedPlatformInterceptor)
                                  .addNetworkInterceptor(new HttpLoggingInterceptor())
                                  .build()
                : new OkHttpClient.Builder()
                                  .cookieJar(cookieJar)
                                  .addInterceptor(this.trustedPlatformInterceptor)
                                  .build();
        this.queryRegistry = GraphQLProcessor.getInstance().getQueryRegistry();
    }

    @Override
    public void close() {
        ExecutorService executorService = httpClient.dispatcher().executorService();
        if (!executorService.isShutdown()) {
            executorService.shutdown();
            httpClient.connectionPool().evictAll();
        }
    }

    /**
     * Checks if the middleware is closed.
     *
     * @return true if the dispatcher executor service is shutdown, else false
     */
    public boolean isClosed() {
        return httpClient.dispatcher()
                         .executorService()
                         .isShutdown();
    }

}
