package com.enjin.sdk;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.http.SessionCookieJar;
import com.enjin.sdk.http.SimpleCallback;
import com.enjin.sdk.http.TrustedPlatformInterceptor;
import com.enjin.sdk.model.service.auth.AuthBody;
import com.enjin.sdk.model.service.auth.AuthResult;
import com.enjin.sdk.serialization.converter.GraphConverter;
import com.enjin.sdk.serialization.converter.JsonStringConverter;
import com.enjin.sdk.service.apps.AppsService;
import com.enjin.sdk.service.apps.impl.AppsServiceImpl;
import com.enjin.sdk.service.auth.AuthRetrofitService;
import com.enjin.sdk.service.balances.BalancesService;
import com.enjin.sdk.service.balances.impl.BalancesServiceImpl;
import com.enjin.sdk.service.ethereum.EthereumService;
import com.enjin.sdk.service.ethereum.impl.EthereumServiceImpl;
import com.enjin.sdk.service.identities.IdentitiesService;
import com.enjin.sdk.service.identities.impl.IdentitiesServiceImpl;
import com.enjin.sdk.service.platform.PlatformService;
import com.enjin.sdk.service.platform.impl.PlatformServiceImpl;
import com.enjin.sdk.service.requests.RequestsService;
import com.enjin.sdk.service.requests.impl.RequestsServiceImpl;
import com.enjin.sdk.service.roles.RolesService;
import com.enjin.sdk.service.roles.impl.RolesServiceImpl;
import com.enjin.sdk.service.tokens.TokensService;
import com.enjin.sdk.service.tokens.impl.TokensServiceImpl;
import com.enjin.sdk.service.users.UsersService;
import com.enjin.sdk.service.users.impl.UsersServiceImpl;
import com.github.dmstocking.optional.java.util.Optional;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.Getter;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class TrustedPlatformClient implements Closeable {

    // Trusted Platform Base URLs
    public static final HttpUrl MAIN_NET = HttpUrl.get("https://cloud.enjin.io/");
    public static final HttpUrl KOVAN = HttpUrl.get("https://kovan.cloud.enjin.io/");
    // Keys
    private static final String CLIENT_CREDENTIALS = "client_credentials";

    private HttpUrl baseUrl;
    // Http Client
    private TrustedPlatformInterceptor trustedPlatformInterceptor;
    private HttpLoggingInterceptor httpLogInterceptor;
    private OkHttpClient httpClient;
    // Services
    @Getter
    private AppsService appsService;
    @Getter
    private AuthRetrofitService authService;
    @Getter
    private BalancesService balancesService;
    @Getter
    private EthereumService ethereumService;
    @Getter
    private IdentitiesService identitiesService;
    @Getter
    private PlatformService platformService;
    @Getter
    private RequestsService requestsService;
    @Getter
    private RolesService rolesService;
    @Getter
    private TokensService tokensService;
    @Getter
    private UsersService usersService;

    private TrustedPlatformClient(Builder builder) {
        baseUrl = builder.baseUrl.orElse(MAIN_NET);
        // Cookie Jar
        SessionCookieJar cookieJar = new SessionCookieJar();

        trustedPlatformInterceptor = new TrustedPlatformInterceptor();
        httpLogInterceptor = new HttpLoggingInterceptor();
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder()
                .cookieJar(cookieJar)
                .addInterceptor(trustedPlatformInterceptor)
                .addNetworkInterceptor(httpLogInterceptor);
        if (builder.connectTimeoutMillis.isPresent())
            httpClientBuilder.connectTimeout(builder.connectTimeoutMillis.get(), TimeUnit.MILLISECONDS);
        if (builder.callTimeoutMillis.isPresent())
            httpClientBuilder.callTimeout(builder.callTimeoutMillis.get(), TimeUnit.MILLISECONDS);
        if (builder.readTimeoutMillis.isPresent())
            httpClientBuilder.readTimeout(builder.readTimeoutMillis.get(), TimeUnit.MILLISECONDS);
        if (builder.writeTimeoutMillis.isPresent())
            httpClientBuilder.writeTimeout(builder.writeTimeoutMillis.get(), TimeUnit.MILLISECONDS);
        httpClient = httpClientBuilder.build();

        httpLogInterceptor.setLevel(builder.httpLogLevel.orElse(Level.NONE));

        // Serialization
        Gson gson = new GsonBuilder()
                .serializeSpecialFloatingPointValues()
                .create();
        Converter.Factory gsonFactory = GsonConverterFactory.create(gson);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(this.baseUrl)
                .client(this.httpClient)
                .addConverterFactory(GraphConverter.create())
                .addConverterFactory(JsonStringConverter.create(gsonFactory))
                .addConverterFactory(gsonFactory)
                .build();

        this.authService = retrofit.create(AuthRetrofitService.class);
        this.platformService = new PlatformServiceImpl(retrofit);
        this.ethereumService = new EthereumServiceImpl(retrofit);
        this.appsService = new AppsServiceImpl(retrofit);
        this.rolesService = new RolesServiceImpl(retrofit);
        this.usersService = new UsersServiceImpl(retrofit);
        this.identitiesService = new IdentitiesServiceImpl(retrofit);
        this.requestsService = new RequestsServiceImpl(retrofit);
        this.tokensService = new TokensServiceImpl(retrofit);
        this.balancesService = new BalancesServiceImpl(retrofit);
    }

    public OkHttpClient getHttpClient() {
        return httpClient;
    }

    public HttpUrl getBaseUrl() {
        return baseUrl;
    }

    public void setAppId(Integer id) {
        this.trustedPlatformInterceptor.setAppId(id);
    }

    public Integer getAppId() {
        return this.trustedPlatformInterceptor.getAppId();
    }

    public void setHttpLogLevel(Level level) {
        this.httpLogInterceptor.setLevel(level == null ? Level.NONE : level);
    }

    public Level getHttpLogLevel() {
        return this.httpLogInterceptor.getLevel();
    }

    /**
     * Synchronously authenticates the trusted platform using the provided app id and secret.
     *
     * @param appId     the app id
     * @param appSecret the app secret
     *
     * @return the response
     *
     * @throws IOException if network exception is encountered
     */
    public HttpResponse<AuthResult> authAppSync(int appId, String appSecret) throws IOException {
        Call<AuthResult> call = authApp(appId, appSecret);
        Response<AuthResult> response = call.execute();

        authApp(appId, response);

        return new HttpResponse<>(response.code(), response.body());
    }

    /**
     * Aynchronously authenticates the trusted platform using the provided app id and secret and calls the callback
     * with the response result.
     *
     * @param appId     the app id
     * @param appSecret the app secret
     * @param callback  the callback
     */
    public void authAppAsync(final int appId, String appSecret, final HttpCallback<AuthResult> callback) {
        Call<AuthResult> call = authApp(appId, appSecret);

        call.enqueue(new SimpleCallback<AuthResult>() {
            @Override
            public void onResponse(Call<AuthResult> call, Response<AuthResult> response) {
                authApp(appId, response);
                if (callback != null) {
                    callback.onComplete(new HttpResponse<>(response.code(), response.body()));
                }
            }
        });
    }

    private Call<AuthResult> authApp(int appId, String appSecret) {
        return this.authService.auth(AuthBody.builder()
                                             .grantType(CLIENT_CREDENTIALS)
                                             .clientId(String.valueOf(appId))
                                             .clientSecret(appSecret)
                                             .build());
    }

    private void authApp(int appId, Response<AuthResult> response) {
        if (response.isSuccessful()) {
            AuthResult body = response.body();
            trustedPlatformInterceptor.auth(body);
            setAppId(appId);
        }
    }

    @Override
    public void close() throws IOException {
        ExecutorService executorService = this.httpClient.dispatcher()
                                                         .executorService();

        if (!executorService.isShutdown()) {
            executorService.shutdown();
        }
    }

    /**
     * Checks if the client is closed.
     *
     * @return true if the dispatcher executor service is shutdown, else false
     */
    public boolean isClosed() {
        return this.httpClient.dispatcher()
                              .executorService()
                              .isShutdown();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private Optional<HttpUrl> baseUrl = Optional.empty();
        private Optional<Level> httpLogLevel = Optional.empty();
        private Optional<Long> connectTimeoutMillis = Optional.empty();
        private Optional<Long> callTimeoutMillis = Optional.empty();
        private Optional<Long> readTimeoutMillis = Optional.empty();
        private Optional<Long> writeTimeoutMillis = Optional.empty();

        private Builder() {
        }

        public Builder httpLogLevel(Level level) {
            httpLogLevel = Optional.ofNullable(level);
            return this;
        }

        public Builder connectTimeout(long timeout, TimeUnit unit) {
            connectTimeoutMillis = Optional.of(unit.toMillis(timeout));
            return this;
        }

        public Builder callTimeout(long timeout, TimeUnit unit) {
            callTimeoutMillis = Optional.of(unit.toMillis(timeout));
            return this;
        }

        public Builder readTimeout(long timeout, TimeUnit unit) {
            readTimeoutMillis = Optional.of(unit.toMillis(timeout));
            return this;
        }

        public Builder writeTimeout(long timeout, TimeUnit unit) {
            writeTimeoutMillis = Optional.of(unit.toMillis(timeout));
            return this;
        }

        public Builder baseUrl(String url) {
            baseUrl = Optional.ofNullable(url == null ? null : HttpUrl.get(url));
            return this;
        }

        public TrustedPlatformClient build() {
            return new TrustedPlatformClient(this);
        }

    }

}
