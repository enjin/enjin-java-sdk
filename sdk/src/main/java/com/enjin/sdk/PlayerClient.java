/* Copyright 2021 Enjin Pte Ltd.
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

import com.enjin.sdk.schemas.player.PlayerSchema;
import com.enjin.sdk.utils.LoggerProvider;
import lombok.NonNull;
import okhttp3.OkHttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Client for using the player schema.
 *
 * @see EnjinHosts
 */
public final class PlayerClient extends PlayerSchema implements IClient {

    /**
     * Constructs a client with the targeted URL and default settings.
     *
     * @param baseUrl the base URL
     */
    public PlayerClient(@NonNull String baseUrl) {
        this(baseUrl, false);
    }

    /**
     * Constructs a client with the targeted URL, debugging state.
     *
     * @param baseUrl the base URL
     * @param debug whether debugging is enabled
     */
    public PlayerClient(@NonNull String baseUrl, boolean debug) {
        this(baseUrl, debug, null);
    }

    /**
     * Constructs a client with the targeted settings.
     *
     * @param baseUrl the base URL
     * @param debug whether debugging is enabled
     * @param loggerProvider the logger provider
     */
    public PlayerClient(@NonNull String baseUrl, boolean debug, LoggerProvider loggerProvider) {
        super(new TrustedPlatformMiddleware(baseUrl, debug), loggerProvider);
    }

    @Override
    public void auth(String token) {
        middleware.getTrustedPlatformInterceptor().setToken(token);
    }

    @Override
    public void close() {
        OkHttpClient httpClient = middleware.getHttpClient();
        ExecutorService executorService = httpClient.dispatcher().executorService();
        if (!executorService.isShutdown()) {
            executorService.shutdown();
            httpClient.connectionPool().evictAll();
        }
    }

    @Override
    public boolean isAuthenticated() {
        return middleware.getTrustedPlatformInterceptor().isAuthenticated();
    }

    @Override
    public boolean isClosed() {
        return middleware.getHttpClient()
                         .dispatcher()
                         .executorService()
                         .isShutdown();
    }

}
