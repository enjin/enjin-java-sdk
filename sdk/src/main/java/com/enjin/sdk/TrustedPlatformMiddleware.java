/* Copyright 2021 Enjin Pte. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
