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
 * Middleware for communicating with the Trusted Platform.
 */
public class TrustedPlatformMiddleware implements Closeable {

    /**
     * -- Getter --
     * @return the base URL
     */
    @Getter
    private final HttpUrl baseUrl;

    /**
     * @return the TP interceptor
     */
    @Getter(AccessLevel.PACKAGE)
    private final TrustedPlatformInterceptor trustedPlatformInterceptor;

    /**
     * -- Getter --
     * @return the HTTP client
     */
    @Getter
    private final OkHttpClient httpClient;

    /**
     * -- Getter --
     * @return the query registry
     */
    @Getter
    private final GraphQLQueryRegistry queryRegistry;

    /**
     * Sole constructor.
     *
     * @param baseUrl the base URL
     * @param debug whether debugging is enabled
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
