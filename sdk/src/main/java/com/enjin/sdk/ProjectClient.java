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

import com.enjin.sdk.schemas.project.ProjectSchema;
import com.enjin.sdk.utils.LoggerProvider;
import lombok.NonNull;
import okhttp3.OkHttpClient;

import java.util.concurrent.ExecutorService;

/**
 * Client for using the project schema.
 *
 * @see EnjinHosts
 */
public final class ProjectClient extends ProjectSchema implements IClient {

    private ProjectClient(@NonNull String baseUrl, boolean debug, LoggerProvider loggerProvider) {
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

    /**
     * Creates a builder for this class.
     *
     * @return The builder.
     */
    public static ProjectClientBuilder builder() {
        return new ProjectClientBuilder();
    }

    /**
     * Builder class for {@link ProjectClient}.
     */
    public static class ProjectClientBuilder {

        private String baseUri;
        private boolean debugEnabled = false;
        private LoggerProvider loggerProvider;

        private ProjectClientBuilder() {
        }

        /**
         * Builds the client.
         *
         * @return The client.
         *
         * @throws IllegalStateException Thrown if the base URI is a null value at the time this method is called.
         */
        public ProjectClient build() throws IllegalStateException {
            if (baseUri == null)
                throw new IllegalStateException(String.format("Cannot build %s with null base URI",
                                                              ProjectClient.class.getName()));

            return new ProjectClient(baseUri, debugEnabled, loggerProvider);
        }

        /**
         * Sets the base URI the client will be using.
         *
         * @param baseUri The base URI.
         *
         * @return This builder for chaining.
         *
         * @see EnjinHosts
         */
        public ProjectClientBuilder baseUri(String baseUri) {
            this.baseUri = baseUri;
            return this;
        }

        /**
         * Sets whether debugging will be set for the client.
         *
         * @param enabled Whether debugging is enabled for the client.
         *
         * @return This builder for chaining.
         */
        public ProjectClientBuilder debugEnabled(boolean enabled) {
            debugEnabled = enabled;
            return this;
        }

        /**
         * Sets the logger provider for the client to use.
         *
         * @param loggerProvider The logger provider.
         *
         * @return This builder for chaining.
         */
        public ProjectClientBuilder loggerProvider(LoggerProvider loggerProvider) {
            this.loggerProvider = loggerProvider;
            return this;
        }

    }

}
