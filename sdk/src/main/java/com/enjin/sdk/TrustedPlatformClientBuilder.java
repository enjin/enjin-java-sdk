package com.enjin.sdk;

import com.github.dmstocking.optional.java.util.Optional;
import okhttp3.HttpUrl;
import okhttp3.logging.HttpLoggingInterceptor.Level;

import java.util.concurrent.TimeUnit;

public class TrustedPlatformClientBuilder {

    public static final HttpUrl MAIN_NET = HttpUrl.get("https://cloud.enjin.io/");
    public static final HttpUrl KOVAN = HttpUrl.get("https://kovan.cloud.enjin.io/");

    protected Optional<HttpUrl> baseUrl = Optional.empty();
    protected Optional<Level> httpLogLevel = Optional.empty();
    protected Optional<Long> connectTimeoutMillis = Optional.empty();
    protected Optional<Long> callTimeoutMillis = Optional.empty();
    protected Optional<Long> readTimeoutMillis = Optional.empty();
    protected Optional<Long> writeTimeoutMillis = Optional.empty();

    public TrustedPlatformClientBuilder httpLogLevel(Level level) {
        httpLogLevel = Optional.ofNullable(level);
        return this;
    }

    public TrustedPlatformClientBuilder connectTimeout(long timeout, TimeUnit unit) {
        connectTimeoutMillis = Optional.of(unit.toMillis(timeout));
        return this;
    }

    public TrustedPlatformClientBuilder callTimeout(long timeout, TimeUnit unit) {
        callTimeoutMillis = Optional.of(unit.toMillis(timeout));
        return this;
    }

    public TrustedPlatformClientBuilder readTimeout(long timeout, TimeUnit unit) {
        readTimeoutMillis = Optional.of(unit.toMillis(timeout));
        return this;
    }

    public TrustedPlatformClientBuilder writeTimeout(long timeout, TimeUnit unit) {
        writeTimeoutMillis = Optional.of(unit.toMillis(timeout));
        return this;
    }

    public TrustedPlatformClientBuilder baseUrl(String url) {
        baseUrl = Optional.ofNullable(url == null ? null : HttpUrl.get(url));
        return this;
    }

    public TrustedPlatformClient build() {
        return new TrustedPlatformClientImpl(this);
    }

}
