package com.enjin.sdk;

import com.enjin.sdk.utils.LoggerProvider;
import okhttp3.HttpUrl;
import okhttp3.logging.HttpLoggingInterceptor.Level;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Builder class for a {@link TrustedPlatformClient} instance.
 *
 * @see TrustedPlatformClient
 */
public class TrustedPlatformMiddlewareBuilder {

    /**
     * The base URL to use in the built Trusted Platform client.
     */
    protected HttpUrl baseUrl;
    /**
     * The HTTP log level to use in the built Trusted Platform client.
     */
    protected Level httpLogLevel;
    /**
     * The connection timeout to use in the built Trusted Platform client.
     */
    protected Long connectTimeoutMillis;
    /**
     * The call timeout to use in the built Trusted Platform client.
     */
    protected Long callTimeoutMillis;
    /**
     * The read timeout to use in the built Trusted Platform client.
     */
    protected Long readTimeoutMillis;
    /**
     * The write timeout to use in the built Trusted Platform client.
     */
    protected Long writeTimeoutMillis;
    /**
     * The logger provider to use in the built Trusted Platform client.
     */
    protected LoggerProvider loggerProvider;

    /**
     * Sets the HTTP log level.
     *
     * @param httpLogLevel the log level
     * @return the builder
     */
    public TrustedPlatformMiddlewareBuilder httpLogLevel(Level httpLogLevel) {
        this.httpLogLevel = httpLogLevel;
        return this;
    }

    /**
     * Sets the connection timeout.
     *
     * @param timeout the timeout period
     * @param unit the unit of time
     * @return the builder
     */
    public TrustedPlatformMiddlewareBuilder connectTimeout(long timeout, TimeUnit unit) {
        connectTimeoutMillis = unit.toMillis(timeout);
        return this;
    }

    /**
     * Sets the call timeout.
     *
     * @param timeout the timeout period
     * @param unit the unit of time
     * @return the builder
     */
    public TrustedPlatformMiddlewareBuilder callTimeout(long timeout, TimeUnit unit) {
        callTimeoutMillis = unit.toMillis(timeout);
        return this;
    }

    /**
     * Sets the read timeout.
     *
     * @param timeout the timeout period
     * @param unit the unit of time
     * @return the builder
     */
    public TrustedPlatformMiddlewareBuilder readTimeout(long timeout, TimeUnit unit) {
        readTimeoutMillis = unit.toMillis(timeout);
        return this;
    }

    /**
     * Sets the write timeout.
     *
     * @param timeout the timeout period
     * @param unit the unit of time
     * @return the builder
     */
    public TrustedPlatformMiddlewareBuilder writeTimeout(long timeout, TimeUnit unit) {
        writeTimeoutMillis = unit.toMillis(timeout);
        return this;
    }

    /**
     * Sets the base URL using a string.
     *
     * @param baseUrl the string URL
     * @return the builder
     */
    public TrustedPlatformMiddlewareBuilder baseUrl(String baseUrl) {
        this.baseUrl = baseUrl == null
                ? null
                : HttpUrl.get(baseUrl);
        return this;
    }

    /**
     * Sets the base URL using a HttpUrl object.
     *
     * @param baseUrl the HttpUrl object
     * @return the builder
     */
    public TrustedPlatformMiddlewareBuilder baseUrl(HttpUrl baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    /**
     * Sets the logger provider.
     *
     * @param loggerProvider the logger provider
     * @return the builder
     */
    public TrustedPlatformMiddlewareBuilder loggerProvider(LoggerProvider loggerProvider) {
        this.loggerProvider = loggerProvider;
        return this;
    }

    /**
     * Builds and returns a Trusted Platform client.
     *
     * @return the built tp client
     */
    public TrustedPlatformMiddleware build() {
        return new TrustedPlatformMiddleware(this);
    }

    /**
     * TODO
     * @return
     */
    public Optional<HttpUrl> getBaseUrl() {
        return Optional.of(baseUrl);
    }

    /**
     * TODO
     * @return
     */
    public Optional<Level> getHttpLogLevel() {
        return Optional.of(httpLogLevel);
    }

    /**
     * TODO
     * @return
     */
    public Optional<Long> getConnectTimeoutMillis() {
        return Optional.of(connectTimeoutMillis);
    }

    /**
     * TODO
     * @return
     */
    public Optional<Long> getCallTimeoutMillis() {
        return Optional.of(callTimeoutMillis);
    }

    /**
     * TODO
     * @return
     */
    public Optional<Long> getReadTimeoutMillis() {
        return Optional.of(readTimeoutMillis);
    }

    /**
     * TODO
     * @return
     */
    public Optional<Long> getWriteTimeoutMillis() {
        return Optional.of(writeTimeoutMillis);
    }

    /**
     * TODO
     * @return
     */
    public Optional<LoggerProvider> getLoggerProvider() {
        return Optional.of(loggerProvider);
    }

}
