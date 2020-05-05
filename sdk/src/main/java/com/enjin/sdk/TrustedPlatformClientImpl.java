package com.enjin.sdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpCallback;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.http.SessionCookieJar;
import com.enjin.sdk.http.TrustedPlatformInterceptor;
import com.enjin.sdk.models.app.AuthApp;
import com.enjin.sdk.models.AccessToken;
import com.enjin.sdk.serialization.converter.GraphConverter;
import com.enjin.sdk.serialization.converter.JsonStringConverter;
import com.enjin.sdk.services.app.AppsService;
import com.enjin.sdk.services.app.impl.AppsServiceImpl;
import com.enjin.sdk.services.balance.BalancesService;
import com.enjin.sdk.services.balance.impl.BalancesServiceImpl;
import com.enjin.sdk.services.identity.IdentitiesService;
import com.enjin.sdk.services.identity.impl.IdentitiesServiceImpl;
import com.enjin.sdk.services.platform.PlatformService;
import com.enjin.sdk.services.platform.impl.PlatformServiceImpl;
import com.enjin.sdk.services.request.RequestsService;
import com.enjin.sdk.services.request.impl.RequestsServiceImpl;
import com.enjin.sdk.services.token.TokensService;
import com.enjin.sdk.services.token.impl.TokensServiceImpl;
import com.enjin.sdk.services.user.UsersService;
import com.enjin.sdk.services.user.impl.UsersServiceImpl;
import com.enjin.sdk.services.wallet.WalletService;
import com.enjin.sdk.services.wallet.impl.WalletServiceImpl;
import com.enjin.sdk.utils.LoggerProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.Getter;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Implementation class of the {@link TrustedPlatformClient}.
 *
 * @see TrustedPlatformClient
 * @see TrustedPlatformClientBuilder
 */
public final class TrustedPlatformClientImpl implements TrustedPlatformClient {

    // Keys
    private static final String CLIENT_CREDENTIALS = "client_credentials";

    private HttpUrl baseUrl;
    private LoggerProvider loggerProvider;
    // Http Client
    private TrustedPlatformInterceptor trustedPlatformInterceptor;
    private HttpLoggingInterceptor httpLogInterceptor;
    private OkHttpClient httpClient;
    // Services
    /**
     * -- GETTER --
     * Returns the applications service.
     *
     * @return the app service
     */
    @Getter
    private AppsService appService;
    /**
     * -- GETTER --
     * Returns the balances service.
     *
     * @return the balance service
     */
    @Getter
    private BalancesService balanceService;
    /**
     * -- GETTER --
     * Returns the identities service.
     *
     * @return the identity service
     */
    @Getter
    private IdentitiesService identityService;
    /**
     * -- GETTER --
     * Returns the platform service.
     *
     * @return the platform service
     */
    @Getter
    private PlatformService platformService;
    /**
     * -- GETTER --
     * Returns the requests service.
     *
     * @return the requests service
     */
    @Getter
    private RequestsService requestService;
    /**
     * -- GETTER --
     * Returns the tokens service.
     *
     * @return the token service
     */
    @Getter
    private TokensService tokenService;
    /**
     * -- GETTER --
     * Returns the users service.
     *
     * @return the user service
     */
    @Getter
    private UsersService userService;
    /**
     * -- GETTER --
     * Returns the wallet service.
     *
     * @return the wallet service
     */
    @Getter
    private WalletService walletService;

    /**
     * Constructs the Trusted Platform client using the provided builder.
     *
     * @param builder the tp client builder
     */
    TrustedPlatformClientImpl(TrustedPlatformClientBuilder builder) {
        baseUrl = builder.baseUrl.orElse(TrustedPlatformClientBuilder.MAIN_NET);
        loggerProvider = builder.loggerProvider.orElse(new LoggerProvider(Logger.getGlobal()));
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

        this.platformService = new PlatformServiceImpl(retrofit);
        this.appService = new AppsServiceImpl(retrofit);
        this.userService = new UsersServiceImpl(retrofit);
        this.identityService = new IdentitiesServiceImpl(retrofit);
        this.requestService = new RequestsServiceImpl(retrofit);
        this.tokenService = new TokensServiceImpl(retrofit);
        this.balanceService = new BalancesServiceImpl(retrofit);
        this.walletService = new WalletServiceImpl(retrofit);
    }

    /**
     * Returns the http client.
     *
     * @return the http client
     */
    public OkHttpClient getHttpClient() {
        return httpClient;
    }

    /**
     * Returns the base url.
     *
     * @return the base url
     */
    public HttpUrl getBaseUrl() {
        return baseUrl;
    }

    @Override
    public void setAppId(Integer id) {
        this.trustedPlatformInterceptor.setAppId(id);
    }

    @Override
    public Integer getAppId() {
        return this.trustedPlatformInterceptor.getAppId();
    }

    /**
     * Sets the http log level.
     *
     * @param level the http log level
     */
    public void setHttpLogLevel(Level level) {
        this.httpLogInterceptor.setLevel(level == null ? Level.NONE : level);
    }

    /**
     * Returns the http log level.
     *
     * @return the http log level
     */
    public Level getHttpLogLevel() {
        return this.httpLogInterceptor.getLevel();
    }

    /**
     * Synchronously authenticates the trusted platform using the provided app id and secret.
     *
     * @param appId     the app id
     * @param appSecret the app secret
     * @return          the response
     */
    @Override
    public HttpResponse<GraphQLResponse<AccessToken>> authAppSync(int appId, String appSecret) {
        HttpResponse<GraphQLResponse<AccessToken>> httpResponse = appService.authAppSync(new AuthApp().id(appId)
                                                                                                      .secret(appSecret));
        authApp(appId, httpResponse);
        return httpResponse;
    }

    /**
     * Asynchronously authenticates the trusted platform using the provided app id and secret and calls the callback
     * with the response result.
     *
     * @param appId     the app id
     * @param appSecret the app secret
     * @param callback  the callback
     */
    @Override
    public void authAppAsync(int appId,
                             String appSecret,
                             HttpCallback<GraphQLResponse<AccessToken>> callback) {
        appService.authAppAsync(new AuthApp().id(appId).secret(appSecret),
                                response -> {
                                    authApp(appId, response);
                                    callback.onComplete(response);
                                });
    }

    @Override
    public boolean isAuthenticated() {
        return trustedPlatformInterceptor.isAuthenticated();
    }

    private void authApp(int appId, HttpResponse<GraphQLResponse<AccessToken>> response) {
        if (response.isSuccess() && response.body().isSuccess()) {
            AccessToken body = response.body().getData();
            trustedPlatformInterceptor.auth(body);
            setAppId(appId);
        }
    }

    @Override
    public void close() {
        ExecutorService executorService = this.httpClient.dispatcher()
                                                         .executorService();

        if (!executorService.isShutdown()) {
            executorService.shutdown();
            httpClient.connectionPool().evictAll();
        }
    }

    @Override
    public boolean isClosed() {
        return this.httpClient.dispatcher()
                              .executorService()
                              .isShutdown();
    }
}
