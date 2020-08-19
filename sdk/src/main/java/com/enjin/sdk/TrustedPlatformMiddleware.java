package com.enjin.sdk;

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

    /**
     * TODO
     * @param baseUrl
     * @param debug
     */
    protected TrustedPlatformMiddleware(String baseUrl, boolean debug) {
        // Cookie Jar
        SessionCookieJar cookieJar = new SessionCookieJar();

        this.baseUrl = HttpUrl.get(baseUrl);
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
        this.queryRegistry = new GraphQLQueryRegistry();
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
