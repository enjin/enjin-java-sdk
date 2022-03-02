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

import com.enjin.sdk.http.HttpLogLevel;
import com.enjin.sdk.models.AccessToken;
import com.enjin.sdk.schemas.project.ProjectSchema;
import com.enjin.sdk.schemas.project.queries.AuthProject;
import com.enjin.sdk.utils.LogLevel;
import com.enjin.sdk.utils.LoggerProvider;
import lombok.Getter;
import lombok.NonNull;
import lombok.Synchronized;
import okhttp3.OkHttpClient;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;

/**
 * Client for using the project schema.
 *
 * @see EnjinHosts
 */
public final class ProjectClient extends ProjectSchema implements IClient {

    /**
     * -- Getter --
     *
     * @return Whether this client is enabled for automatic reauthentication.
     */
    @Getter
    private final boolean automaticReauthenticationEnabled;

    /**
     * -- Getter --
     *
     * @return Whether the reauthentication timer is running.
     */
    @Getter(onMethod_ = @Synchronized("authMutex"))
    private boolean reauthenticationRunning = false;

    private final IAuthenticationListener authListener;
    private final Timer authTimer;

    // Auth data
    private String uuid;
    private String secret;

    // Mutexes
    private final Object authMutex = new Object();

    /**
     * Amount of time in seconds to preempt the expiration period of an access token.
     */
    private static final short PREEMPT_AUTH_EXPIRATION_TIME = 60;

    private ProjectClient(@NonNull String baseUrl,
                          boolean automaticAuthentication,
                          IAuthenticationListener authListener,
                          HttpLogLevel logLevel,
                          LoggerProvider loggerProvider) {
        super(new TrustedPlatformMiddleware(baseUrl, logLevel, loggerProvider), loggerProvider);

        this.authListener = authListener;

        automaticReauthenticationEnabled = automaticAuthentication;
        if (automaticReauthenticationEnabled)
            authTimer = new Timer();
        else
            authTimer = null;
    }

    /**
     * {@inheritDoc}
     * <p>
     * If this client has automatic reauthentication enabled, then this method will halt the reauthentication timer.
     * </p>
     */
    @Override
    public void auth(String token) {
        auth(token, null);
    }

    /**
     * Authenticates the client using the given access token model.
     * <p>
     * If this client has automatic reauthentication enabled, then this method may halt the reauthentication timer when
     * {@code accessToken} is null. Otherwise the timer will be restarted.
     * </p>
     *
     * @param accessToken The access token.
     *
     * @throws IllegalArgumentException If {@code accessToken} is not null and either its
     *                                  {@link AccessToken#getToken()} method or {@link AccessToken#getExpiresIn()}
     *                                  method returns null.
     */
    public void auth(AccessToken accessToken) throws IllegalArgumentException {
        if (accessToken == null) {
            auth(null, null);
        } else {
            String token = accessToken.getToken();
            Long expiresIn = accessToken.getExpiresIn();
            if (token == null || expiresIn == null)
                throw new IllegalArgumentException("Non-null access token cannot have null token or expiration data.");

            auth(token, expiresIn);
        }
    }

    /**
     * Sends a request to the platform to authenticate this client.
     * <p>
     * If this client is enabled for automatic reauthentication, then it will cache the UUID and secret and
     * reauthenticate itself before the {@link AccessToken} returned by the platform expires.
     * </p>
     *
     * @param uuid   The project's UUID.
     * @param secret The project's secret.
     *
     * @return The future for this operation.
     *
     * @throws IllegalStateException If this client is closed at the time this method is called.
     */
    public CompletableFuture<Void> authClient(@NonNull String uuid,
                                              @NonNull String secret) throws IllegalStateException {
        if (isClosed())
            throw new IllegalStateException("Cannot authenticate after client was closed.");

        if (isAutomaticReauthenticationEnabled()) {
            synchronized (authMutex) {
                this.uuid = uuid;
                this.secret = secret;
            }
        }

        return sendRequestAndAuth(uuid, secret);
    }

    @Override
    public void close() {
        synchronized (authMutex) {
            if (authTimer != null) {
                authTimer.cancel();
                reauthenticationRunning = false;
            }
        }

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

    private void auth(String token, Long expiresIn) {
        boolean timerRestarted = false;
        synchronized (authMutex) {
            if (isAutomaticReauthenticationEnabled() && uuid != null && secret != null)
                timerRestarted = restartAuthenticationTimer(expiresIn);
        }

        middleware.getTrustedPlatformInterceptor().setToken(token);

        if (authListener != null && authTimer != null && !timerRestarted)
            authListener.onAutomaticReauthenticationStopped();
    }

    private boolean restartAuthenticationTimer(Long expiresIn) {
        authTimer.purge();
        reauthenticationRunning = false;

        if (expiresIn == null || expiresIn <= 0)
            return false;

        if (expiresIn - PREEMPT_AUTH_EXPIRATION_TIME > 0)
            expiresIn -= PREEMPT_AUTH_EXPIRATION_TIME;

        authTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                sendRequestAndAuth();
            }
        }, expiresIn * 1000 /* Convert to milliseconds */);
        reauthenticationRunning = true;

        return true;
    }

    private CompletableFuture<Void> sendRequestAndAuth(@NonNull String uuid, @NonNull String secret) {
        AuthProject req = new AuthProject().uuid(uuid).secret(secret);
        return authProject(req).handle((res, e) -> {
            if (e != null) {
                LoggerProvider loggerProvider = getLoggerProvider();
                if (loggerProvider != null)
                    loggerProvider.log(LogLevel.ERROR, "Automatic AuthProject request failed.", new Exception(e));

                throw new CompletionException(e);
            }

            if (res.isSuccess())
                auth(res.getData());
            else
                auth(null, null);

            return null;
        });
    }

    private void sendRequestAndAuth() {
        String uuid;
        String secret;
        synchronized (authMutex) {
            if (this.uuid == null || this.secret == null)
                throw new IllegalStateException("UUID or secret are null while attempting reauthentication.");

            uuid = this.uuid;
            secret = this.secret;
        }

        sendRequestAndAuth(uuid, secret);
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

        private IAuthenticationListener authListener;
        private String baseUri;
        private Boolean automaticAuthentication;
        private HttpLogLevel httpLogLevel = HttpLogLevel.NONE;
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

            return new ProjectClient(baseUri,
                                     Boolean.TRUE.equals(automaticAuthentication),
                                     authListener,
                                     httpLogLevel,
                                     loggerProvider);
        }

        /**
         * Sets the authentication listener the client will be using.
         *
         * @param listener The listener.
         *
         * @return This builder for chaining.
         */
        public ProjectClientBuilder authenticationListener(IAuthenticationListener listener) {
            authListener = listener;
            return this;
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
         * Enables the client to automatically reauthenticate itself when authenticated through its
         * {@link ProjectClient#authClient} method.
         *
         * @return This builder for chaining.
         */
        public ProjectClientBuilder enableAutomaticReauthentication() {
            automaticAuthentication = true;
            return this;
        }

        /**
         * Sets the log level for HTTP traffic.
         *
         * @param logLevel The log level.
         *
         * @return This builder for chaining.
         */
        public ProjectClientBuilder httpLogLevel(HttpLogLevel logLevel) {
            httpLogLevel = logLevel;
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
