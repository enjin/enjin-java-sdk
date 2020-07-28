package com.enjin.sdk;

import com.enjin.sdk.graphql.GraphQLProcessor;
import com.enjin.sdk.graphql.GraphQLQueryRegistry;
import com.enjin.sdk.http.SessionCookieJar;
import com.enjin.sdk.http.TrustedPlatformInterceptor;
import com.enjin.sdk.utils.LoggerProvider;
import lombok.AccessLevel;
import lombok.Getter;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * TODO
 */
public class TrustedPlatformMiddleware {

    /**
     * -- Getter --
     * Returns the base URL.
     *
     * @return the base URL
     */
    @Getter
    private final HttpUrl baseUrl;
    private final LoggerProvider loggerProvider; // TODO: Add getter if necessary.

    // Http Client
    @Getter(AccessLevel.PACKAGE)
    private final TrustedPlatformInterceptor trustedPlatformInterceptor;
    @Getter(AccessLevel.PACKAGE)
    private final HttpLoggingInterceptor httpLogInterceptor;
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
     * @param builder
     */
    public TrustedPlatformMiddleware(TrustedPlatformMiddlewareBuilder builder) {
        this.baseUrl = builder.getBaseUrl().orElse(TrustedPlatformClient.MAIN_NET);
        this.loggerProvider = builder.getLoggerProvider().orElse(new LoggerProvider(Logger.getGlobal()));

        // Cookie Jar
        SessionCookieJar cookieJar = new SessionCookieJar();

        this.trustedPlatformInterceptor = new TrustedPlatformInterceptor();
        this.httpLogInterceptor = new HttpLoggingInterceptor();
        setHttpLogLevel(builder.getHttpLogLevel().orElse(Level.NONE));

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder()
                .cookieJar(cookieJar)
                .addInterceptor(this.trustedPlatformInterceptor)
                .addNetworkInterceptor(this.httpLogInterceptor);
        builder.getConnectTimeoutMillis()
               .ifPresent(aLong -> httpClientBuilder.connectTimeout(aLong, TimeUnit.MILLISECONDS));
        builder.getCallTimeoutMillis()
               .ifPresent(aLong -> httpClientBuilder.callTimeout(aLong, TimeUnit.MILLISECONDS));
        builder.getReadTimeoutMillis()
               .ifPresent(aLong -> httpClientBuilder.readTimeout(aLong, TimeUnit.MILLISECONDS));
        builder.getWriteTimeoutMillis()
               .ifPresent(aLong -> httpClientBuilder.writeTimeout(aLong, TimeUnit.MILLISECONDS));
        this.httpClient = httpClientBuilder.build();
        this.queryRegistry = GraphQLProcessor.getInstance().getQueryRegistry();
    }

    /**
     * Sets the HTTP log level.
     *
     * @param logLevel the HTTP log level
     */
    public void setHttpLogLevel(Level logLevel) {
        httpLogInterceptor.setLevel(logLevel == null ? Level.NONE : logLevel);
    }

    /**
     * Returns the http log level.
     *
     * @return the http log level
     */
    public Level getHttpLogLevel() {
        return httpLogInterceptor.getLevel();
    }

}
