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
public class TrustedPlatformClientBuilder {

    /**
     * The url for the main Enjin cloud.
     */
    public static final HttpUrl MAIN_NET = HttpUrl.get("https://cloud.enjin.io/");
    /**
     * The url for the kovan Enjin cloud.
     */
    public static final HttpUrl KOVAN = HttpUrl.get("https://kovan.cloud.enjin.io/");

    /**
     * The base url to use in the built Trusted Platform client.
     */
    protected Optional<HttpUrl> baseUrl = Optional.empty();
    /**
     * The http log level to use in the built Trusted Platform client.
     */
    protected Optional<Level> httpLogLevel = Optional.empty();
    /**
     * The connection timeout to use in the built Trusted Platform client.
     */
    protected Optional<Long> connectTimeoutMillis = Optional.empty();
    /**
     * The call timeout to use in the built Trusted Platform client.
     */
    protected Optional<Long> callTimeoutMillis = Optional.empty();
    /**
     * The read timeout to use in the built Trusted Platform client.
     */
    protected Optional<Long> readTimeoutMillis = Optional.empty();
    /**
     * The write timeout to use in the built Trusted Platform client.
     */
    protected Optional<Long> writeTimeoutMillis = Optional.empty();
    /**
     * The logger provider to use in the built Trusted Platform client.
     */
    protected Optional<LoggerProvider> loggerProvider = Optional.empty();

    /**
     * Sets the http log level.
     *
     * @param level the log level
     * @return      the builder
     */
    public TrustedPlatformClientBuilder httpLogLevel(Level level) {
        httpLogLevel = Optional.ofNullable(level);
        return this;
    }

    /**
     * Sets the connection timeout.
     *
     * @param timeout the timeout period
     * @param unit    the unit of time
     * @return        the builder
     */
    public TrustedPlatformClientBuilder connectTimeout(long timeout, TimeUnit unit) {
        connectTimeoutMillis = Optional.of(unit.toMillis(timeout));
        return this;
    }

    /**
     * Sets the call timeout.
     *
     * @param timeout the timeout period
     * @param unit    the unit of time
     * @return        the builder
     */
    public TrustedPlatformClientBuilder callTimeout(long timeout, TimeUnit unit) {
        callTimeoutMillis = Optional.of(unit.toMillis(timeout));
        return this;
    }

    /**
     * Sets the read timeout.
     *
     * @param timeout the timeout period
     * @param unit    the unit of time
     * @return        the builder
     */
    public TrustedPlatformClientBuilder readTimeout(long timeout, TimeUnit unit) {
        readTimeoutMillis = Optional.of(unit.toMillis(timeout));
        return this;
    }

    /**
     * Sets the write timeout.
     *
     * @param timeout the timeout period
     * @param unit    the unit of time
     * @return        the builder
     */
    public TrustedPlatformClientBuilder writeTimeout(long timeout, TimeUnit unit) {
        writeTimeoutMillis = Optional.of(unit.toMillis(timeout));
        return this;
    }

    /**
     * Sets the base url using a string.
     *
     * @param url the string url
     * @return    the builder
     */
    public TrustedPlatformClientBuilder baseUrl(String url) {
        baseUrl = Optional.ofNullable(url == null ? null : HttpUrl.get(url));
        return this;
    }

    /**
     * Sets the base url using a HttpUrl class.
     *
     * @param url the HttpUrl object
     * @return    the builder
     */
    public TrustedPlatformClientBuilder baseUrl(HttpUrl url) {
        baseUrl = Optional.ofNullable(url);
        return this;
    }

    /**
     * Sets the logger provider.
     *
     * @param provider the logger provider
     * @return         the builder
     */
    public TrustedPlatformClientBuilder loggerProvider(LoggerProvider provider) {
        loggerProvider = Optional.ofNullable(provider);
        return this;
    }

    /**
     * Builds and returns a Trusted Platform client.
     *
     * @return the built tp client
     */
    public TrustedPlatformClient build() {
        return new TrustedPlatformClientImpl(this);
    }

}
